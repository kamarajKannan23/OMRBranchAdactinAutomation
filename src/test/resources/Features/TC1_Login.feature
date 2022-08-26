@LoginPage
Feature: Verifying Adactin Hotel login details

  Scenario Outline: Verifying Adactin Login With Valid Credentials
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Kamal001!"

    Examples: 
      | username | password |
      | Kamal001 | Pass@123 |

  Scenario Outline: Verifying Adactin Login With Valid Credentials With Enter
    Given User is on the adactin Page
    When User should perform login "<username>","<password>" with Enter Key
    Then User should verify after login "Hello Kamal001!"

    Examples: 
      | username | password |
      | Kamal001 | Pass@123 |
	@loginError
  Scenario Outline: Verifying Adactin Login With Invalid Credentials
    Given User is on the adactin Page
    When User should perform login "<username>","<password>"
    Then User should verify Invalid login error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | username | password |
      | Kamal001 | Pass     |
