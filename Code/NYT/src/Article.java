import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Article extends Thread
{
  private final HttpGet httpget;
  private final HttpClient httpClient;
  private final HttpContext context;
  private String text;
  private String date;
  private String title;

  public Article(String title, HttpGet httpget)
  {
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(
      new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

    ClientConnectionManager cm = new ThreadSafeClientConnManager(schemeRegistry);
    this.httpClient = new DefaultHttpClient(cm);
    this.context = new BasicHttpContext();
    this.httpget = httpget;
    this.title = title;
  }

  public void run()
  {
    try {
      HttpResponse response = this.httpClient.execute(this.httpget, this.context);
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        InputStream instream = entity.getContent();
        try {
          String content = EntityUtils.toString(entity);
          Document doc = Jsoup.parse(content);
          this.date = getHttpDate(doc);
          this.text = getHttpText(doc);
        }
        finally
        {
          instream.close();
        }

      }

      EntityUtils.consume(entity);
    } catch (Exception ex) {
      ex.printStackTrace();
      this.httpget.abort();
    }
  }

 

  private String getHttpText(Document doc) throws IOException 
  {
    String result = "";

    for (Element e : doc.select("div[class=articleBody]")) {
      result = result + e.text();
    } for (Element e : doc.select("div[id=articleBody]")) {
      result = result + e.text();
    } for (Element e : doc.select("div[class=entry-content]")) {
      result = result + e.text();
    } for (Element e : doc.select("p[class=summaryText]")) {
      result = result + e.text();
    } for (Element e : doc.select("div[class=abstractSummary]")){
  		result = result + e.text();
    }
     if (result.equals("")) 
    	{ for (Element e : doc.select("nyt_text")) {
        result = result + e.text();
    	} 
    }
     if (result.equals("")) 
    	{ for (Element p : doc.select("p")){
	  			  result = result +p.text();
	  			}
    	} 
     /*if  ((doc.select("td > a[href]"))!=null){
  		  try{
  			  for(Element e : doc.select("td > a[href]")) {
  			  	System.out.println("commercial : " + String.format("http://www.nytimes.com"+e.attr("href").toString()));
			  	Document dc = Jsoup.connect(String.format("http://www.nytimes.com"+e.attr("href").toString())).get();
			  	
			  	for (Element a : dc.select("div[class=articleBody]")) {
			        result = result + a.text();
			      } for (Element a : dc.select("div[id=articleBody]")) {
			        result = result + a.text();
			      } for (Element a : dc.select("div[class=entry-content]")) {
			        result = result + a.text();
			      }
			      
			      if (result.equals(""))
			      {  
			    	  for (Element a : dc.select("nyt_text")) {
				        result = result + a.text();
				      }
			      }
			      
			      if (result.equals(""))
			      {
			    	  for (Element a : dc.select("p")){
			    		  result = result + a.text();
			    	  }
			      }
  		  	}
  		  }catch(MalformedURLException e){
			  e.printStackTrace();
			  e.getCause();
			  System.out.println("Redirected to a commercial page");
  		  }
  	    }*/ else {
  	    	System.out.println("Empty Article : " + httpget.getURI().toString());	
  	    }
    

    return result;
  }

  public String getText()
  {
    return this.text;
  }

  public String getTitle()
  {	
    return this.title;
  }

 
@SuppressWarnings("unused")
private static String trim(String s, int width)
  {
    if (s.length() > width) {
      return s.substring(0, width - 1) + ".";
    }
    return s;
  }

  public String getDate() {
    return this.date;
  }
  private String getHttpDate(Document doc)
  throws IOException
{
  String result = "";

  	for (Element e : doc.select("span[class=date]")) {
  	  result = result + e.text();
  } for (Element e : doc.select("h6[class=dateline]")) {
	  result = result + e.text();
  }	for (Element e : doc.select("div[class=timestamp]")) {
	  result = result + e.text();
  } for (Element e: doc.select("font[class=publishDate]")) {
	  result = result + e.text();
  } for (Element e : doc.select("font[class=footer]")) {
	  result = result + e.text();
  } for (Element e : doc.select("span[class=pubdate]")) {
	  result = result + e.text();
  } 

  if (result.equals("")) {
	 	 for (Element e : doc.select("meta[name=dat]")){
		  result = result + e.attr("content").toString();
		  }
	 	} 
	 
	  if  ((doc.select("td > a[href]"))!=null)
	  {
		  try
		  {
			  for(Element e : doc.select("td > a[href]")) 
			  {
				  System.out.println("commercial : " + String.format("http://www.nytimes.com"+e.attr("href").toString()));
				  Document dc = Jsoup.connect(String.format("http://www.nytimes.com"+e.attr("href").toString())).get();
				  		
				  		for (Element a : dc.select("span[class=date]")) {
			  				result = result + a.text();
			  		} 	for (Element a : dc.select("h6[class=dateline]")) {
			  				result = result + a.text();
			  		}	for (Element a : dc.select("div[class=timestamp]")) {
			  				result = result + a.text();
			  		}
			   }
			  
		  } catch(MalformedURLException e){
			  e.printStackTrace();
			  e.getCause();
			  System.out.println("Redirected to a commercial page");
		  }
		  
	  }  else {
    System.out.println("Empty Date : " + httpget.getURI().toString());
	  }
  
  return result;
	}
}