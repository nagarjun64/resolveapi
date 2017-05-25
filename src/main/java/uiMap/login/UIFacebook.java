package uiMap.login;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UIFacebook {

	public UIFacebook (WebDriver driver) {

		PageFactory.initElements(driver, this);

	}


	//================================Login Page================//
	//UserName
	@FindBy(id = "email")
	public WebElement userName;

	//Password
	@FindBy(id = "pass")
	public WebElement userPassword;

	//LoginButton
	@FindBy(id="loginbutton")
	public WebElement loginButton;

	//================================Facebook Home After Login================//


	//Find Friends
	@FindBy(id="findFriendsNav")
	public WebElement findFriends;
	
	//Saved section on left side to see the saved one
	@FindBy(xpath="//*[@id='appsNav']//div[contains(.,'Saved')]")
	public WebElement savedSection;
	
	//search box for page
	@FindBy(xpath="//input[contains(@class,'_1frb')]")
	public WebElement searchBox;

	//search box for page
	@FindBy(xpath="//*[@data-testid='facebar_search_button']")
	public WebElement searchButton;

	//Search Results
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@data-xt]/a"))
	public List<WebElement> searchResults;

	//Page Name
	@FindBy(xpath="//*[@class='_2wmb']")
	public WebElement pageName;

	//Post Link
	@FindBy(xpath="//div[@class='clearfix']//span[contains(text(), 'Posts')]")
	public WebElement postLink;

	//Content to be posted (//*[@id='PageComposerPagelet_']//textarea[contains(@placeholder,'Write something on this Page')])
	@FindBy(xpath="//*[@id='PageComposerPagelet_']//textarea")
	public WebElement messageToPost;

	//Entered Message
	@FindBy(xpath="//*[@id='PageComposerPagelet_']//div[contains(@spellcheck,'true')]//span/span")
	public WebElement messageEntered;

	//Post message button (//*[@id='PageComposerPagelet_']//button[contains(., 'Post')]) (//button[contains(@data-testid, 'react-composer-post-button')])
	@FindBy(xpath="//*[@id='PageComposerPagelet_']//button[contains(., 'Post')]")
	public WebElement postMessage;
	//*[@id='PageComposerPagelet_']//button[@data-testid='react-composer-post-button']




}
