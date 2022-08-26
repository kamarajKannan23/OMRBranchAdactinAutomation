package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import junit.framework.Assert;

public class TC2_SearchHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User should perform search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelAnd(String location, String hotel, String roomType, String roomNos,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) {

		pom.getSearchHotelPage().searchHotel(location, hotel, roomType, roomNos, checkInDate, checkOutDate,
				adultsPerRoom, childPerRoom);
	}

	@Then("User should verify after search hotel navigates to select hotel page and verify {string} is present")
	public void userShouldVerifyAfterSearchHotelNavigatesToSelectHotelPageAndVerifyIsPresent(
			String lblSelectHotelText) {
		String actualSelectHotelText = pom.getSelectHotelPage().getLblSelectHotel().getText();
		Assert.assertEquals("verify after search hotel label Select Hotel", lblSelectHotelText, actualSelectHotelText);

	}

	@When("User should perform search hotel with only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelWithOnlyMandatoryFieldsAnd(String location, String roomNos,
			String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotel(location, roomNos, checkInDate, checkOutDate,
				adultsPerRoom);

	}

	@Then("User should verify an error messages in date fields after search hotel {string},{string}")
	public void userShouldVerifyAnErrorMessagesInDateFieldsAfterSearchHotel(String expCheckInErrorMsg,
			String expCheckOutErrorMsg) {
		String actualCheckInErrorMsg = pom.getSearchHotelPage().getLblCheckin_span().getText();
		String actualCheckOutErrorMsg = pom.getSearchHotelPage().getLblCheckout_span().getText();
		Assert.assertEquals("verify an error messages in CheckInErrorMsg", expCheckInErrorMsg, actualCheckInErrorMsg);
		Assert.assertEquals("verify an error messages in CheckOutErrorMsg", expCheckOutErrorMsg, actualCheckOutErrorMsg);

	}

	@When("User should click search button without entering any fields")
	public void userShouldClickSearchButtonWithoutEnteringAnyFields() {
		pom.getSearchHotelPage().SearchHotel();
	}

	@Then("User should verify an error message in location field after search hotel {string}")
	public void userShouldVerifyAnErrorMessageInLocationFieldAfterSearchHotel(String expLocationErrorMsg) {
		String actualLocationErrorMsg = pom.getSearchHotelPage().getLblLocation_span().getText();
		Assert.assertEquals("verify an error messages in CheckInErrorMsg", expLocationErrorMsg, actualLocationErrorMsg);
		
	}

}
