Feature: To validate login functionality in orangehrm app

@regression
Scenario Outline: To validate login using different combinations of inputs 

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text '<username>' in texbox using xpath "//input[@name='username']"
And user enters text '<password>' in texbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates title to be '<expTitle>'

Examples: 
| username | password |  expTitle |
| reyaz0806 | reyaz123 | Adactin.com - Search Hotel |
| reyaz0806 | reyaz456 | Adactin.com - Hotel Reservation System |
| reyaz1212 | reyaz123 | Adactin.com - Hotel Reservation System |
| reyaz1212 | reyaz456 | Adactin.com - Hotel Reservation System |
