package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
//tags="not @CancelBookingOnly"
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.stepdefinition", dryRun = false, stepNotifications = true, publish = true, plugin = {
		"pretty","json:target\\output.json" }, monochrome = true, snippets = SnippetType.CAMELCASE)

public class TestRunnerClass extends BaseClass{

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(System.getProperty("user.dir")+getPropertyFileValue("jsonPath"));
	}

	

}