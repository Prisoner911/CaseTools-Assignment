package auto_test;

import java.util.*;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class autoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String IdOfLink="next";
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\CT_assignment\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String parent = driver.getWindowHandle();
		
		driver.manage().window().maximize();
		
		driver.get("file:///D:/selenium/CT_assignment/html/homepage.html");
		
		String ExpectedPageTitle = "Hogwarts";
		verification(driver, ExpectedPageTitle);
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Enter");
		
		String ExpectedPageTitle1 = "index";
		verification(driver, ExpectedPageTitle1);
		scroll(driver);
		Thread.sleep(1000);
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Hogwarts");
		
		String ExpectedPageTitle2 = "Houses";
		verification(driver, ExpectedPageTitle2);
		scroll(driver);
		
		//for gryffindor
		IdOfLink="gryf";
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Gryffindor");
		driver.findElement(By.id(IdOfLink));
		System.out.println("redirected to third party site");
		closeTab(driver,parent);
		System.out.println("Exited from third party site");
		
		//for hufflepuff
		IdOfLink="huff";
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Hufflepuff");
		driver.findElement(By.id(IdOfLink));
		System.out.println("redirected to third party site");
		closeTab(driver,parent);
		System.out.println("Exited from third party site");
		
		//for Ravenclaw
		IdOfLink="ravn";
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Ravenclaw");
		driver.findElement(By.id(IdOfLink));
		System.out.println("redirected to third party site");
		closeTab(driver,parent);
		System.out.println("Exited from third party site");
		
		//for Slythein
		IdOfLink="slyt";
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Slytherin");
		driver.findElement(By.id(IdOfLink));
		System.out.println("redirected to third party site");
		closeTab(driver,parent);
		System.out.println("Exited from third party site");
		
		IdOfLink="af";
		PageClick(driver,IdOfLink);
		System.out.println("Clicked on Houses of Entered form page");
		ExpectedPageTitle="form";
		verification(driver,ExpectedPageTitle);
		
		WebElement fn = driver.findElement(By.name("fn"));
		fn.sendKeys("Gaurav");
		System.out.println("Entered first name");
		
		WebElement ln = driver.findElement(By.name("ln"));
		ln.sendKeys("Dichawalkar");
		System.out.println("Entered last name");
		
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("helloworld");
		System.out.println("Entered password");
		
		WebElement Rpassword = driver.findElement(By.name("rpwd"));
		Rpassword.sendKeys("helloworld");
		System.out.println("ReEntered password");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("gauravdichwalkar@gmail.com");
		System.out.println("Entered email");
		
		WebElement ph = driver.findElement(By.name("ph"));
		ph.sendKeys("9845621487");
		System.out.println("Entered phone number");
		
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("new waddem,vasco,goa");
		System.out.println("Entered address");
		
		WebElement radioM = driver.findElement(By.xpath("//input[@value='male']"));
		radioM.click();
		System.out.println("Male selected");
		WebElement radioF = driver.findElement(By.xpath("//input[@value='female']"));
		radioF.click();
		System.out.println("Female selected");
		
		radioM.click();
		System.out.println("Male selected");
		
		WebElement hobby1 = driver.findElement(By.name("hobby1"));
		hobby1.click();
		System.out.println("Hobby1 selected");
		hobby1.click();
		System.out.println("Hobby1 deselected");
		
		hobby1.click();
		System.out.println("Hobby1 selected");
		
		WebElement hobby2 = driver.findElement(By.name("hobby2"));
		hobby2.click();
		System.out.println("Hobby2 selected");
		hobby2.click();
		System.out.println("Hobby2 deselected");
		
		WebElement hobby3 = driver.findElement(By.name("hobby1"));
		hobby3.click();
		System.out.println("Hobby3 selected");
		hobby3.click();
		System.out.println("Hobby3 deselected");
		
		
	}
	
	
	public static void verification (WebDriver drvr, String ExpectedPageName) {
	
		String PageName = drvr.getTitle();
	
		if(ExpectedPageName .equals(PageName)) {
			System.out.println("Page title is correct");
		}
		else {
			System.out.println("Page title is incorrect");
			drvr.close();
		}
	}
	
	public static void PageClick(WebDriver drvr, String ID) {
		WebElement linkToNext = drvr.findElement(By.id(ID));
		linkToNext.click();
	}
	
	public static void scroll(WebDriver drvr) {
		JavascriptExecutor js = (JavascriptExecutor) drvr;
		js.executeScript("javascript:window.scrollBy(650,750)");
	}
	
	public static void closeTab(WebDriver drvr, String prnt) throws InterruptedException {
		//Thread.sleep(5000);
		for (String child : drvr.getWindowHandles()) {
			drvr.switchTo().window(child);
	}
	drvr.close();
	drvr.switchTo().window(prnt);
	}
	
}
