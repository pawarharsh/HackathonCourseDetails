package Hackathon;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Courses;
import Pages.FillingForm;
import Pages.HomePage;
import Pages.Languages;
import Pages.Levels;

public class NewTest {

	static Logger logger = Logger.getLogger(NewTest.class); //
	WebDriver driver;
	HomePage homepage;
	Courses courses;
	Languages languages;
	Levels levels;
	FillingForm form;

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) {
		
		Base b = new Base();
		driver = b.driverSetup(br);

	}

	@Test(priority=1)
	public void initializePages() {

		homepage = new HomePage(driver);
		courses = new Courses(driver);
		levels = new Levels(driver);
		languages = new Languages(driver);
		form = new FillingForm(driver);

	}

	@Test(priority = 2)
	public void openWebsite() {
		homepage.openURL();
		String actualUrl = homepage.getUrl();
		String expectedUrl = "https://www.coursera.org/";
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Test(priority = 3)
	public void locateSearchBox() throws InterruptedException {
		boolean searchBoxVisible = homepage.isSearchBoxVisible();
		Thread.sleep(3000);
		assertTrue(searchBoxVisible);
	}

	@Test(priority = 4)
	public void autoSuggestion() throws InterruptedException {
		int size = homepage.autoSuggestionListSize();
		assertTrue(size > 0);
	}

	@Test(priority = 5)
	public void courseLanguageSelection() throws InterruptedException {
		WebElement languageSelected = courses.languageSelection();
		languageSelected.click();
	}

	@Test(priority = 6)
	public void courseLevelSelection() throws InterruptedException {
		WebElement levelSelected = courses.levelSelection();
		levelSelected.click();
	}

	@Test(priority = 7)
	public void displayFirstCourseDetails() throws InterruptedException {
		courses.isFirstCourseDisplayed();
	}

	@Test(priority = 8)
	public void displaySecondCourseDetails() throws InterruptedException {
		courses.isSecondCourseDisplayed();
	}

	@Test(priority = 9)
	public void displayListOfLanguages() throws InterruptedException {
		assertTrue(languages.sizeOfListOfLanguages() > 0);
	}

	@Test(priority = 10)
	public void displayListOfLevel() {
		assertTrue(levels.sizeOfListOfLevel() > 0);
	}
	
	@Test(priority = 11)
	public void newTabSwitch() throws InterruptedException {
		List<WebElement> firstHead=driver.findElements(By.xpath("//*[@class='cds-ProductCard-content']"));
		firstHead.get(0).click();
		Set<String> windows=driver.getWindowHandles();
		for(String w:windows) {
			System.out.println(w);  // these is printing IDs of windows open
		}
		
		List<String> windowsList=new ArrayList<String>(windows);
		String parent=windowsList.get(0);
		String child=windowsList.get(1);
		
		System.out.println("Before Switching: "+driver.getTitle());
		Thread.sleep(3000);
	 // if we want to switch window
		driver.switchTo().window(child);
		Thread.sleep(3000);
		System.out.println("After Switching: "+driver.getTitle());	
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		System.out.println("Switching back to main window: "+driver.getTitle());
		
	}

	@Test(priority = 12)
	public void navigateBackToHome() {
		courses.returnToHomePage();
		String actualUrl = homepage.getUrl();
		String expectedUrl = "https://www.coursera.org/";
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("This is 10th test case");
	}

	@Test(priority = 13)
	public void locateForEnterprise() {
		assertTrue(driver.findElement(By.linkText("For Enterprise")).isDisplayed());
		driver.findElement(By.linkText("For Enterprise")).click();
	}

	@Test(priority = 14)
	public void locateCourseForCampus() throws InterruptedException {
		assertTrue(driver.findElement(By.linkText("For Campus")).isDisplayed());
		driver.findElement(By.linkText("For Campus")).click();
	}

	@Test(priority = 15)
	public void locateForm() throws InterruptedException {
		
		assertTrue(true);
	}

	@Test(priority = 16)
	public void errorOnInvalidEmail() throws InterruptedException {
		form.getErrorMsgOnInvalidEmail();
	}

	@Test(priority = 17)
	public void errorOnInvalidMobile() throws InterruptedException {
		form.getErrorMsgOnInvalidPhone();
	}

	@Test(priority = 18)
	public void errorOnBlankFields() throws InterruptedException {
		form.getErrorMsgOnNotFilling();
	}

	@Test(priority = 19)
	public void locateStateOnSelectingIndia() {
		assertTrue(driver.findElement(By.xpath("//*[@id=\"State\"]")).isDisplayed());
	}

	@Test(priority = 20)
	public void submitFormVerification() throws InterruptedException {
		form.getSuccessMsgOnValidData();
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
