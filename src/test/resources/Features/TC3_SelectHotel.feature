@SelectHotel
Feature: Verifying Adactin Select Hotel Page

  @SelectHotelWithHotelName
  Scenario Outline: Verifying Adactin Select Hotel Page With Hotel Name
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present
    When User should perform select hotel name
    Then User should verify after select hotel navigates to book hotel page and verify "Book A Hotel" is present

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | hotelName    |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 1 - One       | 0 - None        | Hotel Hervey |

  @SelectHotelWithOutHotelName
  Scenario Outline: Verifying Adactin Select Hotel Page Without Hotel Name
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"
    When User should perform search hotel "<location>","<hotels>","<roomType>","<roomNos>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel navigates to select hotel page and verify "Select Hotel" is present
    When User should click continue button without select hotel name
    Then User should verify error message "Please Select a Hotel"

    Examples: 
      | username | password | location | hotels       | roomType     | roomNos | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Kamal001 | Pass@123 | Adelaide | Hotel Hervey | Super Deluxe | 1 - One | 23/08/2022  | 25/08/2022   | 1 - One       | 0 - None        |
