Feature: Placeorderr
Scenario: Placing the order successfully

Given the user is on the loginpage
When the user enter username as "<Username>" and password as "<Password>" and click login button
And the user selects the product
And the user clicks on Add to cart button
And the user clicks on Cart icon
And the user clicks on Checkout button
And the user enters customer information and click continue button
And the user verifies the product and click Finish button
And the user clicks the logout button
Then the user validates the login button int the login page

Examples:
|Username|Password|
|standard_user|secret_sauce|


