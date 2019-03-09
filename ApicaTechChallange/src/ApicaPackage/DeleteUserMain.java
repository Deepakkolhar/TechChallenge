package ApicaPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Exception.FilloException;


public class DeleteUserMain {

	public static void main(String[] args) throws FilloException, Exception {
			System.out.print("OMSV");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak\\JavaProject\\Resources\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.navigate().to("https://wpm-trial.apicasystem.com");
					
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin@DeepakKolhar");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!!Udm@FP8NpA!%CQx4&6");
			driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/input")).click();
				
				
		        int numUsers = 4;
	
				 
				 DeleteUser.deleteUser(driver, numUsers);
			
			AddUsers.User_Identity(driver).click();
			AddUsers.Logoff_Button(driver).click();
			driver.quit();
			
	      }
	  
}
