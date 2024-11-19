package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticleConduitPage {
	
	
	@FindBy(xpath = "//input[@placeholder = 'Article Title']")
	WebElement articleTitle;
	
	@FindBy(xpath = "//input[@name = 'description']")
	WebElement articleShortDescription;
	
	@FindBy(xpath = "//textarea[@name = 'body']")
	WebElement articleDescription;
	
	@FindBy(xpath = "//input[@name = 'tags']")
	WebElement articleTags;
	
	@FindBy(xpath = "//button[text() = 'Publish Article']")
	WebElement articlePublishButton;
	
	
	
	public NewArticleConduitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOnNewArticle() {
		return articleTitle.isDisplayed();
	}
	
	public void enterTitle(String title) {
		articleTitle.sendKeys(title);
	}
	
	public void enterShortDescription(String shortDescription) {
		articleShortDescription.sendKeys(shortDescription);
	}
	
	public void enterDescription(String Description) {
		articleDescription.sendKeys(Description);
	}
	
	public void enterTags(String Tags) {
		articleTags.sendKeys(Tags);
	}
	
	public void clickPublishArticle() {
		articlePublishButton.click();
		
	}
	
	
	
}
