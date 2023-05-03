package coding_contest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cc1_1 {

	public static void main(String[] args) throws Exception {
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
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		
		Thread.sleep(3000);
		Assert.assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());
		driver.findElement(By.className("shopping_cart_link")).click();
		
		Thread.sleep(3000);
		Assert.assertEquals("Your Cart", driver.findElement(By.className("title")).getText());
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(3000);
		Assert.assertEquals("Checkout: Your Information", driver.findElement(By.className("title")).getText());
		driver.findElement(By.id("first-name")).sendKeys("standard_user");
		driver.findElement(By.id("last-name")).sendKeys("standard_user");
		driver.findElement(By.id("postal-code")).sendKeys("standard_user");
		driver.findElement(By.id("continue")).click();
		
		Thread.sleep(3000);
		Assert.assertEquals("Checkout: Overview", driver.findElement(By.className("title")).getText());
		System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
		System.out.println(driver.findElement(By.className("inventory_item_price")).getText());
		
		Assert.assertEquals("Swag Labs", driver.getTitle());
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
		
	}
}
