package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Languages extends Base {

	WebDriver driver;
	public Languages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public int sizeOfListOfLanguages() throws InterruptedException {
		WebElement showMore=driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/button/span"));
		showMore.click();
		Thread.sleep(5000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div"));
        for (int i=0; i<checkboxes.size();i++) {
                System.out.println(checkboxes.get(i).getText());
        }
        return checkboxes.size();
	}
	
}
