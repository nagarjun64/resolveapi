package actions;

import uiMap.login.UIFacebook;
import baseHelper.BrowserLauncher;
import baseHelper.ReadPropertiesFile;
import baseHelper.SimplifyUtils;

public class LoginToApplication extends BrowserLauncher {
	
	
	public void loginAsFan(){

		UIFacebook loginHome = new UIFacebook(driver);
		
		loginHome.userName.clear();
		
		loginHome.userName.sendKeys(ReadPropertiesFile.fbFanAccount);
		
		SimplifyUtils.s360sleep(1000);
		
		loginHome.userPassword.clear();

		loginHome.userPassword.sendKeys(ReadPropertiesFile.fbFanPassword);
		
		SimplifyUtils.s360sleep(1000);
		
		loginHome.loginButton.click();
	}


}
