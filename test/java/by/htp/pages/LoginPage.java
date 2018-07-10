package by.htp.pages;

import java.lang.reflect.Array;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement loginField;
	
	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Войти']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\'react-root\']/section/main/div/article/div/div[2]/p/a")
	private WebElement singUpLink;
	
	@FindBy(id= "slfErrorAlert")
	private WebElement alertWrongPassword;
	
	
	public void inputLogin(String login) {
		loginField.sendKeys(login);
	}
	
	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLogInButton() {
		loginButton.click();
	}
	
    public String getTextSignUpLink() {
		String SingUp = singUpLink.getText();
		return SingUp;
    }
    
    public String getAlertNotPassword() {
		String WrongPassword = alertWrongPassword.getText();
		return WrongPassword;
    }
    
  
}


