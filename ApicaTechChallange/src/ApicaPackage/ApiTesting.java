package ApicaPackage;

public class ApiTesting {

	public static void main(String args[]) throws Exception {
                
   	 String API_URL = "https://api-wpm-trial.apicasystem.com/v3/Checks/44668?auth_ticket=705DE727-8F88-44F5-B34D-D94443787F9F";
   	 String userName = "admin@DeepakKolhar";
   	 String password = "password";
   	 
   	 
        ApiCall.getApp(API_URL,userName,password);

    }
}
	
	
	
	
	
	
	
	//	private static String API_URL = "https://api-wpm-trial.apicasystem.com/v3/Checks/44668?auth_ticket=705DE727-8F88-44F5-B34D-D94443787F9F";
//
//    @SuppressWarnings("deprecation")
//	public void getApp() throws ClientProtocolException, IOException {
//
//        HttpGet httpget = new HttpGet(API_URL);
//
//        HttpClient client = HttpClientBuilder.create().build(); 
//
//        String userPassword = "admin@DeepakKolhar" + ":" + "password";
//        
//        byte[] encodeBase64 = Base64.encodeBase64(userPassword.getBytes());     
//        httpget.addHeader("Authorization", "BASIC " + new String(encodeBase64)); 
//          
//        System.out.println("executing request: " + httpget.getRequestLine());
//
//        HttpResponse response = client.execute(httpget); 
//  
//        HttpEntity entity = response.getEntity(); 
//
//        int statusCode = response.getStatusLine().getStatusCode(); 
//        System.out.println(statusCode);
//
//        StringWriter writer = new StringWriter(); 
//        IOUtils.copy(entity.getContent(), writer); 
//        
//        String payload = writer.toString(); 
//        System.out.println(payload);
//
//        if(payload.contains("\"enabled\":true")){
//    	
//    	   System.out.println("check has the enabled property: true");
//       }
//    }

    