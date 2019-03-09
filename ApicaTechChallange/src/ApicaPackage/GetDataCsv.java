package ApicaPackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetDataCsv {
	
	public static String getdata(int numUsers) throws Exception{
		
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader("C:\\Users\\Deepak\\Desktop\\DeleteUser.csv"));
	
		String GetData= reader.readLine();
		
		for(int i=1;i<=numUsers;i++){
				
				GetData=GetData +';'+reader.readLine();
			}
		
		reader.close();
	
	return GetData;
	}
		
}
