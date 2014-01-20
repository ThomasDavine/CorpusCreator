import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public class Main
{
  public static void main(String[] args)
    throws InterruptedException
  {
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(
      new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

    ClientConnectionManager cm = new ThreadSafeClientConnManager(schemeRegistry);
    HttpClient httpClient = new DefaultHttpClient(cm);

    String[] company = {""};
    Urls urisToGet = new Urls(company);

    GetThreading[] threads = new GetThreading[urisToGet.getUrl(company).size()];

    for (int i = 0; i < threads.length; i++) {
      HttpGet httpget = new HttpGet((String)urisToGet.getUrl(company).get(i));
      threads[i] = new GetThreading(httpClient, httpget, company[i]);
    }

    for (int j = 0; j < threads.length; j++) {
      threads[j].start();
    }

    for (int j = 0; j < threads.length; j++) {
      threads[j].join();
    }
    System.out.println(Thread.getAllStackTraces());
    
    
  }
}