package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
		 
	    public MainPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }
	    public WebDriver driver;
	 
	    @FindBy(xpath= "//button[text()='Не сейчас']")
	    private WebElement NotNowNotifications;
	    
	    @FindBy(className = "coreSpriteDesktopNavProfile")
	    private WebElement profileUser;
	    
	    @FindBy(xpath = "//*[@id=\'react-root\']/section/main/div/header/section/div[1]/button/span")
	    private WebElement menu;
	 
	 
	    public void clickNotNowNotifications() {
	    	NotNowNotifications.click();
		}
	    
	    public String getTextNotNowNotification() {
			String profile = NotNowNotifications.getText();
			return profile;
	    }
	    
	    public void clickOnProfileUser() {
	    	profileUser.click();
	    }
	    
	    public void clickOnMenu() {
	    	menu.click();
	    }
	 
	 
	}

