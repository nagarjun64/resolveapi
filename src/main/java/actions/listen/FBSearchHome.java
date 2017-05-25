package actions.listen;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.with;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tcAutoPost.TCAutoFanPost;
import uiMap.login.UIFacebook;
import baseHelper.BrowserLauncher;
import baseHelper.ReadPropertiesFile;
import baseHelper.SimplifyUtils;

public class FBSearchHome extends BrowserLauncher{
	
	final static Logger log = Logger.getLogger(FBSearchHome.class);
	
	
	public void postMessage(String MessageToBePosted){

		UIFacebook uiFacebook = new UIFacebook(driver);
		
		SimplifyUtils.s360sleep(5000);

		log.info("inside Post Message Method");
		
		SimplifyUtils.scrolltoElementByLocator(uiFacebook.postLink);
		
		SimplifyUtils.s360sleep(5000);
		
		uiFacebook.postLink.click();
		
		log.info("Clicked on Post Link on the facebook page");
		
		SimplifyUtils.s360sleep(5000);
		
		log.info("Posting this message ==>"+MessageToBePosted);
		
		uiFacebook.messageToPost.sendKeys(MessageToBePosted);
		
		SimplifyUtils.s360sleep(5000);

		uiFacebook.postMessage.click();
		
		log.info("Clicked on Post message Button and the message is posted");
		
		SimplifyUtils.s360sleep(5000);

	}

	public Response generateMessage(){

		Response resp = given().when().get("https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=2af035535f0942c1a7f426d35dd9564b");
		
		log.info("Generated the response" + resp.toString());

		return resp;

	}

	public void openPageFromSearch(String pageId){

		UIFacebook uiFacebook = new UIFacebook(driver);
		
		SimplifyUtils.waitForElementToBeClickable(uiFacebook.findFriends, 30);
		
		uiFacebook.searchBox.sendKeys(ReadPropertiesFile.fbPage);

		SimplifyUtils.s360sleep(4000);

		uiFacebook.searchButton.click();

		int count= uiFacebook.searchResults.size();

		for (int i = 0; i < uiFacebook.searchResults.size(); i++) 

		{
			String pageToMatch = uiFacebook.searchResults.get(i).getAttribute("data-hovercard");

			System.err.println(pageToMatch);

			if (pageToMatch.contains(pageId)) 
			{
				System.err.println(pageToMatch);

				SimplifyUtils.s360sleep(1000);

				uiFacebook.searchResults.get(i).click();

				break;

			}
		}

		SimplifyUtils.s360sleep(5000);

	}
	
	public void openPageFromSaved(String PageName){

		UIFacebook uiFacebook = new UIFacebook(driver);
		
		uiFacebook.savedSection.click();
		
		driver.findElement(By.xpath("//span[contains(., '" +PageName+ "')]")).click();

	}


}
