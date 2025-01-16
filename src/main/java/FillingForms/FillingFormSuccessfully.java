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
import org.openqa.selenium.support.ui.Select;

import Base.Base;
import UtilFiles.ExcelUtils;

public class FillingFormSuccessfully extends Base {

	WebDriver driver;
	public FillingFormSuccessfully(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public String getMsg() throws InterruptedException {

		String title = driver.getCurrentUrl();
		if(title.contains("https://www.coursera.org/campus/thank-you")) {
			
			System.out.println("Success");
		}
		else {
			System.out.println(title);
			System.out.println("Fail");
		}
		
		Thread.sleep(1000);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String sc="Screenshots\\SuccessMsg.png";
		try {
			FileUtils.copyFile(screenshot, new File(sc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "Success";
	}
	
}
