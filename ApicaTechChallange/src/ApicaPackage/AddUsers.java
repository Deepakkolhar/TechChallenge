package ApicaPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddUsers {

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

		
	//New User Button
		public static WebElement New_User_Button(WebDriver driver) {
			element = driver.findElement(By.id("new-user-btn"));
		return element;
		}

	
	//User Name element
		public static WebElement User_Name(WebDriver driver) {
			element = driver.findElement(By.id("username"));
		return element;
		}


	//Full Name element
		public static WebElement Full_Name(WebDriver driver) {
			element = driver.findElement(By.id("fullname"));
		return element;
		}

		
	//Phone element 
		public static WebElement Phone(WebDriver driver) {
			element = driver.findElement(By.id("phone"));
		return element;
		}
				

		//Mobile element 
		public static WebElement Mobile(WebDriver driver) {
			element = driver.findElement(By.id("mobile"));
		return element;
		}
		
		
	//Approved element 
		public static WebElement Approved(WebDriver driver) {
			element = driver.findElement(By.id("approved"));
		return element;
		}
	
	//New Password1 element 
		public static WebElement Password1(WebDriver driver) {
			element = driver.findElement(By.id("password"));
		return element;
		}

		//New Password2 element 
		public static WebElement Password2(WebDriver driver) {
			element = driver.findElement(By.id("password-2"));
		return element;
		}
		
		
	//Create User Button 
		public static WebElement Create_User_Button(WebDriver driver) {
			element = driver.findElement(By.id("create-user-btn"));
		return element;
		}

		//User Identity
				public static WebElement User_Identity(WebDriver driver) {
					element = driver.findElement(By.id("user-identity"));
				return element;
				}
				
		
		//Logout Button
		public static WebElement Logoff_Button(WebDriver driver) {
			element = driver.findElement(By.id("logOutLink"));
		return element;
		}
		
	
		
//*********************************************************//		
//******************Add User Logic*************************//		
//*********************************************************//
		
		public static void addUser(WebDriver driver, int TCID) throws Exception {
			
		String Role;
		String Regionalsetting;
		String Timezone;
		int StartRowCount;
		int EndRowCount;
		
		AddUsers.Manage_Button(driver).click();
		AddUsers.Manage_User_Button(driver).click();

		 StartRowCount = driver.findElements(By.xpath("//*[@id=\"usertable\"]/tbody/tr")).size();

		AddUsers.New_User_Button(driver).click();
		AddUsers.User_Name(driver).sendKeys(GetDataModule.data_module("Username",TCID));
		AddUsers.Full_Name(driver).sendKeys(GetDataModule.data_module("Fullname",TCID));
		AddUsers.Phone(driver).sendKeys(GetDataModule.data_module("Phone",TCID));
		AddUsers.Mobile(driver).sendKeys(GetDataModule.data_module("Mobile",TCID));
		if(GetDataModule.data_module("Approved",TCID).equals("Y")) {
		     AddUsers.Approved(driver).click();
			}
		Regionalsetting = GetDataModule.data_module("Regionalsetting",TCID);
		driver.findElement(By.xpath("//*[@id=\"regional-setting\"]/option[text()='"+Regionalsetting+"']")).click();
		
		Timezone = GetDataModule.data_module("Timezone",TCID);
		driver.findElement(By.xpath("//*[@id=\"timezone\"]/option[text()='"+Timezone+"']")).click();
		
		Role = GetDataModule.data_module("Role",TCID);
		driver.findElement(By.id(Role)).click(); 
		 
		AddUsers.Password1(driver).sendKeys(GetDataModule.data_module("Password",TCID));
		AddUsers.Password2(driver).sendKeys(GetDataModule.data_module("Password",TCID));
		
		AddUsers.Create_User_Button(driver).click();
		
		WaitClass.Waittime(3000);
		
		EndRowCount = driver.findElements(By.xpath("//*[@id=\"usertable\"]/tbody/tr")).size();

		if(EndRowCount == StartRowCount+2){
		
			String fieldName = "TestStatus";
			String fieldValue = "PASSED ";
			ResultWriter.writeResult(TCID, fieldName, fieldValue);
		}
		
		else {
			
			String fieldName = "TestStatus";
			Boolean isPresent = false;
			isPresent = driver.findElements(By.xpath("//*[@id=\"usertable\"]/tbody/tr[2]/td/form/div[1]/div[2]/div/label")).size() > 0;
			if(isPresent == true){
				String UserNameError = driver.findElement(By.xpath("//*[@id=\"usertable\"]/tbody/tr[2]/td/form/div[1]/div[2]/div/label")).getText();				
      		    String fieldValue = "FAILED - "+UserNameError;
				ResultWriter.writeResult(TCID, fieldName, fieldValue);
			}
			else {
				String PasswordError = driver.findElement(By.xpath("//*[@id=\"usertable\"]/tbody/tr[2]/td/form/div[6]/div[1]/div/label")).getText();				
      		    String fieldValue = "FAILED - "+PasswordError;
				ResultWriter.writeResult(TCID, fieldName, fieldValue);
			}
	   }
    }
}	

