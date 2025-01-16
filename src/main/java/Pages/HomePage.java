package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class HomePage extends Base{
	
	WebElement searchBox;
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void openURL() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	
	public boolean isSearchBoxVisible() throws InterruptedException {
		
		searchBox= driver.findElement(By.id("search-autocomplete-input"));
			
		return searchBox.isDisplayed();
	}
	
	public int autoSuggestionListSize() throws InterruptedException {
		
		searchBox.click();
		Thread.sleep(5000);
		searchBox.sendKeys("Web Development");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[2]/div/header/div/div/div[2]/div/div/div/div/div/div[2]/div/div[2]/form/div/div[1]/div"));
//		List<WebElement> list = driver.findElements(By.id("react-autowhatever-1"));

        // Iterate through the list
        for (int i=0; i<list.size();i++) {
        	System.out.println(list.get(i).getText());
        }
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-autowhatever-1-section-1-item-2\"]/div/div/div[2]/span")));
//		WebElement we=driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-1-item-2\"]/div/div/div[2]/span"));
      
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-autowhatever-1")));
		WebElement we=driver.findElement(By.id("react-autowhatever-1"));
        we.click();
		Thread.sleep(3000);
        return list.size();
		
	}
	
	
}
