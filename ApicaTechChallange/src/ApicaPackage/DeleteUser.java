package ApicaPackage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ApicaPackage.GetDataCsv;

public class DeleteUser {

	
	private static WebElement element = null;
	
	//Manage Button
	public static WebElement Manage_Button(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"HeaderMenu\"]/div[4]/div[1]"));
	return element;
	}
	
	//User Button
		public static WebElement Manage_User_Button(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id=\"HeaderMenu\"]/div[4]/div[2]/a[4]"));
		return element;
		}

		//Delete Button
		public static WebElement Delete_User_Button(WebDriver driver) {
			element = driver.findElement(By.id("delete-user-btn"));	
		return element;
		}

		
		//*********************************************************//		
		//******************Delete User Logic**********************//		
		//*********************************************************//
				
				public static void deleteUser(WebDriver driver,int numUsers) throws Exception {
					

				int Temp_Rowcount;
				int Rowcount;
				String GetData = GetDataCsv.getdata(numUsers);
		//		System.out.println("GetData"+GetData);
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Deepak\\Desktop\\DeleteUserOutput.csv"));
				String outStatus = "UserName,Status";
				writer.append(outStatus);
				writer.newLine();
				String[] inputData = GetData.split(";");
				
				for(int a=1;a<=numUsers;a++){
					
			//	System.out.println(inputData[a]);
				driver.findElement(By.xpath("//*[@id=\"HeaderMenu\"]/div[4]/div[1]")).click();
		        driver.findElement(By.xpath("//*[@id=\"HeaderMenu\"]/div[4]/div[2]/a[4]")).click();
		        
				Temp_Rowcount = driver.findElements(By.xpath("//*[@id=\"usertable\"]/tbody/tr")).size();
				Rowcount = (Temp_Rowcount/2)-1;
				String userPresent = "N";
				
				for(int i=1;i<=Rowcount;i++){
					int j = (i*2)+1;
						WaitClass.Waittime(1000);			
				
				    	if(driver.findElement(By.xpath("//*[@id=\"usertable\"]/tbody/tr["+j+"]/td[1]")).getText().contains(inputData[a]))
					    {
							driver.findElement(By.xpath("//*[@id=\"usertable\"]/tbody/tr["+j+"]/td[9]/a")).click();
					    	Delete_User_Button(driver).click();
					    	WaitClass.Waittime(5000);		    	
					    	Alert alert=driver.switchTo().alert();
					    	alert.accept();
					    	outStatus = inputData[a]+","+"Passed";
					    	writer.write(outStatus);
							writer.newLine();
					
							
				//	    	System.out.println("delete record found");
					    	userPresent = "Y";
		    	
					    	break;
					    }
					}
			    	if(userPresent == "N"){
			    	String fieldValue = "User not in the list.User cannot be deleted!!";
			    	outStatus = inputData[a]+","+fieldValue;
			    	writer.write(outStatus);
			    	writer.newLine();
			    	
			    	
			    	//System.out.println("Delete record not found");
	    }
	}
		    	//System.out.println(outStatus);
		    	
		    	
		    	writer.close();
				
				
				}
}
				
				
				
				   