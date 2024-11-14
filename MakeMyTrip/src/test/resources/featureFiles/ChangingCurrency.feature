Feature: Changing Currency

Scenario: User is able to change the currency 
  
Given Browser is launched and navigate to the URL
When User is able to click on Hotels link 
And Navigate to the Hotels page
Then Click on Currency button and select one currency
And Verify currency is changed to selected one
Then user is able to select city or location 
And user is able to choose checkin and checkout dates 
And select Room and guests then click on apply button
Then Click on Search button
And Verify user is navigated to hotels list page 
Then Click on sort by price from navbar
Then Click and Enter area in the search bar
And Verify hotel list is displayed in the same locality 
