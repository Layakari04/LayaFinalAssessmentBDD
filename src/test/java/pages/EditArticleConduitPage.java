package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticleConduitPage {
	
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
	
	@FindBy(xpath = "//div[@class ='article-page']")
	WebElement userArticle;
	
	@FindBy(xpath = "//a[contains (text(),  'Edit Article')]")
	WebElement clickEditArticle;
	
	@FindBy(xpath = "//button[contains (text(), 'Update Article')]")
	WebElement clickUpdateArticle;
	
	
	
	public EditArticleConduitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitle(String title) {
		articleTitle.clear();
		articleTitle.sendKeys(title);
	}
	
	public void enterShortDescription(String shortDescription) {
		articleShortDescription.clear();
		articleShortDescription.sendKeys(shortDescription);
	}
	
	public void enterDescription(String Description) {
		articleDescription.clear();
		articleDescription.sendKeys(Description);
	}
	
	public void enterTags(String Tags) {
		articleTags.clear();
		articleTags.sendKeys(Tags);
	}
	
	public boolean isOnUserArticle() {
		return userArticle.isDisplayed();
	}
	
	public void clickEditArticle() {
		clickEditArticle.click();
	}
	public void clickUpdateArticle() {
		clickUpdateArticle.click();
	}

	
		
	}
	

