package com.stepdefinition;

import java.util.List;
import java.util.Map;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should perform book hotel {string},{string} and {string}")
	public void userShouldPerformBookHotelAnd(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> cards = dataTable.asMaps();

		Map<String, String> card = cards.get(0);
		String cardType = card.get("cardType");
		String cardNo = card.get("cardNo");
		String expMonth = card.get("expMonth");
		String expYear = card.get("expYear");
		String cvv = card.get("cvv");

		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, cardType, cardNo, expMonth, expYear, cvv);

	}

	@When("User should click book now without enter any fields")
	public void userShouldClickBookNowWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify error messages after book now {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMessagesAfterBookNowAnd(String expFirstNameError, String expLastNameError,
			String expAddressError, String expCcNumError, String expCcTypeError, String expCcExpMonthError,
			String expCcvError) {

		String actualFirstNameError = pom.getBookHotelPage().getLblFirstNameErrorMsg().getText();
		Assert.assertEquals("verify FirstNameError Message", expFirstNameError, actualFirstNameError);

		String actualLastNameError = pom.getBookHotelPage().getLblLastNameErrorMsg().getText();
		Assert.assertEquals("verify LastNameError Message", expLastNameError, actualLastNameError);

		String actualAddressError = pom.getBookHotelPage().getLblAddressErrorMsg().getText();
		Assert.assertEquals("verify AddressError Message", expAddressError, actualAddressError);

		String actualCcNumErrorr = pom.getBookHotelPage().getLblCcNumErrorMsg().getText();
		Assert.assertEquals("verify CcNumError Message", expCcNumError, actualCcNumErrorr);

		String actualCcTypeError = pom.getBookHotelPage().getLblCcTypeErrorMsg().getText();
		Assert.assertEquals("verify CcTypeError Message", expCcTypeError, actualCcTypeError);

		String actualCcExpMonthError = pom.getBookHotelPage().getLblCcExpiryErrorMsg().getText();
		Assert.assertEquals("verify CcExpMonthError Message", expCcExpMonthError, actualCcExpMonthError);

		String actualCcvError = pom.getBookHotelPage().getLblCcvErrorMsg().getText();
		Assert.assertEquals("verify CcvError Message", expCcvError, actualCcvError);

	}

	@Then("User should verify after book hotel {string} is present")
	public void userShouldVerifyAfterBookHotelIsPresent(String expBookingSuccessMsg) throws InterruptedException {
		Thread.sleep(5000);
		String actualBookingSuccessMsg = pom.getBookingConfirmPage().getTxtBookingHeader().getText();
		Assert.assertEquals("verify a BookingSuccessMsg", expBookingSuccessMsg, actualBookingSuccessMsg);
		
	}

}
