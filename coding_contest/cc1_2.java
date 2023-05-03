package coding_contest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cc1_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
    	ChromeOptions co=new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("product_sort_container")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();
		Assert.assertEquals("Name (A to Z)",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).getText());
		Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).click();
		Assert.assertEquals("Name (Z to A)",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).getText());
		Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
		Assert.assertEquals("Price (low to high)",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).getText());
		Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
		Assert.assertEquals("Price (high to low)",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).getText());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText());
		
		
		
	}

}
