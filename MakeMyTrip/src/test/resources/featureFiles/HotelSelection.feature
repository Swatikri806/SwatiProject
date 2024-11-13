Feature: Selecting hotels for booking

Background:

Given Browser is launched and navigate to the URL
When User is able to click on Hotels link
And Navigate to the Hotels page
Then user is able to select city or location 
And user is able to choose checkin and checkout dates 
And select Room and guests then click on apply button
Then Click on Search button
And Verify user is navigated to hotels list page 

Scenario: user should be able to select price checkbox from filter option 

When Scroll down to Price per night in filter option
And Select price checkbox and navigate to hotel list 
Then user should be able to click on hotel to view the hotel details 

Scenario: User Should be able to view map 

When Click on explore on map
Then click on View main areas

