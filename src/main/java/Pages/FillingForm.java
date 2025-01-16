package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import FillingForms.BaseFillingForm;
import FillingForms.FillingFormSuccessfully;
import FillingForms.FillingFormWithEmptyFeilds;
import FillingForms.FillingFormWithInvalidEmail;
import FillingForms.FillingFormWithInvalidPhone;

public class FillingForm extends Base{
	
	FillingFormWithInvalidPhone obj1; 
	FillingFormWithInvalidEmail obj2;
	FillingFormWithEmptyFeilds obj3;
	FillingFormSuccessfully obj4;
	BaseFillingForm form;
	String filepath = "src\\test\\resources\\EmptyField.xlsx";
	String filepath1 = "src\\test\\resources\\ValidData.xlsx";
	String filepath2 = "src\\test\\resources\\InvalidMobile.xlsx";
	String filepath3 = "src\\test\\resources\\InvalidEmail.xlsx";
	
	String sheetName = "Sheet1";
	
	WebDriver driver;
	public FillingForm(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public String getErrorMsgOnInvalidEmail() throws InterruptedException {
		form = new BaseFillingForm(driver);
		Thread.sleep(3000);
		form.dataEntry(filepath3, sheetName);
		obj2 = new FillingFormWithInvalidEmail(driver);
		return obj2.getMsg();
	}

	public String getErrorMsgOnInvalidPhone() throws InterruptedException {
		
		driver.navigate().refresh();
		form = new BaseFillingForm(driver);
		Thread.sleep(3000);
		form.dataEntry(filepath2, sheetName);
		obj1 = new FillingFormWithInvalidPhone(driver);
		return obj1.getMsg();
	}

	public String getErrorMsgOnNotFilling() throws InterruptedException {
		driver.navigate().refresh();
		form = new BaseFillingForm(driver);
		Thread.sleep(3000);
		form.dataEntry(filepath, sheetName);
		obj3 = new FillingFormWithEmptyFeilds(driver);
		return obj3.getMsg();
	}
	
	public String getSuccessMsgOnValidData() throws InterruptedException {
		driver.navigate().refresh();
		form = new BaseFillingForm(driver);
		Thread.sleep(3000);
		form.dataEntry(filepath1, sheetName);
		obj4 = new FillingFormSuccessfully(driver);
		return obj4.getMsg();
	}
	
}
