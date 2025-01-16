package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Courses extends Base {

	WebDriver driver;
	public Courses(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement languageSelection() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(By.xpath("//*[@id=\"cds-react-aria-18\"]"));
	}
	
	public WebElement levelSelection() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(By.xpath("//*[@id=\"cds-react-aria-50\"]"));
	}
	
	public void isFirstCourseDisplayed() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> firstHead=driver.findElements(By.xpath("//*[@class='cds-ProductCard-content']"));
		System.out.println(firstHead.get(0).getText());
		List<WebElement> firstRating=driver.findElements(By.xpath("//*[@class='cds-CommonCard-ratings']/div/div/span"));
		System.out.println(firstRating.get(0).getText());
		
		List<WebElement> firstDuration=driver.findElements(By.xpath("//*[@class='cds-CommonCard-metadata']/p"));
		System.out.println(firstDuration.get(0).getText());
		
	}
	
	public void isSecondCourseDisplayed() throws InterruptedException {
		List<WebElement> secondHead=driver.findElements(By.xpath("//*[@class='cds-ProductCard-content']"));
		System.out.println(secondHead.get(0).getText());
		
		List<WebElement> firstRating=driver.findElements(By.xpath("//*[@class='cds-CommonCard-ratings']/div/div/span"));
//		WebElement firstRating=driver.findElement(By.id("cds-react-aria-248-aria-describedby-label"));
		System.out.println(firstRating.get(1).getText());
		
		List<WebElement> firstDuration=driver.findElements(By.xpath("//*[@class='cds-CommonCard-metadata']/p"));
		System.out.println(firstDuration.get(1).getText());
		
	}
	
	public void returnToHomePage() {
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}
}
