package pages;


import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteArticleConduitPage {
	
	@FindBy(xpath = "//button[contains (text(),  'Delete Article')]")
    WebElement deleteButton;
	
	@FindBy(css = ".article")
    WebElement articleContainer;
	
	public DeleteArticleConduitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
    }

   
    public void clickDeleteButton() {
         deleteButton.click();
    }

    public void confirmDeletion(WebDriver driver) {
        
		Alert alert = driver.switchTo().alert();
        alert.accept(); 
    }

    
  public boolean isArticleDeleted() {
    	
        try {
            articleContainer.isDisplayed();
            
            return false; 
        } catch (Exception e) {
            return true; 
        }
    }

	}
 


