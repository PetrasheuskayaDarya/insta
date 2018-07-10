package by.htp.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.MyInstaPropertyManager;


public class LoginTestsInvalid {
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
	
	@Before
	public void OpenPage() {
		driver.get("https://www.instagram.com/accounts/login/");
		
	}

	@Test
	public void LogInWithoutInputLoginAndPass() {
		loginPage.inputLogin("");
		loginPage.inputPassword("");
		loginPage.clickLogInButton();
		String SignUp = loginPage.getTextSignUpLink();
		Assert.assertEquals("Зарегистрируйтесь", SignUp);
	
	}
	
	@Test
	public void LogInWithoutLogin() {
		loginPage.inputLogin("123");
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		String SignUp = loginPage.getTextSignUpLink();
		Assert.assertEquals("Зарегистрируйтесь", SignUp);
		//response.setHeader("Refresh", "0; URL=https://www.instagram.com/accounts/login/");


	}
	
	@Test
	public void LogInWithoutPassword() {
		loginPage.inputLogin(conf.getLogin());
		loginPage.inputPassword("");
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("К сожалению, вы ввели неверный пароль. Проверьте свой пароль еще раз.", NotPassword );
		
	}
	
	@Test
	public void LogInWithWrongPassword() {
		loginPage.inputLogin(conf.getLogin());
		loginPage.inputPassword("123");
		loginPage.clickLogInButton();
		String NotPassword1 = loginPage.getAlertNotPassword();
		Assert.assertEquals("К сожалению, вы ввели неверный пароль. Проверьте свой пароль еще раз.", NotPassword1 );
		
	}
	
	@Test
	public void LogInWithWrongLogin() {
		loginPage.inputLogin("123");
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		String NotPassword2 = loginPage.getAlertNotPassword();
		Assert.assertEquals("К сожалению, вы ввели неверный пароль. Проверьте свой пароль еще раз.", NotPassword2 );
		
	}
	
	@Test
	public void LogInWithWrongLoginAndPassword() {
		loginPage.inputLogin("123");
		loginPage.inputPassword("123");
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("К сожалению, вы ввели неверный пароль. Проверьте свой пароль еще раз.", NotPassword );

	}
	
	@Test
	public void LogInRightLoginInPasswordFoeldAndPasswordInLoginField() {
		loginPage.inputLogin(conf.getPass());
		loginPage.inputPassword(conf.getLogin());
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("К сожалению, вы ввели неверный пароль. Проверьте свой пароль еще раз.", NotPassword );

	}
	
	@Test
	public void LogInWithScriptInLoginField() {
		loginPage.inputLogin("<script>alert(123)</script>");
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.", NotPassword );

	}
	
	@Test
	public void LogInWithSQLInLoginField() {
		loginPage.inputLogin("SELECT * FROM blog WHERE code LIKE ‘a%’");
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.", NotPassword );

	}
	
	@Test
	public void LogInWithTagInLoginField() {
		loginPage.inputLogin("(<form action=»http://live.hh.ru»><input type=»submit»></form>");
		loginPage.inputPassword(conf.getPass());
		loginPage.clickLogInButton();
		String NotPassword = loginPage.getAlertNotPassword();
		Assert.assertEquals("Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.", NotPassword );

	}
	

	@AfterClass
	public static void LogOut() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}

}
