package baseHelper;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tcAutoPost.TCAutoFanPost;

public class BrowserLauncher {

	public static WebDriver driver ;

	final static Logger log = Logger.getLogger(BrowserLauncher.class);

	@BeforeMethod
	public void LaunchBrowser() {

		try {
			String OS = System.getProperty("os.name").toLowerCase();

			System.err.println("OS is + " + OS);

			if (ReadPropertiesFile.browser.equals("firefox"))
			{
				log.info("Inside firefox");
				//Currently using v0.16.1 geckodriver
				System.err.println(ReadPropertiesFile.browser);

				if(OS.contains("mac"))
				{
					System.setProperty("webdriver.gecko.driver", "src/test/resources/mac_geckodriver");
				}
				else if(OS.contains("linux")||OS.contains("ubuntu"))
				{
					log.info("Inside firefox + linux");
					System.setProperty("webdriver.gecko.driver", "src/test/resources/linux_Firefox_gecko");
				}

				else if(OS.contains("windows"))
				{
					System.setProperty("webdriver.gecko.driver", "src/test/resources/win64_geckodriver.exe");
				}

				driver = new FirefoxDriver();

				driver.manage().deleteAllCookies();
			}

			else if (ReadPropertiesFile.browser.equals("chrome"))
			{

				if(OS.contains("mac"))
				{
					System.setProperty("webdriver.chrome.driver", "src/test/resources/mac_chromedriver");

					ChromeOptions chromeOptions = new ChromeOptions();

					chromeOptions.addArguments("--kiosk");

					driver = new ChromeDriver(chromeOptions);

				}
				else if(OS.contains("linux")||OS.contains("ubuntu"))
				{

				}

				else if(OS.contains("windows"))
				{
					System.setProperty("webdriver.chrome.driver", "src/test/resources/win32_chromedriver.exe");

					ChromeOptions chromeOptions = new ChromeOptions();

					chromeOptions.addArguments("--start-maximized");

					driver = new ChromeDriver(chromeOptions);

					driver.manage().deleteAllCookies();
				}

				driver.manage().window().maximize();

			}
			else if (ReadPropertiesFile.browser.equals("headless"))
			{
				log.info("Inside HeadLess Browser");
				
				//phantomjs-2.1.1
				
				if(OS.contains("mac"))
				{

					File src = new File("src/test/resources/phantomjs_mac");

					System.setProperty("phantomjs.binary.path", src.getAbsolutePath());

				}
				else if(OS.contains("windows"))
				{
					File src = new File("src/test/resources/phantomjs.exe");

					System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
				}
				else if(OS.contains("linux")||OS.contains("ubuntu"))
				{
					log.info("Inside Linux + HeadLess Browser");

					File src = new File("src/test/resources/phantomjs_linux");

					System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
				}

				driver = new PhantomJSDriver();

				//			driver = new HtmlUnitDriver();

			}


			log.info("BROWSER CALLED");

			driver.get(ReadPropertiesFile.baseURL);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {

			log.error("Browser Launcher"+e);

			e.printStackTrace();

		}

	}

	@AfterMethod
	public void QuitBrowser() {

		try {

			driver.close();

			driver.quit();

			log.info("BROWSER CLOSED");

		} catch (Exception e) {

			log.error("Exception is"+e);

		}

	}

}
