package baseHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SimplifyUtils extends BrowserLauncher {

	public static String browserName = null;

	public static void mouserhoverbywebelement(WebElement we)
	{

		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(we).build().perform();
		}
		catch(Exception e)
		{
			Assert.fail("Exception in method mouserhoverbywebelement",e);
		}
	}

	public static void clearTextField(WebElement element) {

		element.clear();

	}

	public static void clickWebelement(WebElement element) {

		try {

			boolean elementIsClickable = element.isEnabled();

			while (elementIsClickable) {

				element.click();

			}

		} catch (Exception e) {

			System.out.println("Element is not enabled");

			e.printStackTrace();

		}

	}

	public static void clickMultipleElements(WebElement someElement, WebElement someOtherElement) {

		Actions builder = new Actions(driver);

		builder.keyDown(Keys.CONTROL).click(someElement).click(someOtherElement).keyUp(Keys.CONTROL).build().perform();

	}

	public static void checkbox_Checking(WebElement checkbox) {

		boolean checkstatus;

		checkstatus = checkbox.isSelected();

		if (checkstatus == true) {

			System.out.println("Checkbox is already checked");

		} else {

			checkbox.click();

			System.out.println("Checked the checkbox");
		}
	}

	public static void checkboxList_Checking( WebElement element) {

		List<WebElement> allOptions = element.findElements(By.id("relationshipS"));

		for (WebElement option : allOptions) 
		{
			option.click();

		}
	}

	public static void checkbox_Unchecking(WebElement checkbox) {

		boolean checkstatus;

		checkstatus = checkbox.isSelected();

		if (checkstatus == true) {

			checkbox.click();

			System.out.println("Checkbox is unchecked");

		} else {

			System.out.println("Checkbox is already unchecked");

		}
	}

	public static  String dateGenerator() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		//get current date time with Date()

		Date date = new Date();

		//		System.out.println(dateFormat.format(date));

		String dateAndTime = dateFormat.format(date);

		return dateAndTime;

	}


	/*	public static String getBrowserName() {

		browserName = System.getProperty(browserName);

		if (browserName == null)

			browserName = ;

		return browserName;

	}*/

	public static void switchToNewWindow() {

		Set s = driver.getWindowHandles();

		Iterator itr = s.iterator();

		String w1 = (String) itr.next();

		String w2 = (String) itr.next();

		driver.switchTo().window(w2);

	}

	public static void switchToOldWindow() {

		Set s = driver.getWindowHandles();

		Iterator itr = s.iterator();

		String w1 = (String) itr.next();

		String w2 = (String) itr.next();

		driver.switchTo().window(w1);

	}

	public static void switchToParentWindow() {

		driver.switchTo().defaultContent();

	}
	
	public static void waitForElementToBeClickable(WebElement element, int timeToWait) {

		WebDriverWait wait = new WebDriverWait(driver, timeToWait);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitTillElementFound(WebElement ElementTobeFound,int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));

	}

	public static void fluentWait(){

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});

	}

	public static void takeScreenshotOfWebelement(WebDriver driver, WebElement element, String Destination) throws Exception {

		File v = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage bi = ImageIO.read(v);

		org.openqa.selenium.Point p = element.getLocation();

		int n = element.getSize().getWidth();

		int m = element.getSize().getHeight();

		BufferedImage d = bi.getSubimage(p.getX(), p.getY(), n, m);

		ImageIO.write(d, "png", v);

		FileUtils.copyFile(v, new File(Destination));
	}

	public static void setWindowSize(int Dimension1, int dimension2) {

		driver.manage().window().setSize(new Dimension(Dimension1, dimension2));

	}

	public static void takeScreenshotMethod(String Destination) throws Exception {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File(Destination));
	}

	public static void pressKeyDown(WebElement element) {

		element.sendKeys(Keys.DOWN);

	}

	public void pressKeyEnter(WebElement element) {

		element.sendKeys(Keys.ENTER);

	}

	public static void pressKeyUp(WebElement element) {

		element.sendKeys(Keys.UP);

	}

	public static void moveToTab(WebElement element) {

		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));

	}

	public static void handleHTTPS_IEbrowser() {

		driver.navigate().to("javascript:document.getElementById('overridelink').click()");

	}

	public static void handleHTTPS_Firefox() {

		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(false);

		driver = new FirefoxDriver(profile);

	}

	public static void waitTillPageLoad(int i) {

		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);

	}

	public static void keyboardEvents(WebElement webelement, Keys key, String alphabet) {

		webelement.sendKeys(Keys.chord(key, alphabet));

	}

	public static void navigateForward() {

		driver.navigate().forward();

	}

	public static void navigateBack() {

		driver.navigate().back();

	}

	public static void pageRefresh() {

		driver.navigate().refresh();

	}

	public static void implicitlyWaitFor(int t) {

		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);

	}

	public static void highlightelement(WebElement element) {

		for (int i = 0; i < 4; i++) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript(

					"arguments[0].setAttribute('style', arguments[1]);",

					element, "color: solid red; border: 6px solid yellow;");

			js.executeScript(

					"arguments[0].setAttribute('style', arguments[1]);",

					element, "");

		}

	}

	public static boolean checkAlert_Accept() {

		try {

			Alert a = driver.switchTo().alert();

			String str = a.getText();

			System.out.println(str);

			a.accept();

			return true;

		} catch (Exception e) {

			System.out.println("no alert ");

			return false;

		}
	}

	public static boolean checkAlert_Dismiss() {

		try {

			Alert a = driver.switchTo().alert();

			String str = a.getText();

			System.out.println(str);

			a.dismiss();

			return true;

		} catch (Exception e) {

			System.out.println("no alert ");

			return false;

		}
	}

	public static void scrolltoElementUsingCoordinates(WebElement ScrolltoThisElement) {

		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();

		coordinate.onPage();

		coordinate.inViewPort();
	}
	

	public static void scrolltoElementByLocator(WebElement ScrolltoThisElement) {

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ScrolltoThisElement);

	}
	

	public static void radiobutton_Select(WebElement Radio) {

		boolean checkstatus;

		checkstatus = Radio.isSelected();

		if (checkstatus == true) {

			System.out.println("RadioButton is already checked");

		} else {

			Radio.click();

			System.out.println("Selected the Radiobutton");

		}

	}

	public static void radioButton_Deselect(WebElement Radio) {

		boolean checkstatus;

		checkstatus = Radio.isSelected();

		if (checkstatus == true) {

			Radio.click();

			System.out.println("Radio Button is deselected");

		} else {

			System.out.println("Radio Button was already Deselected");

		}

	}

	public static void dragAndDrop(WebElement fromWebElement, WebElement toWebElement) {

		Actions builder = new Actions(driver);

		builder.dragAndDrop(fromWebElement, toWebElement);

	}

	public static void dragAndDrop_Method2(WebElement fromWebElement, WebElement toWebElement) {

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement).build();

		dragAndDrop.perform();
	}

	public static void dragAndDrop_Method3(WebElement fromWebElement, WebElement toWebElement) throws InterruptedException {

		Actions builder = new Actions(driver);

		builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();

		Thread.sleep(2000);

		builder.release(toWebElement).build().perform();

	}

	public static void dragAndDrop_Method4(WebElement fromWebElement, int xOffset, int yOffset) {

		Actions builder = new Actions(driver);

		Action action = (Action) builder.dragAndDropBy(fromWebElement, xOffset, yOffset).build();

		action.perform();

	}

	public static void hoverWebelement(WebElement HovertoWebElement) throws InterruptedException {

		Actions builder = new Actions(driver);

		builder.moveToElement(HovertoWebElement).perform();

		Thread.sleep(2000);

	}

	public static void doubleClickWebelement(WebElement doubleclickonWebElement) {

		Actions builder = new Actions(driver);

		builder.doubleClick(doubleclickonWebElement).perform();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {

		String tooltip = toolTipofWebElement.getAttribute("title");

		System.out.println("Tool text : " + tooltip);

		return tooltip;
	}

	public static void selectElementByNameMethod(WebElement element, String Name) {

		Select selectitem = new Select(element);

		selectitem.selectByVisibleText(Name);
	}

	public static void selectElementByValue(WebElement element, String value) {

		Select selectitem = new Select(element);

		selectitem.selectByValue(value);
	}

	public static void selectElementByIndexMethod(WebElement element, int index) {

		Select selectitem = new Select(element);

		selectitem.selectByIndex(index);
	}

	public static void selectElementByVisibleText(WebElement element, String Name) {



		Select selectitem = new Select(element);

		selectitem.selectByVisibleText(Name);
	}

	public static  int getCounOfAllValuesInDropDwown(WebElement element) {

		Select oselect = new Select(element);

		List <WebElement> elementCount = oselect.getOptions();

		int iSize = elementCount.size();

		return iSize;

	}

	public static String getDefaultValueText(WebElement element) {

		Select selectitem = new Select(element);

		String defaultSelected = selectitem.getFirstSelectedOption().getText();

		return defaultSelected;

	}

	public static void s360sleep(int timeInMilliSeconds){

		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	} 

	public static ArrayList<String> getAllValuesInDropDwown(WebElement element) {

		Select valuesInDropDown = new Select(element);

		List <WebElement> elementCount = valuesInDropDown.getOptions();

		//		System.out.println("Count of Options"+elementCount.size());

		// 		For printing the values 

		// 		Got the below code from http://stackoverflow.com/questions/14098032/add-string-to-string-array

		ArrayList <String> values = new ArrayList<String>();

		for(int i =0; i<elementCount.size() ; i++){

			values.add(elementCount.get(i).getText());

			System.out.println("Values in Drop Down are ===> "+values);

		}

		return values;

	}

	public static void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {

		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));

		for (int i = 0; i < lst.size(); i++) {

			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));

			for (WebElement f : dr) {

				System.out.println("value in the list : " + f.getText());

				if (valueToSelect.equals(f.getText())) {

					f.click();

					break;
				}

			}

		}

	}

	public static void downloadFile(String href, String fileName) throws Exception {

		URL url = null;

		URLConnection con = null;

		int i;

		url = new URL(href);

		con = url.openConnection();

		File file = new File(".//OutputData//" + fileName);

		BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

		BufferedOutputStream bos = new BufferedOutputStream(

				new FileOutputStream(file));

		while ((i = bis.read()) != -1) {

			bos.write(i);

		}

		bos.flush();

		bis.close();

	}

	public static void navigateToEveryLinkInPage() throws InterruptedException {

		List<WebElement> linksize = driver.findElements(By.tagName("a"));

		int linksCount = linksize.size();

		System.out.println("Total no of links Available: " + linksCount);

		String[] links = new String[linksCount];

		System.out.println("List of links Available: ");

		// print all the links from webpage

		for (int i = 0; i < linksCount; i++) {

			links[i] = linksize.get(i).getAttribute("href");

			System.out.println(linksize.get(i).getAttribute("href"));

		}

		// navigate to each Link on the webpage

		for (int i = 0; i < linksCount; i++) {

			driver.navigate().to(links[i]);

			Thread.sleep(3000);

			System.out.println(driver.getTitle());

		}
	}

	public static void clickAllLinksInPage(String destinationOfScreenshot)
			throws Exception {

		List<WebElement> Links = driver.findElements(By.tagName("a"));

		System.out.println("Total number of links  :" + Links.size());

		for (int p = 0; p < Links.size(); p++) {

			System.out.println("Elements present the body :" + Links.get(p).getText());

			Links.get(p).click();

			Thread.sleep(3000);

			System.out.println("Url of the page  " + p + ")" + driver.getCurrentUrl());

			takeScreenshotMethod(destinationOfScreenshot + p);

			navigateBack();

			Thread.sleep(2000);

		}

	}

	public static int[] getElementLocationInTable(List<WebElement> tableElement, String requiredElementText)
	{

		int rowData[]  = new int[2];

		int rowNo = 1;

		List<WebElement> tr_collection = tableElement ;

		//System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ (tr_collection.size()-1));

		for(WebElement trElement : tr_collection){

			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));

			int colNo=1;

			for(WebElement tdElement : td_collection){

				if(tdElement.getText().equalsIgnoreCase(requiredElementText))

				{

					rowData[0]=rowNo;

					rowData[1]=colNo;

					//		System.err.println(rowData[0] + rowData[1] );

				}

				colNo++;

			}

			rowNo++;

		}

		return rowData;

	}

	public void example_VerifyExpectedFileName() {

		//https://www.seleniumeasy.com/selenium-tutorials/verify-file-after-downloading-using-webdriver-java

		String downloadPath = null;

		driver.findElement(By.linkText("mailmerge.xls")).click();

		File getLatestFile = getLatestFilefromDir( downloadPath);

		String fileName = getLatestFile.getName();

		Assert.assertTrue(fileName.equals("mailmerge.xls"), "Downloaded file name is not matching with expected file name");
	}

	private File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	// Code to identify Popup and Close the Popup if Present
	public static void closePopUp() {
		// It will store the count of Open Windows in Browser
		Set<String> windowIds = driver.getWindowHandles();
		if (windowIds.size() == 2) {
			Iterator<String> itr = windowIds.iterator();
			// Store main window ID
			String mainWin = itr.next();
			// Store Child Window Id
			String childWin = itr.next();
			// Switch to popup/new window and close it
			driver.switchTo().window(childWin);
			driver.close();
			// Switch back to main window
			driver.switchTo().window(mainWin);
		}
	}

	public static String getPageTitle(){

		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public static String generateEpocTime(){

		Date d = new Date();

		long millis = d.getTime() + 15 * 60 * 1000; // epoch time / unix time 

		String epoc = Long.toString(millis);

		return epoc;

	}

	public static void turnOnIosSwitch(WebElement elementedToCheck, WebElement elementToClick){

		if(elementedToCheck.isDisplayed()) //pass the element when switch is Off
		{
			elementToClick.click();
		}

	}
	
	public static void turnOffIosSwitch(WebElement elementedToCheck, WebElement elementToClick){

		if(elementedToCheck.isDisplayed()) //pass the element when switch is ON
		{
			elementToClick.click();
		}

	}

}
