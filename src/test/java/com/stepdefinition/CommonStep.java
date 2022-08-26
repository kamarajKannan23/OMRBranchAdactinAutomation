package com.stepdefinition;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after login {string}")
	public void userShouldVerifyAfterLogin(String expWelcomeMsg) {

		String actualWelcomeMsg = elementGetAttribute(pom.getSearchHotelPage().getLblUsername_show());
		Assert.assertEquals("verify after login welcome success msg", expWelcomeMsg, actualWelcomeMsg);
	}

}
