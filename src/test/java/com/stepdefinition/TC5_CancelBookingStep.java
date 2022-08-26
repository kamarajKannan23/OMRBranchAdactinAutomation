package com.stepdefinition;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();


	@When("User should perform search orderId and cancel orderId")
	public void userShouldPerformSearchOrderIdAndCancelOrderId() throws InterruptedException {
		String bookingId = pom.getBookingConfirmPage().getBookingId();
		pom.getCancelBookingPagePage().cancelBooking(bookingId);
	}

	

	@When("User should perform search orderId and cancel orderId {string}")
	public void userShouldPerformSearchOrderIdAndCancelOrderId(String bookingId) {
		pom.getCancelBookingPagePage().cancelBooking(bookingId);
	}
	
	@Then("User should verify after cancel orderId {string}")
	public void userShouldVerifyAfterCancelOrderId(String expCancelledMsg) {
		String actualCancelledMsg = pom.getCancelBookingPagePage().getCancelledMsg().getText();
		Assert.assertEquals("verify a booking cancelled message", expCancelledMsg, actualCancelledMsg);

	}



}


