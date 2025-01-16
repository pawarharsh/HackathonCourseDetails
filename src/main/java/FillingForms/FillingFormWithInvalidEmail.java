package FillingForms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.Base;

public class FillingFormWithInvalidEmail extends Base {
	

	WebDriver driver;
	
	public FillingFormWithInvalidEmail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public String getMsg() throws InterruptedException {

		WebElement web = driver.findElement(By.xpath("//*[@id=\"ValidMsgEmail\"]"));

		String ErrorMsg = web.getText(); // Text of the error message is stored here
		Thread.sleep(1000);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String sc="Screenshots\\Screenshot_of_invalidEmail.png";
		try {
			FileUtils.copyFile(screenshot, new File(sc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(ErrorMsg); // Error message is printed on console
		return ErrorMsg;
		
	}

}
