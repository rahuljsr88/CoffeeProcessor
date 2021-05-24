
Coffee Processor Application

#### API know how
This application loads the values from the JSON files placed under the /resources/json path during
application startup , into an in memory H2 Database.
Moreover, this path for the JSON files can be changed using the application.yml key path.json.

This application Web Service is deployed on local using embedded tomcat in spring boot.

How to build:
1) Checkout the code from git repository
2) Import as a maven project in IDE using pom.xml of the application
3) Do a maven build with goal "clean install"

How to run:
Option 1) Open the CoffeeProcessorApplication class and Right click on it and select option
"RunCoffeeProcessorApplication", the application would be started
OR
Option 2)Follow the below steps:
1) Right click on project and go to run as-> run configuration
2) Under maven build,create a run configuration with goal "spring-boot:run"
3) Application will be started

To get the payment summary/statement from postman:
1) Select method as GET
2) Request url: http://localhost:8080/coffee/paymentsummary

To get the payment summary/statement from browser:
1) Open any Browser and enter this URL in address bar "http://localhost:8080/coffee/paymentsummary"

To get the payment summary/statement from CURL:
1) curl --request GET http://localhost:8080/coffee/paymentsummary

Sample Response JSON:
[
    {
        "name": "coach",
        "amountPaid": 69.0,
        "amountOwed": 4.0
    },
    {
        "name": "ellis",
        "amountPaid": 24.0,
        "amountOwed": 41.75
    },
    {
        "name": "rochelle",
        "amountPaid": 95.0,
        "amountOwed": -42.75
    },
    {
        "name": "zoey",
        "amountPaid": 101.0,
        "amountOwed": -56.0
    },
    {
        "name": "nick",
        "amountPaid": 143.0,
        "amountOwed": -106.5
    },
    {
        "name": "bill",
        "amountPaid": 77.0,
        "amountOwed": -29.25
    },
    {
        "name": "francis",
        "amountPaid": 112.0,
        "amountOwed": -66.5
    },
    {
        "name": "louis",
        "amountPaid": 12.0,
        "amountOwed": 37.5
    }
]

Improvements:
1:) Additional filter request parameter can be added to the endpoint, to filter results by user.
2:) @Cacheable can be used to cache the results from DB , to make application faster.
3:) More test coverage can be done.

Note: This application uses LOMBOK annotations so please enable option for Lombok annotations in the IDE if required.