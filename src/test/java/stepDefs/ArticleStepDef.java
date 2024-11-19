package stepDefs;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteArticleConduitPage;
import pages.EditArticleConduitPage;
import pages.LoginConduitPage;
import pages.NewArticleConduitPage;
import pages.ViewArticleConduitPage;

public class ArticleStepDef {
	
	WebDriver driver = TestBasePage.getDriver();
	LoginConduitPage loginConduitPage;
	NewArticleConduitPage ArticleConduitPage;
	EditArticleConduitPage updateArticle;
	ViewArticleConduitPage viewArticle;
	DeleteArticleConduitPage DeleteArticle;
	
	
	public ArticleStepDef() {
		loginConduitPage = new LoginConduitPage(driver);
		ArticleConduitPage = new NewArticleConduitPage(driver);
		updateArticle = new EditArticleConduitPage(driver);
		viewArticle = new ViewArticleConduitPage(driver);
		DeleteArticle = new DeleteArticleConduitPage(driver);
	}

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		TestBasePage.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");	
	}
	@When("User provide {string} and {string}")
	public void user_provide_and(String emailId, String userPwd) {
		loginConduitPage.validLogin(emailId , userPwd);
	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		boolean isOnHomePage = loginConduitPage.isOnHome();
		  Assert.assertTrue(isOnHomePage);
	}
	
	@Given("User should be on New Article page")
	public void user_should_be_on_new_article_page() {
		loginConduitPage.clickNewArticle();
		boolean isOnNewArticlePage = ArticleConduitPage.isOnNewArticle();
		  Assert.assertTrue(isOnNewArticlePage);
	}
	@When("User enters Article details")
	public void user_enters_article_details(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String title = data.get(0).get(0);
		String shortDescription= data.get(0).get(1);
		String Description= data.get(0).get(2);
		String Tags= data.get(0).get(3);
		ArticleConduitPage.enterTitle(title);
		ArticleConduitPage.enterShortDescription(shortDescription);
		ArticleConduitPage.enterDescription(Description);
		ArticleConduitPage.enterTags(Tags);
	}
    
	@Then("Article must be created")
	public void article_must_be_created() throws InterruptedException {
	     ArticleConduitPage.clickPublishArticle();
	     Thread.sleep(2000);
	}
	
	// Given should be on Global Feed page
	 //When User select an article "Article Title"
	 //Then Article details must be displayed
	     
	 @Given("User should be on Global Feed page")
	  public void user_should_be_on_global_feed_page() throws InterruptedException {
		 viewArticle.clickHome();
		 Thread.sleep(2000);
	  viewArticle.clickGlobalFeed();
	  boolean isOnGlobalFeedPage = viewArticle.isOnGlobalFeed();
	  Assert.assertTrue(isOnGlobalFeedPage);
	  
 }
	 	@When("User select an article {string}")
	 	public void user_select_an_article(String string) {
	 	    viewArticle.clickUserFeed();
	 	    
	 	}
	 	@Then("Article details must be displayed")
	 	public void article_details_must_be_displayed1() {
	 	    boolean isOnUserArticlePage = updateArticle.isOnUserArticle();
		  Assert.assertTrue(isOnUserArticlePage);
			
	 	}

	
@Given("Article page must be displayed")
public void article_page_must_be_displayed() {
	boolean isOnUserArticlePage = updateArticle.isOnUserArticle();
	  Assert.assertTrue(isOnUserArticlePage);
	  updateArticle.clickEditArticle();
	}
@When("User update Article details")
public void user_update_article_details(DataTable dataTable) {
	List<List<String>> data = dataTable.asLists();
	String title = data.get(0).get(0);
	String shortDescription= data.get(0).get(1);
	String Description= data.get(0).get(2);
	String Tags= data.get(0).get(3);
	updateArticle.enterTitle(title);
	updateArticle.enterShortDescription(shortDescription);
	updateArticle.enterDescription(Description);
	updateArticle.enterTags(Tags);

}
@Then("Article details must be updated")
public void article_details_must_be_updated() {
	    updateArticle.clickUpdateArticle();
	    boolean isOnUserArticlePage = updateArticle.isOnUserArticle();
		  Assert.assertTrue(isOnUserArticlePage);
}

@Given("Article must be displayed")
public void article_must_be_displayed() {
	DeleteArticle.clickDeleteButton();   
	}
	@When("User deletes Article")
	public void user_deletes_article() {
	    Alert alert = driver.switchTo().alert();
	    alert.accept(); 
	}
	@Then("Article must be deleted")
	public void article_must_be_deleted() {
		boolean isUserArticleDeleted= DeleteArticle.isArticleDeleted();
	   Assert.assertTrue(isUserArticleDeleted);
	}
}

