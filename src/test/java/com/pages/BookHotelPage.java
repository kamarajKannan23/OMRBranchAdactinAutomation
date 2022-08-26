package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNo;

	@FindBy(id = "cc_type")
	private WebElement dDnCcType;

	@FindBy(id = "cc_exp_month")
	private WebElement dDnExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement dDnExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	@FindBy(id = "book_now")
	private WebElement btnBook;

	@FindBy(xpath = "//td[text()='Book A Hotel ']")

	private WebElement lblBookAHotel;

	@FindBy(id = "first_name_span")
	private WebElement lblFirstNameErrorMsg;

	@FindBy(id = "last_name_span")
	private WebElement lblLastNameErrorMsg;

	@FindBy(id = "address_span")
	private WebElement lblAddressErrorMsg;

	@FindBy(id = "cc_num_span")
	private WebElement lblCcNumErrorMsg;

	@FindBy(id = "cc_type_span")
	private WebElement lblCcTypeErrorMsg;

	@FindBy(id = "cc_expiry_span")
	private WebElement lblCcExpiryErrorMsg;

	@FindBy(id = "cc_cvv_span")
	private WebElement lblCcvErrorMsg;

	public WebElement getLblBookAHotel() {
		return lblBookAHotel;
	}

	public WebElement getLblFirstNameErrorMsg() {
		return lblFirstNameErrorMsg;
	}

	public WebElement getLblLastNameErrorMsg() {
		return lblLastNameErrorMsg;
	}

	public WebElement getLblAddressErrorMsg() {
		return lblAddressErrorMsg;
	}

	public WebElement getLblCcNumErrorMsg() {
		return lblCcNumErrorMsg;
	}

	public WebElement getLblCcTypeErrorMsg() {
		return lblCcTypeErrorMsg;
	}

	public WebElement getLblCcExpiryErrorMsg() {
		return lblCcExpiryErrorMsg;
	}

	public WebElement getLblCcvErrorMsg() {
		return lblCcvErrorMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getdDnCcType() {
		return dDnCcType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	// 1. Verifying Adactin Book Hotel Page
	public void bookHotel(String firstName, String lastName, String address, String ccType, String ccNum,
			String ccExpMonth, String ccExpYear, String ccv) {

		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtLastName(), lastName);
		elementSendKeys(getTxtAddress(), address);

		selectOptionByText(getdDnCcType(), ccType);
		elementSendKeys(getTxtCreditCardNo(), ccNum);
		selectOptionByText(getdDnExpMonth(), ccExpMonth);
		selectOptionByText(getdDnExpYear(), ccExpYear);
		elementSendKeys(getTxtCvv(), ccv);
		elementClick(getBtnBook());
	}

	// 2. Verifying Adactin Book Hotel Page Without Enter Any Fields
	public void bookHotel() {
		elementClick(getBtnBook());

	}

}
