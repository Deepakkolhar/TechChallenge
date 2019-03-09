package ApicaPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Exception.FilloException;

//*********************************************************//		
//******************Add User program***********************//		
//*********************************************************//

public class AddNewUserMain {

	public static void main(String[] args) throws FilloException, Exception {
     	System.out.print("OMSV");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak\\JavaProject\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://wpm-trial.apicasystem.com");
	
	//Enter which Login id needs to be used to login to APICA system.
	
		int LoginId = 1;
				
	// Login to APICA system using username and password	
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(GetDataModule.data_module2("Username", LoginId));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(GetDataModule.data_module2("Password", LoginId));
		driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/input")).click();

	int numUsers = 4;
	
		for(int i=1;i<=numUsers;i++){
	
			int TCID = i;
			AddUsers.addUser(driver, TCID);

	     }

		System.out.print("Add user test is completed, Please see input data sheet for the results");
		AddUsers.User_Identity(driver).click();
		AddUsers.Logoff_Button(driver).click();
		driver.quit();
		
	}
   }

