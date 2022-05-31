package opencart;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenCartFlow {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.31.0-win64 (1)\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.opencart.com/index.php?route=common/home");
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("imac");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		WebElement ele1 = driver.findElement(By.id("input-sort"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("Price (Low > High)");
		WebElement ele2 = driver.findElement(By.xpath("//a[.='iMac']"));
		Point loc = ele2.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" +x+","+y+ ")");
		ele2.click();
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("cart-total")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//strong[.=' View Cart']")).click();
		Thread.sleep(4000);
		WebElement ele3 = driver.findElement(By.xpath("//input[contains(@name,'quantity')]"));
		ele3.click();
		ele3.clear();
		ele3.sendKeys("5");
		driver.findElement(By.xpath("//button[@data-original-title='Update']")).click();
		Thread.sleep(4000);
		driver.quit();


	}

}