# E-Commerce Automation Framework

A Selenium TestNG-based E-Commerce Automation Framework built using **Java, Selenium WebDriver, Maven, and the Page Object Model (POM)**.

## 🛠️ Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* Git & GitHub

## 📁 Project Structure

```text
ecommerce-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── LoginPage.java
│   │       │   ├── ProductsPage.java
│   │       │   ├── CartPage.java
│   │       │   └── CheckoutPage.java
│   │       └── utils/
│   │           ├── ConfigReader.java
│   │           └── ScreenshotUtility.java
│   └── test/
│       └── java/
│           ├── LoginTest.java
│           ├── ProductTest.java
│           ├── CartTest.java
│           ├── CheckoutTest.java
│           ├── EcommerceTest.java
│           ├── BaseTest.java
│           ├── ExtentReportManager.java
│           └── listeners/
│               └── TestListener.java
├── testng.xml
└── pom.xml
```

## 🧪 Test Scenarios

* Login validation
* Product validation
* Add product to cart
* Cart validation
* Checkout process
* Complete purchase flow

## 📊 Test Reporting

The framework generates an Extent HTML report after test execution.

The report includes:

* Test execution status (Passed/Failed)
* Test execution time
* Test details
* Screenshots for failed tests

## 📸 Screenshots

Screenshots are automatically captured when a test fails.

## ▶️ How to Run

1. Clone or download this repository.
2. Import the project into Eclipse as an **Existing Maven Project**.
3. Update Maven dependencies.
4. Verify the browser and test configuration.
5. Run `testng.xml` as a **TestNG Suite**.

## 👨‍💻 Author

**Sarthak Saxena**

GitHub: [ssarthakgithub](https://github.com/ssarthakgithub)
