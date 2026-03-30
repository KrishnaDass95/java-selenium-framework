# Ecommerce UI Automation Framework (Java + Selenium)

## 📌 Overview

This project is a **scalable UI automation framework** built using **Java, Selenium, TestNG, and Gradle**, designed to simulate real-world automation practices used in modern QA teams.

The framework demonstrates:

* Clean architecture (Page Object + Flow Layer)
* Thread-safe WebDriver management
* Test grouping and execution control
* Logging, retry mechanism, and failure diagnostics

---

## 🧱 Architecture

The framework follows a layered design:

```
Tests
  ↓
Flows (Business Logic)
  ↓
Page Objects (UI Interaction)
  ↓
Driver / Utils (Selenium handling)
```

### 🔹 Layers Explained

#### 1. Tests (`/tests`)

* Contain assertions only
* Represent business scenarios
* Do not interact with WebDriver directly

#### 2. Flows (`/flows`)

* Encapsulate user workflows (e.g., login, checkout)
* Coordinate multiple page objects
* Improve readability and reusability

#### 3. Page Objects (`/pages`)

* Represent UI pages
* Contain locators and actions only
* No assertions or test logic

#### 4. Utilities (`/utils`)

* Wait handling (explicit waits)
* Screenshot utilities
* Common reusable helpers

#### 5. Driver Layer (`/driver`)

* Thread-safe WebDriver using `ThreadLocal`
* Centralized driver creation via `DriverFactory`

---

## ⚙️ Tech Stack

* Java 17
* Selenium 4
* TestNG
* Gradle
* SLF4J + Logback (logging)
* WebDriverManager
* TestNG Listeners

---

## 🔄 Key Features

### ✅ Thread-Safe Driver Management

* Uses `ThreadLocal<WebDriver>` for parallel execution

### ✅ Explicit Wait Strategy

* Centralized `WaitUtils`
* No implicit waits or thread sleeps

### ✅ Flow Layer Abstraction

* Separates business logic from UI interaction

### ✅ Test Execution Control

* `testng.xml` for suite management

### ✅ Retry Mechanism

* Automatically retries flaky tests (configurable)

### ✅ Logging

* Structured logging using SLF4J + Logback

### ✅ Screenshot on Failure

* Captured automatically via TestNG Listener

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   ├── config
│   │   ├── driver
│   │   ├── flows
│   │   ├── pages
│   │   └── utils
│   └── resources
│       ├── config.properties
│       └── testdata.properties
│
└── test
    ├── java
    │   ├── base
    │   ├── tests
    │   ├── listeners
    │   └── dataproviders
```

---

## 🚀 How to Run Tests

### Run all tests

```bash
./gradlew clean test
```

### Run specific suite

Modify `testng.xml` groups:

```xml
<include name="smoke"/>
```

---

## 🧪 Test Coverage

The framework includes:

* Login validation (positive & negative)
* Product selection and cart validation
* Checkout flow (end-to-end)
* Checkout validation errors
* Data-driven test scenarios

---

## 🧠 Design Decisions

### Why Flow Layer?

To separate business workflows from page-level interactions, improving readability and maintainability.

### Why ThreadLocal WebDriver?

To enable safe parallel execution without shared state issues.

### Why Explicit Waits Only?

To avoid flakiness and ensure precise synchronization.

### Why External Test Data?

To avoid hardcoding and support environment flexibility.

---

## 📈 Future Improvements

* CI/CD integration (GitHub Actions)
* Allure reporting
* Dockerized execution
* Cross-browser execution support
* API + UI combined testing

---

## 👨‍💻 Author

Krishna Dass
