Feature: To validate login functionality in orangehrm app

@regression
Scenario: To validate login using valid credentials 

Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text "Admin" in texbox using xpath "//input[@name='username']"
And user enters text "admin123" in texbox using xpath "//input[@name='password']"
And user clicks button using xpath "//button[@type='submit']"
Then user validates the profile picture using "//span/img[@alt='profile picture' and contains(@src,'viewPhoto/empNumber')]"