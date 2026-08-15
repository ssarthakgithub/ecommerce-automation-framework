# E-Commerce Automation Framework

## Project Overview

This project is an automated testing framework for the SauceDemo e-commerce application.

The framework automates the complete shopping flow:

Login → Product → Cart → Checkout → Order Confirmation

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Eclipse
- Git & GitHub

## Framework Structure

src/main/java
├── pages
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
│
└── utils
    ├── ConfigReader.java
    └── ScreenshotUtility.java

src/test/java
├── LoginTest.java
├── ProductTest.java
├── CartTest.java
├── CheckoutTest.java
└── EcommerceTest.java

base
└── BaseTest.java

listeners
└── TestListener.java

testng.xml
pom.xml

## Test Scenarios

### 1. Login Test
- Open SauceDemo
- Enter valid username
- Enter valid password
- Verify Products page

### 2. Product Test
- Login
- Select product
- Add product to cart

### 3. Cart Test
- Open cart
- Verify product
- Proceed to checkout

### 4. Checkout Test
- Enter customer information
- Continue
- Finish order
- Verify order confirmation

### 5. End-to-End Test
Complete flow:

Login
→ Product
→ Cart
→ Checkout
→ Order Confirmation

## Test Execution

Tests can be executed using TestNG.

The complete test suite is configured in:

testng.xml

## Test Result

Current TestNG suite result:

- Total Tests: 5
- Passed: 5
- Failed: 0
- Skipped: 0

## Additional Features

- Page Object Model
- Explicit waits
- TestNG assertions
- TestNG listener
- Automatic screenshot capture on test failure
- Maven dependency management