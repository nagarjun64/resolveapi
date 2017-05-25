package tcAutoPost;


import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import uiMap.login.UIFacebook;
import actions.LoginToApplication;
import actions.listen.FBSearchHome;
import baseHelper.BrowserLauncher;
import baseHelper.ReadPropertiesFile;
import baseHelper.SimplifyUtils;

public class TCAutoFanPost extends BrowserLauncher {

	final static Logger log = Logger.getLogger(TCAutoFanPost.class);


	//================================General Related Test cases=========//

	@Test
	public void verifyPostinFirstPostToGetStarted(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		try {
			UIFacebook uiFacebook = new UIFacebook(driver);

			loginToApplication.loginAsFan();

			log.info("logged in to facebok");

			SimplifyUtils.s360sleep(5000);

			driver.get(ReadPropertiesFile.getStartedPageLink);

			log.info("Opening the page ==> "+ ReadPropertiesFile.getStartedPageLink);

			String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[0].title");

			SimplifyUtils.s360sleep(5000);

			log.info("Posting the message ==> "+ messagetoPost);

			fbSearchHome.postMessage(messagetoPost);

			SimplifyUtils.s360sleep(5000);
			
		} catch (Exception e) {
			
			log.error("error in verifyPostinFirstPostToGetStarted"+ e);
		}

	}

	@Test
	public void verifyPostinSecondPostToGetStarted(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		UIFacebook uiFacebook = new UIFacebook(driver);

		loginToApplication.loginAsFan();

		SimplifyUtils.s360sleep(5000);

		driver.get(ReadPropertiesFile.getStartedPageLink);

		String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[1].description");

		SimplifyUtils.s360sleep(5000);

		fbSearchHome.postMessage(messagetoPost);

		SimplifyUtils.s360sleep(5000);

	}

	@Test
	public void verifyPostinFirstPostToFastCarTest(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		UIFacebook uiFacebook = new UIFacebook(driver);

		loginToApplication.loginAsFan();

		log.info("logged in to facebok");

		SimplifyUtils.s360sleep(5000);

		driver.get(ReadPropertiesFile.fastCarTestPageLink);

		log.info("Opening the page ==> "+ ReadPropertiesFile.getStartedPageLink);

		String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[2].title");

		SimplifyUtils.s360sleep(5000);

		log.info("Posting the message ==> "+ messagetoPost);

		fbSearchHome.postMessage(messagetoPost);

		SimplifyUtils.s360sleep(5000);

	}

	@Test
	public void verifyPostinSecondPostToFastCarTest(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		UIFacebook uiFacebook = new UIFacebook(driver);

		loginToApplication.loginAsFan();

		SimplifyUtils.s360sleep(5000);

		driver.get(ReadPropertiesFile.fastCarTestPageLink);

		String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[3].description");

		SimplifyUtils.s360sleep(5000);

		fbSearchHome.postMessage(messagetoPost);

		SimplifyUtils.s360sleep(5000);

	}

	@Test
	public void verifyPostinFirstPostToRHTestPage(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		UIFacebook uiFacebook = new UIFacebook(driver);

		loginToApplication.loginAsFan();

		SimplifyUtils.s360sleep(5000);

		driver.get(ReadPropertiesFile.rhTestPageLink);

		String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[4].title");

		SimplifyUtils.s360sleep(5000);

		fbSearchHome.postMessage(messagetoPost);

		SimplifyUtils.s360sleep(5000);

	}

	@Test
	public void verifyPostinSecondPostToRHTestPage(){

		LoginToApplication loginToApplication = new LoginToApplication();
		FBSearchHome fbSearchHome = new FBSearchHome();

		UIFacebook uiFacebook = new UIFacebook(driver);

		loginToApplication.loginAsFan();

		SimplifyUtils.s360sleep(5000);

		driver.get(ReadPropertiesFile.rhTestPageLink);

		String messagetoPost = fbSearchHome.generateMessage().jsonPath().get("articles[4].description");

		SimplifyUtils.s360sleep(5000);

		fbSearchHome.postMessage(messagetoPost);

		SimplifyUtils.s360sleep(5000);

	}

}
