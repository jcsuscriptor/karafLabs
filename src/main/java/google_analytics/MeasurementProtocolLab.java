package google_analytics;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.brsanthu.googleanalytics.GoogleAnalytics;
import com.brsanthu.googleanalytics.GoogleAnalyticsConfig;
import com.brsanthu.googleanalytics.request.EventHit;
 
public class MeasurementProtocolLab {
	
   private static GoogleAnalytics ga = null;

    // assumes the current class is called MyLogger
	private final static Logger LOGGER = Logger.getLogger(MeasurementProtocolLab.class.getName());
	
    
	public static void main(String[] args) {
	    try {
	    	
	    	 LOGGER.log(Level.INFO, "Enviar informacion Google Analytics....");
	    	
	    	 ga = GoogleAnalytics.builder()
	    			 .withConfig(new GoogleAnalyticsConfig().setDiscoverRequestParameters(true))
	    			 .withTrackingId("UA-4600624-4")
	    			 .withAppName("AppName.Foo").withAppVersion("1.0.0")
	    			 
	    			 .build();
	    	 
	    	 LOGGER.log(Level.INFO, "Enviar informacion Paginas....");
	    	 
	    	 ga.pageView("http://www.google.com", "Search").send();
	         ga.pageView("http://www.google.com", "Search").sendAsync();
	         
	         ga.pageView()
	         .documentTitle("Titulo.Pagina")
	         .documentPath("http://www.url.pagina.com")
	         .clientId("Client.id.foo")
	         .send();
	         
	         LOGGER.log(Level.INFO, "Enviar Evento....");
	         
	         ga.event()
	         .eventCategory("Java.Categoria")
	         .eventAction("Java.Action")
	         .eventLabel("Java.Label")
	         .eventValue(10)
	         .send();
	         
	         
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
