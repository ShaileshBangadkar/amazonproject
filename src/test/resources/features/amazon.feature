Feature: amazon

#  Background: user navigated to amazon page

    Scenario: Searching for a product
      When I search product "Suitcase"
      And I click on search button
      Then I verify that right products are Displayed on webpage


  Scenario: Filtering the search results (Price range)
    When I search product "Shoes"
    And I click on search button
    When I entered min price "500"
    And I entered max price "1000"
    Then click on go
    Then I verify that product price is as per filtered price


    Scenario: Adding a product to the shopping cart
      When I search product "Shoes"
      And I click on search button
      When I entered min price "500"
      And I entered max price "1000"
      Then click on go
      When I click on price of the product
      And I select product size " 8 UK "
      Then I added product to shopping cart


  Scenario: Proceeding to checkout
    When I search product "Shoes"
    And I click on search button
    When I entered min price "500"
    And I entered max price "1000"
    Then click on go
    When I click on price of the product
    And I select product size " 8 UK "
    Then I added product to shopping cart
   Then I click on go to cart button to proceed for checkout
    Then I verified that the correct product and options are displayed


  Scenario: Select address and Proceeding to order summary
    When I search product "Shoes"
    And I click on search button
    When I entered min price "500"
    And I entered max price "1000"
    Then click on go
    When I click on price of the product
    And I select product size " 8 UK "
    Then I added product to shopping cart
    Then I click on go to cart button to proceed for checkout
    When I click on Proceed to buy
    And I enter mobile no "7219563294"
    Then I click on continue button
    And I enter password "SHAILESH"
    Then I click on sign in button
    Then I select address
    Then I verify Order Summary



