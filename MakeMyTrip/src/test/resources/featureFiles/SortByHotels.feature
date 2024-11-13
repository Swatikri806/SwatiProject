Feature: Hotels
Scenario: Validate user is able to select Hotels from Hotels page by filtering rating

Given Browser is launched and navigate to the URL
When User is able to click on Hotels link
And Navigate to the Hotels page
Then Click on Search button
And Click on User Rating 
Then Scroll down and click on highest ratings hotel
And Click on BOOK THIS NOW button
When User is navigated to Review your Booking
Then Close the browser
