package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin Page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
	}

	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	@When("User should perform login {string},{string} with Enter Key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) {
		pom.getLoginPage().loginWithEnter(username, password);

	}

	@Then("User should verify Invalid login error message contains {string}")
	public void userShouldVerifyInvalidLoginErrorMessageContains(String expLoginPartErrorMsg) {
		String actualErrorMsg = pom.getLoginPage().getLblLoginError().getText();
		Assert.assertTrue(actualErrorMsg.contains(expLoginPartErrorMsg));
	}

}
