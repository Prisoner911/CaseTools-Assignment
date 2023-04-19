package genericPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "D:\\HW\\java\\selenium\\demoProject\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String expectedPageName="Insurance Broker System - Login";
		
		String pageName = driver.getTitle();
		
		if (pageName .equals(expectedPageName) ) {
			System.out.println("Verified page title");
		}
		else {
			System.out.println("Incorrect title");
			driver.close();
		}
		
		WebElement email = driver.findElement(By.id("email"));
		
		email.sendKeys("BCA@gmail.com");
		System.out.println("entered email id");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("BCA@123");
		System.out.println("entered password");
		
		WebElement login = driver.findElement(By.xpath("//input[@value='Log in']"));
		login.click();
		System.out.println("login button pressed");
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		//WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement logout = driver.findElement(By.xpath("//input[@value='Log out']"));
		driverWait.until(ExpectedConditions.visibilityOf(logout));
		
		//demo purpose only
		//Thread.sleep(5000);
		
	}
}
