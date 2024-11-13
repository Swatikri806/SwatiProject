Feature: Selecting multiple filters to view hotel list 

Background: Validate user is able to scroll and click to list of places 

Given Browser is launched and navigate to the URL
When User is able to click on Hotels link
And Navigate to the Hotels page
Then Scroll down to the list of places
And Click on the specific location for hotels
And Verify after navigating to the page

Scenario: Validate user is able to select multiple filters
Then Enter city and select checkin, checkout and room and guests textfield
When User clicks on multiple filters
Then Verify all the filters are applied to the page	

Scenario: User is able to enter the budget in the filter section
When User is able to scroll down to your budget option in filters section
Then Enter max and min value in budget textfield
And Click on arrow button
Then Verify all the filters are applied to the page
