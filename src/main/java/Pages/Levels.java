package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Levels extends Base {
	
	WebDriver driver;
	public Levels(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public int sizeOfListOfLevel() {
		List<WebElement> levelCheck = driver.findElements(By.xpath("/html/body/div[2]/div/div/main/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[4]/div/div[2]/div"));
		for (int i = 0; i < levelCheck.size(); i++) {
			System.out.println(levelCheck.get(i).getText());
		}
		return levelCheck.size();
	}

}
