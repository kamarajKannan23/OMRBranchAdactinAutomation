@CancelBooking
Feature: Verifying Adactin Cancel Booking Hotel Page
@BookingAndCancel
  Scenario Outline: Verifying Adactin Booking Hotel And Cancel Hotel
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present
    When User should perform select hotel name
    Then User should verify after select hotel navigates to book hotel page and verify "Book A Hotel" is present
    When User should perform book hotel "<firstName>","<lastName>" and "<billingAddress>"
      | cardType         | cardNo           | expMonth | expYear | cvv |
      | VISA             | 4234423434633453 | November |    2022 | 466 |
      | MASTER           | 5134646634633483 | June     |    2022 | 789 |
      | American Express | 3442345146466750 | August   |    2022 | 648 |
    Then User should verify after book hotel "Booking Confirmation" is present
    When User should perform search orderId and cancel orderId
    Then User should verify after cancel orderId "The booking has been cancelled."

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 1 - One       | 0 - None        | Kamal     | Raj      | chennai        |
@CancelBookingOnly
  Scenario Outline: Verifying Adactin Search Existing OrderId and Cancel Hotel
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search orderId and cancel orderId "<orderId>"
    Then User should verify after cancel orderId "The booking has been cancelled."

    Examples: 
      | username | password | orderId    |
      | Kamal001 | Pass@123 | 95F79E794K |
