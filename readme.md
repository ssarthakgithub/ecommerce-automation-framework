E-Commerce Automation Framework
A Selenium TestNG based E-Commerce Automation Framework built using Java, Maven, and Page Object Model (POM).

🛠️ Technologies Used
Java
Selenium WebDriver
TestNG
Maven
Page Object Model (POM)
Extent Reports
Git & GitHub
📂 Project Structure
src ├── main │ └── java │ ├── pages │ │ ├── LoginPage.java │ │ ├── ProductsPage.java │ │ ├── CartPage.java │ │ └── CheckoutPage.java │ └── utils │ ├── ConfigReader.java │ └── ScreenshotUtility.java │ ├── test │ └── java │ ├── LoginTest.java │ ├── ProductTest.java │ ├── CartTest.java │ ├── CheckoutTest.java │ ├── EcommerceTest.java │ ├── base │ │ ├── BaseTest.java │ │ └── ExtentReportManager.java │ └── listeners │ └── TestListener.java

🧪 Test Scenarios
Login validation
Product validation
Add product to cart
Cart validation
Checkout process
Complete purchase flow
📊 Reporting
The framework generates an Extent HTML report after test execution.

The report contains:

Test execution status
Passed/Failed test cases
Execution time
Test details
Screenshots for failed tests
📸 Screenshots
Screenshots are automatically captured when a test fails.

▶️ How to Run
Clone the repository.
Import the project as a Maven project in Eclipse/IntelliJ.
Update Maven dependencies.
Run testng.xml as a TestNG Suite.
👨‍💻 Author
Sarthak Saxena
