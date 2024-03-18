package Task4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Checking_Prices {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demowebshop.tricentis.com/");
		
		//Clicking to the login Page
		driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
				
		//The Web Page has to Wait Certain Amount Of time (3000LongSec = 3Sec)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
				
		//Giving Correct Credentials and then Login to Web Page
				
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("abhakamalhassan@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("@#$qweASD");
		driver.findElement(By.xpath("//div[@class=\"buttons\"]/input[@type=\"submit\"]")).submit();
				
		Thread.sleep(3000);
		
		//Clicking the Computers 
		WebElement one = driver.findElement(By.xpath("//li[@class=\"inactive\"]/a[contains(text(),'Computers')]"));
		one.click();
		driver.findElement(By.xpath("//h2[@class=\"title\"]//a[contains(text(),'Notebooks')]")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		Thread.sleep(3000);
		
		//Again it has to Clicking the Computers 
		WebElement one1 = driver.findElement(By.xpath("//li[@class=\"inactive\"]/a[contains(text(),'Computers')]"));
		one1.click();
		driver.findElement(By.xpath("//h2[@class=\"title\"]//a[contains(text(),'Notebooks')]")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		WebElement one3 = driver.findElement(By.xpath("//li[@class=\"inactive\"]/a[contains(text(),'Computers')]"));
		one3.click();
		driver.findElement(By.xpath("//h2[@class=\"title\"]//a[contains(text(),'Notebooks')]")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		Thread.sleep(3000);
		
		//Amount calcuation in MacBook
		int price1 = 10;
		int quantity = 2;
		int totalprice = price1 * quantity;
		System.out.println("Price of a Book : "+price1);
		System.out.println("Number of Books Quantity : "+quantity);
		System.out.println("Total Amount of Two Books :"+totalprice);
	
		//Now Clicking the Books
		WebElement two = 	driver.findElement(By.xpath("//li[@class=\"inactive\"]/a[contains(text(),'Books')]"));
		two.click();
		driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
		//driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
		Thread.sleep(3000);
		
		//Amount Calculation for Books
		int price2 = 1590;
		int quantity2 = 2;
		int totalprice2 = price2 * quantity2;
		System.out.println("Price of a MacBook : "+price2);
		System.out.println("Number of MacBooks Quantity : "+quantity2);
		System.out.println("total Amount of two MacBook: "+totalprice2);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-250)");
				
		//Now Clicking the Shopping Cart
		driver.findElement(By.xpath("//a[@class=\"ico-cart\"]//span[@class=\"cart-qty\"]")).click();
		Thread.sleep(3000);
		
		//Scroll for the 100px
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		
		//For my Checking purpose i Wanna take screenshot
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\RS-EMP\\eclipse-workspace\\Selenium_Project\\ScreenShot\\pricetags.png"));
		
		//Clicking the CheckBox
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]")).click();
		//After All We Have to Update Our Products
		
		driver.findElement(By.xpath("//input[@name=\"updatecart\"]")).click();
		
		//Total Price 

		int maintotal = totalprice + totalprice2;
		System.out.println("Sub-Total of two Products : "+maintotal);
		
		double amount = 4200;
		if(amount == maintotal) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
	
		
	}

}
