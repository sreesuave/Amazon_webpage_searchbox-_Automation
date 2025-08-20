# Amazon_webpage_searchbox-_Automation
# Amazon Search Box Automation

![Java](https://img.shields.io/badge/Java-8+-blue) ![Selenium](https://img.shields.io/badge/Selenium-4.13.0-green) ![TestNG](https://img.shields.io/badge/TestNG-7.11.0-orange) ![Maven](https://img.shields.io/badge/Maven-4+-red)

## Overview
This project automates the **search functionality on Amazon's webpage** using **Selenium WebDriver**, **Java**, and **TestNG**. It demonstrates a simple automation framework with a **Page Object Model (POM)** structure for maintainable and readable code.

---

## Features
- Automates product searches on Amazon.
- Validates search results for correctness.
- Implements Page Object Model (POM) design pattern.
- Uses TestNG framework for test management and reporting.
- Captures screenshots on test failures.

---

## Project Structure
AmazonAutomation/
│
├─ src/
│ ├─ main/
│ │ └─ java/
│ │ ├─ pageObjects/ # POM classes for Amazon pages (LoginPage, HomePage, SearchPage)
│ │ └─ utils/ # Utilities (WebDriver setup, screenshot, reports)
│ └─ test/
│ └─ java/
│ └─ tests/ # TestNG test classes
│ └─ resources/
│ └─ config.properties # Configuration file (browser, URL, etc.)
│
├─ screenshots/ # Captured screenshots of failed tests
├─ pom.xml # Maven dependencies
└─ README.md # Project documentation

---

## Prerequisites
- Java JDK 8 or higher
- Maven 4+ installed
- Chrome or Firefox browser
- IDE (Eclipse, IntelliJ IDEA, or VS Code)

---

## Maven Dependencies
Key dependencies in `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.13.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.11.0</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.3</version>
    </dependency>
</dependencies>

---



