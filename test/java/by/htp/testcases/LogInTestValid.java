package by.htp.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.MyInstaPropertyManager;

public class LogInTestValid {
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static MainPage mainPage;
	MyInstaPropertyManager conf = new MyInstaPropertyManager();

	@BeforeClass
	public static void SetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/accounts/login/");
	}

	@Test
	public void LogInWithRightCreds() {
		loginPage.inputLogin(conf.getLogin());
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Не сейчас']")));
		String NotNow = mainPage.getTextNotNowNotification();
		Assert.assertEquals("Не сейчас", NotNow);
		
	}

	@AfterClass
	public static void LogOut() {
		mainPage.clickNotNowNotifications();
		mainPage.clickOnProfileUser();
		mainPage.clickOnMenu();
		driver.quit();
	}
}