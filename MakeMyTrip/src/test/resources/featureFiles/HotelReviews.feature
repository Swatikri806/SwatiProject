Feature: Reviews

Scenario Outline: Validate user is able to sort by and read hotel reviews in the hotel details page

Given Browser is launched and navigate to the URL 
When User is able to click on Hotels link 
And Navigate to the Hotels page 
Then Click on Search button 
And Click and Enter <locality> in the search bar 
And Select the option from the dropdown and click to search the hotel
Then Scroll down and click on Ratings of the hotel 
And Navigate to details of hotel page and click on user reviews from navbar
Then Click on sort by in User Rating & Reviews and select Positive first from dropdown 
And Scroll down to read the reviews and Click on Helpful icon 

Examples:
|locality|
|0|


