Feature: Review Booking Hotel from map

Scenario: Validate user is able to locate hotel from map and book hotel 

Given Browser is launched and navigate to the URL
When User is able to click on Hotels link
And Navigate to the Hotels page
Then user is able to select city or location 
And user is able to choose checkin and checkout dates 
And select Room and guests then click on apply button
Then Click on Search button
And Verify user is navigated to hotels list page 
When Click on explore on map
Then click on View main areas
And select one option for the areas
Then click on view list and navigate to the list of hotels
Then select hotel name to view details of the hotel 
And Click on BOOK THIS NOW button 
When User is navigated to Review your Booking 


