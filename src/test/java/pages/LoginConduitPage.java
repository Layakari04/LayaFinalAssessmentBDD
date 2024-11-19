package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginConduitPage {
	//pageFactory Pattern
		@FindBy(xpath ="//input[@placeholder=\"Email\"]")
		WebElement emailId;
		
		@FindBy(xpath ="//input[@placeholder=\"Password\"]")
		WebElement userPwd;
		
		@FindBy(xpath = "//button[contains(text(), 'Login')]")
		WebElement loginBtn;
		
		//@FindBy(xpath = "//div[@class = \"article-preview\"]")
		//WebElement yourFeed;
		
		@FindBy(xpath = "//div[contains (text() , 'Layakari')]")
		WebElement conduitUser;
		
	
		
		@FindBy(xpath = "//a[@href='#/editor']")
		WebElement newArticleLink;

		public LoginConduitPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public void validLogin(String strUser, String strPwd) {
			emailId.sendKeys(strUser);
			userPwd.sendKeys(strPwd);
			loginBtn.click();
		}
			//public boolean isOnHome() {
				//return yourFeed.isDisplayed();
			//}	
			
			public boolean isOnHome() {
				return conduitUser.isDisplayed();
			}
			
			public void clickNewArticle() {
				newArticleLink.click();
			}
			
			
			
			
		}

