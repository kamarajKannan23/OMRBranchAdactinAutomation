package com.pages;

public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookingConfirmPage;
	private CancelBookingPage cancelBookingPage;
	
	
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage = new LoginPage() : loginPage ;
	}
	public SearchHotelPage getSearchHotelPage() {
 		return (searchHotelPage==null)? searchHotelPage = new SearchHotelPage() :searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)? selectHotelPage = new SelectHotelPage() :selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)? bookHotelPage = new BookHotelPage() :bookHotelPage;
	}
	public BookingConfirmPage getBookingConfirmPage() throws InterruptedException {
		return (bookingConfirmPage==null)? bookingConfirmPage = new BookingConfirmPage() :bookingConfirmPage;
	}
	public CancelBookingPage getCancelBookingPagePage() {
		return (cancelBookingPage==null)? cancelBookingPage = new CancelBookingPage() :cancelBookingPage;
	}

}
