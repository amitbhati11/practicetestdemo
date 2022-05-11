#Cucumber features
Feature: 

  @smoke
  Scenario Outline: Test login functionality with valid Credentials
    Given Enter the URl
    And login with valid <username> and <password>
    When click on login btn
    Then navigate to home page

    Examples: 
      | username | password |
      | amit     |    12345 |

  @sanity
  Scenario Outline: Test login functionality with invalid Credentials
    Given Enter the URl
    And login with invalid <username> and <password>
    When click on login btn
    Then navigate to home page

    Examples: 
      | username | password |
      | sumit    |   123456 |

  @Regression
  Scenario Outline: Test login functionality with valid Credentials
    Given Enter the URl
    And login with valid <username> and <password>
    When click on login btn
    Then navigate to home page

    Examples: 
      | username | password |
      | pabitra  |    12345 |

  @smoke @sanity
  Scenario Outline: Test login functionality with invalid Credentials
    Given Enter the URl
    And login with invalid <username> and <password>
    When click on login btn
    Then navigate to home page

    Examples: 
      | username | password |
      | bhushan  |   123456 |

  Scenario Outline: Test login functionality with valid Credentials
    Given Enter the URl
    And login with valid <username> and <password>
    When click on login btn
    Then navigate to home page

    Examples: 
      | username | password |
      | rakesh   |    12345 |
