package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewArticleConduitPage {
	
	@FindBy(xpath = "//a[@class = 'nav-link ' and @href = '#/']")
	WebElement homeBtn;
	
	@FindBy(xpath = "//button[@class='nav-link ']")
	WebElement globalFeedTab;
	
	@FindBy(xpath = "//a[@class='preview-link']//h1[contains(text(), 'Test Article-10')]")
	WebElement previewArticleTitle;
	
	public ViewArticleConduitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickHome() {
		homeBtn.click();
	}
	public void clickGlobalFeed() {
		globalFeedTab.click();
		}
	
	public boolean isOnGlobalFeed() {
		return globalFeedTab.isDisplayed();
	}
		
	//public void findUserArticle(WebDriver driver) {
		//List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'info']//a[@href = '#/profile/Layakari']"));
		//System.out.println("Number of items...:" + items.size());
		//for(WebElement item : items) {
			//System.out.println("Item Value...:" + item.getText());
		//}
	public boolean clickUserFeed() {
		previewArticleTitle.click();
		return false;
	}
		

}
