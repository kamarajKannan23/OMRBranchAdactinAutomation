package com.stepdefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		System.out.println("Before Scenario");
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(b, "image.png", "Failed Scenario");
		}

		System.out.println("After Scenario");
		closeAllWindow();
	}
}
