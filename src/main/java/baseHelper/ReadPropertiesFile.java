package baseHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	
	public static String baseURL;
	public static String browser;
	public static String os;
	public static String twitterAccount;
	public static String fbPage;
	public static String fbAccount;
	public static String fbAccountPassword;
	public static String fbFanAccount;
	public static String fbFanPassword;
	public static String getStartedPageLink;
	public static String fastCarTestPageLink;
	public static String rhTestPageLink;
	public static String twitterAccountPassword;
	public static String secondTwitterAccount;
	public static String secondTwitterAccountPassword;
	public static String ytAccountEmail;
	public static String ytAccount;
	public static String ytAccountPassword;
	public static String ytChannelName;


	static 
	{
		readConfigurationFromProperties();
	}

	public static void readConfigurationFromProperties() {

		try 
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/test/resources/config.properties"));

			baseURL = prop.getProperty("baseURL");
			browser = prop.getProperty("browser");
			os = prop.getProperty("os");
			twitterAccount = prop.getProperty("twitterAccount");
			twitterAccountPassword = prop.getProperty("twitterAccountPassword");
			fbPage = prop.getProperty("fbPage");
			fbAccount = prop.getProperty("fbAccount");
			fbAccountPassword = prop.getProperty("fbAccountPassword");
			fbFanAccount = prop.getProperty("fbFanAccount");
			fbFanPassword = prop.getProperty("fbFanPassword");
			getStartedPageLink = prop.getProperty("getStartedPageLink");
			fastCarTestPageLink = prop.getProperty("fastCarTestPageLink");
			rhTestPageLink = prop.getProperty("rhTestPageLink");
			secondTwitterAccount = prop.getProperty("secondTwitterAccount");
			secondTwitterAccountPassword = prop.getProperty("secondTwitterAccountPassword");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();

		} catch (IOException e) 
		{
			e.printStackTrace();

		}
	}


	
}
