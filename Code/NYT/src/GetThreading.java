import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.jdom.output.XMLOutputter;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class GetThreading extends Thread
{
  private HttpClient httpClient;
  private BasicHttpContext context;
  private HttpGet httpget;
  private String company;


  public GetThreading(HttpClient httpClient, HttpGet httpget, String company)
  {
    this.httpClient = httpClient;
    this.context = new BasicHttpContext();
    this.httpget = httpget;
    this.company = company;
  }

  public void run()
  {
    org.jdom.Element root = new org.jdom.Element("root");
    root.setAttribute("company", this.company);

    for (int i = 0; i <= 9; i++)
    {
      HttpGet h = new HttpGet(this.httpget.getURI().toString().concat(String.format("?offset=%s0&amp;s=newest", new Object[] { Integer.valueOf(i) })));
      try
      {
        HttpResponse response = this.httpClient.execute(h, this.context);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          InputStream instream = entity.getContent();
          try
          {
            String content = EntityUtils.toString(entity);
            org.jsoup.nodes.Document doc = Jsoup.parse(content);
            Elements links = doc.select("div[class=columnGroup] > div[class=story clearfix] > h5 > a[href]");
             
            org.jdom.Element p = new org.jdom.Element("page");
            p.setAttribute("index", String.valueOf(i + 1));

            Article[] threads = new Article[links.size()];

            for (int j = 0; j < links.size(); j++) {
              org.jsoup.nodes.Element link =links.get(j);
              HttpGet hg = new HttpGet(String.format(link.attr("abs:href"), new Object[] { trim(link.text(), 35) }));
              threads[j] = new Article(link.text(), hg);

              threads[j].start();
            }

            root.addContent(p);

            for (int j = 0; j < links.size(); j++) {
              threads[j].join();

              org.jdom.Element article = new org.jdom.Element("article");
              org.jdom.Element date = new org.jdom.Element("date");
              org.jdom.Element text = new org.jdom.Element("text");

              article.setAttribute("index", String.valueOf(j + 1));
              article.setAttribute("href", String.format(links.get(j).attr("abs:href"), new Object[] { trim(links.get(j).text(), 35) }));

              System.out.println("Just done: " + threads[j].getTitle());

              article.setText(threads[j].getTitle());
              date.setText(threads[j].getDate());
              text.setText(threads[j].getText());

              article.addContent(date);
              article.addContent(text);
              p.addContent(article);
            }
          } finally {
            instream.close();
          }

        }

        EntityUtils.consume(entity); } catch (Exception ex) {
        h.abort();
      }

    }

    org.jdom.Document Doc = new org.jdom.Document(root);
    try
    {
      FileOutputStream out = new FileOutputStream(String.format("//home//tommaso//Documents//Java//Test//Nyt//%s.xml", new Object[] { this.company }));
      XMLOutputter serializer = new XMLOutputter();
      serializer.output(Doc, out);
      out.flush();
      out.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }



  public synchronized String getText(org.jsoup.nodes.Element link)
    throws IOException
  {
    org.jsoup.nodes.Document doc = Jsoup.connect(String.format(link.attr("abs:href"), new Object[] { trim(link.text(), 35) })).get();
    Elements lnk = doc.select("li[class=print] > a[href]");
    org.jsoup.nodes.Document textArticle = Jsoup.connect(String.format(lnk.attr("abs:href"), new Object[] { trim(lnk.text(), 35) })).get();

    if (textArticle.select("div[class=articleBody]") != null) {
      return textArticle.select("div[class=articleBody]").text();
    }
    if (textArticle.select("div[class=entry-content]") != null) {
      return textArticle.select("div[class=entry-content]").text();
    }

    return textArticle.text();
  }
  
  
  private static String trim(String s, int width)
  {
    if (s.length() > width) {
      return s.substring(0, width - 1) + ".";
    }
    return s;
  }
}