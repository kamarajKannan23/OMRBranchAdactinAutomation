package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmPage extends BaseClass {

	static String orderId;

	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement txtOrderNo;

	@FindBy(xpath ="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingHeader;

	public WebElement getTxtBookingHeader() {
		return txtBookingHeader;
	}

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public String getBookingId() {
		orderId = elementGetAttribute(getTxtOrderNo());
		System.out.println("id:" + orderId);

		return orderId;
	}

}
