package com.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass extends BaseClass {

	public TestBaseClass() {
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// WebDriver driver = new ChromeDriver();
		// driver.get("http://demo.automationtesting.in/Alerts.html");
		// driver.manage().window().maximize();
		// Alert alert = driver.switchTo().alert();
		// alert.accept();

		getDriver("chrome");
		enterUrl("http://demo.automationtesting.in/Alerts.html");
		Thread.sleep(3000);

		WebElement btnAlert = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
		btnAlert.click();
		Thread.sleep(3000);
		alertOK();

	}
}
