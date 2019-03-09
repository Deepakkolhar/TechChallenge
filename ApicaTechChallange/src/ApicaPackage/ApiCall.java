package ApicaPackage;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiCall {
	
	@SuppressWarnings("deprecation")
	public static void getApp(String API_URL, String userName, String password) throws ClientProtocolException, IOException {
       
        HttpGet httpget = new HttpGet(API_URL);

        HttpClient client = HttpClientBuilder.create().build(); 

        String userPassword = userName + ":" + password;
        
        byte[] encodeBase64 = Base64.encodeBase64(userPassword.getBytes());     
        httpget.addHeader("Authorization", "BASIC " + new String(encodeBase64)); 
          
        System.out.println("executing request: " + httpget.getRequestLine());

        HttpResponse response = client.execute(httpget); 
  
        HttpEntity entity = response.getEntity(); 

        int statusCode = response.getStatusLine().getStatusCode(); 
              
       // System.out.println(statusCode);

        if(statusCode == 200){
        	
        	 System.out.println("HTTP response code is: "+statusCode);
        	
        	 StringWriter writer = new StringWriter(); 
             IOUtils.copy(entity.getContent(), writer); 
             
             String payload = writer.toString(); 
        //   System.out.println(payload);

             if(payload.contains("\"enabled\":true")){
         	
         	   System.out.println("check has the enabled property: true");
            }
 	
        }
    }
}
