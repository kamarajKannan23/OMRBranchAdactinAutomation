@SearchHotel
Feature: Verifying Adactin Search Hotel Page
  
  @SearchHotelAllFields
  Scenario Outline: Verifying Adactin Search Hotel Page With All Fields
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 2 - Two       | 1 - One         |

  @SearchHotelManditary
  Scenario Outline: Verifying Adactin Search Hotel Page With Only Manditary Fields
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel with only mandatory fields "<location>","<roomNos>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present

    Examples: 
      | username | password | location | roomNos | checkInDate | checkOutDate | adultsPerRoom |
      | Kamal001 | Pass@123 | Sydney   | 1 - One | 22/08/2022  | 23/08/2022   | 2 - Two       |
	
	@SearchHotelWrongDate
  Scenario Outline: Verifying Adactin Search Hotel Page With Error Messages In Date Field
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify an error messages in date fields after search hotel "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 20/08/2022   | 1 - One       | 0 - None        |

	@SearchHotelWithOutFields
  Scenario Outline: Verifying Adactin Search Hotel Page With Error Message In Location Field When Without Entering Any Fields
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should click search button without entering any fields
    Then User should verify an error message in location field after search hotel "Please Select a Location"

    Examples: 
      | username | password |
      | Kamal001 | Pass@123 |
