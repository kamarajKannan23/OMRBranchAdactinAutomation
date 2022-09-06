package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Kamaraj
 * @description Used to maintain all reusable methods
 * @date 29/08/2022
 */

public class BaseClass {

	public static WebDriver driver;

	/**
	 * @description Used to setup and launch browser based on the given browserType
	 * @param browserType
	 * 
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

	}

	/**
	 * @description Used to get the values from property
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));

		String value = (String) properties.get(key);
		return value;
	}

	/**
	 * @description Used to launch given url in browser
	 * @param url
	 */
	public static void enterUrl(String url) {
		driver.get(url);
	}

	/**
	 * @description Used to maximize browser
	 */
	public static void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * @description Used to locate webElement by id
	 * @param id
	 * @return WebElement
	 */
	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}

	/**
	 * @description Used to locate webElement by name
	 * @param name
	 * @return WebElement
	 */
	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	/**
	 * @description Used to locate webElement by className
	 * @param className
	 * @return WebElement
	 */
	public static WebElement findElementByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	/**
	 * @description Used to locate webElement by xpath
	 * @param xpath
	 * @return WebElement
	 */
	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * @description Used to get title of webpage
	 * @return String
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @description Used to get current url of webpage
	 * @return String
	 */
	public static String geturl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	/**
	 * @description Used to enter value in InputFields
	 * @param element
	 * @param data
	 */
	public static void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * @description Used to enter value in InputFields and press enter
	 * @param element
	 * @param data
	 */
	public static void elementSendKeysWithEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

	/**
	 * @description Used to clear value in InputFields
	 * @param element
	 */
	public static void elementClear(WebElement element) {
		element.clear();

	}

	/**
	 * @description Used to do click given webElement
	 * @param element
	 */
	public static void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * @description Used to do close all the window
	 */
	public static void closeAllWindow() {
		driver.quit();
	}

	/**
	 * @description Used to get text value in WebElement
	 * @param element
	 * @return String
	 */
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @description Used to get entered value in InputFields or to get value from
	 *              attributeValue from WebElement
	 * @param element
	 * @return String
	 */
	public static String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @description Used to get given attribute value from WebElement
	 * @param element
	 * @return String
	 */
	public static String getAttribute(WebElement element, String attributename) {
		String attribute = element.getAttribute(attributename);
		return attribute;
	}

	/**
	 * @description Used to select DropDown by given Text
	 * @param element
	 * @param String
	 */
	public static void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @description Used to select DropDown by given Value
	 * @param element
	 * @param value
	 */
	public static void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @description Used to select DropDown by given Index
	 * @param element
	 * @param index
	 */
	public static void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @description Used to enter value in InputFields by JS
	 * @param element
	 * @param text
	 */
	public static void typeJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	/**
	 * @description Used to get value from element by JS
	 * @param element
	 * @param text
	 */
	public Object getJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object object = executor.executeScript("return arguments[0].getAttribute('value')", element);
		return object;
	}

	/**
	 * @description Used to click given WebElement by JS
	 * @param element
	 * @param text
	 */
	public static void clickJs(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	/**
	 * @description Used to pointer cursor in given WebElement
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * @description Used to drag one WebElement into another location
	 * @param source
	 * @param destination
	 */
	public static void dragandDrop(String source, String destination) {
		WebElement element = driver.findElement(By.id(source));
		WebElement element2 = driver.findElement(By.id(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element2).perform();
	}

	/**
	 * @description Used to navigate to given url
	 * @param url
	 */
	public static void navigateurl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @description Used to navigate to previous page in history
	 */
	public static void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * @description Used to navigate to next page in history
	 */
	public static void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * @description Used to refresh history
	 */
	public static void navigateFresh() {
		driver.navigate().refresh();
	}

	/**
	 * @description Used to rightClick a given WebElement
	 * @param element
	 */
	public static void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	/**
	 * @description Used to enter value a given WebElement using action class
	 * @param element
	 * @param text
	 */
	public static void keyUpKeyDown(WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(element, text).keyUp(Keys.SHIFT).perform();
	}

	/**
	 * @description Used to doubleClick on the given WebElement
	 * @param element
	 */
	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * @description Used to perform ok in Alert
	 */
	public static void alertOK() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @description Used to perform cancel in Alert
	 */
	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * @description Used to insert value in prompt Alert
	 */
	public static void alertPrompt(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	/**
	 * @description Used to get text of message from Alert
	 * @return string
	 */
	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	/**
	 * @description Used to take screenshot of screen
	 * @param path
	 * @return file
	 * @throws IOException
	 */
	protected File getScreenShot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return source;

	}

	/**
	 * @description Used to scrollDown by JS
	 * @param element
	 */
	public static void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * @description Used to scrollUp by JS
	 * @param element
	 */
	public static void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	/**
	 * @description Used to switch to frame by Index
	 * @param index
	 */
	public static void frame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @description Used to switch to frame by Name
	 * @param name
	 */
	public static void frame1(String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * @description Used to switch to frame by WebElement
	 * @param element
	 */
	public static void frame2(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * @description Used to switch to parent frame
	 */
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * @description Used to switch to main page
	 */
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * @description Used to get the address of the current window
	 */
	public String parentWindow() {
		String handle = driver.getWindowHandle();
		return handle;
	}

	/**
	 * @description Used to get set of address of all opened windows
	 * @return Set<String>
	 */
	public Set<String> allWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * @description Used to verify select element support selecting multiple options
	 *              in DropDown
	 * @param element
	 * @return boolean
	 */
	public boolean selectIsMultiple(WebElement element) {
		Select select = new Select(element);
		boolean b = select.isMultiple();
		return b;
	}

	/**
	 * @description Used to deselect all the selected options in DropDown
	 * @param element
	 */
	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @description Used to deselect option By Index in DropDown
	 * @param element
	 * @param index
	 */
	public static void deselectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @description Used to deselect option By value in DropDown
	 * @param element
	 * @param value
	 */
	public static void deselectOptionvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * @description Used to deselect option By text in DropDown
	 * @param element
	 * @param text
	 */
	public static void deselectOptionVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @description Used to get first selected option in DropDown
	 * @param element
	 * @return WebElement
	 */
	public WebElement getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	/**
	 * @description Used to get all selected options in DropDown
	 * @param element
	 * @return list<WebElement>
	 */
	public List allSelectedOption(WebElement element) {
		Select select = new Select(element);
		List allSelectedOptions = (List) select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * @description Used to get all options in given DropDown WebElement
	 * @param element
	 * @return List of
	 */
	public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	/**
	 * @description Used to read value data in Excel
	 * @param path
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */
	public static String readValueExcel(String path, String sheetName, int rowNum, int cellNum) throws IOException {
		// path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel
		// Sheets\\WorkSheeOne.xlsx"

		String res = null;

		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
				res = dateFormat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				long check = Math.round(d);

				if (check == d) {
					res = String.valueOf(d);
				}
				res = String.valueOf(check);
			}
			break;
		default:
			break;
		}
		workbook.close();
		return res;
	}

	/**
	 * @description Used to update existing data in Excel
	 * @param path
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param olddata
	 * @param newData
	 * @throws IOException
	 */
	public static void update(String path, String sheetName, int rowNum, int cellNum, String olddata, String newData)
			throws IOException {
		// path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel
		// Sheets\\WorkSheeOne.xlsx"

		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);

		String value = cell.getStringCellValue();

		if (value.equals(olddata)) {
			cell.setCellValue(newData);

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
		}
	}

	/**
	 * @description Used to write data in Excel
	 * @param path
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param newData
	 * @throws IOException
	 */
	/* Assume Row Already created */
	public static void writeData(String path, String sheetName, int rowNum, int cellNum, String newData)
			throws IOException {
		// path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel
		// Sheets\\WorkSheeOne.xlsx"

		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);

		// set Value
		cell.setCellValue(newData);

		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
}
