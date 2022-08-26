@BookHotel
Feature: Verifying Adactin Book Hotel Page
	@BookHotelWithAllField
  Scenario Outline: Verifying Adactin Book Hotel Page
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

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 1 - One       | 0 - None        | Kamal     | Raj      | chennai        |

@BookHotelWithField
  Scenario Outline: Verifying Adactin Book Hotel Page Without Enter Any Fields
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present
    When User should perform select hotel name
    Then User should verify after select hotel navigates to book hotel page and verify "Book A Hotel" is present
    When User should click book now without enter any fields
    Then User should verify error messages after book now "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 1 - One       | 0 - None        |
