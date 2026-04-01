# 🛒 Ecommerce UI Automation Framework

A high-performance, scalable, and fully containerized UI test automation framework built with **Java, Selenium, TestNG, and Gradle**. This project is designed to simulate real-world automation practices used in modern, high-concurrency QA environments.

---

## 🚀 Key Features

* **Selenium 4 Grid Architecture:** Fully containerized Hub-and-Node architecture using Docker Compose, allowing tests to run in isolated Linux environments without local browser dependencies.
* **True Cross-Browser Parallelism:** Configured to execute test suites on Chrome and Firefox simultaneously, dramatically reducing execution time.
* **Thread-Safe Driver Management:** Leverages Java's `ThreadLocal<WebDriver>` for instances to prevent data leaks and collisions during high-concurrency parallel runs.
* **Smart Flaky-Test Management:** Custom `RetryAnalyzer` automatically catches transient failures, captures screenshots, and retries the test to ensure stable builds.
* **Rich Interactive Reporting:** Native integration with **Allure Reports** featuring step-by-step breakdowns, visual screenshot attachments on failures, and historical execution trends.

---

## 🧱 Architecture & Design Decisions

The framework follows a highly readable, layered design to ensure maintainability:

```text
Tests
  ↓
Flows (Business Logic)
  ↓
Page Objects (UI Interaction)
  ↓
Driver / Utils (Selenium handling)
```

### 🔹 Layers Explained

* **Tests (`/tests`):** Contain assertions only. They represent business scenarios and do not interact with the WebDriver directly.
* **Flows (`/flows`):** Encapsulate user workflows (e.g., login, checkout) and coordinate multiple page objects to improve readability and reusability.
* **Page Objects (`/pages`):** Represent UI pages. They contain locators and actions only, strictly avoiding assertions or test logic.
* **Utilities (`/utils`):** Handles explicit waits (`WaitUtils`), screenshot utilities, and common reusable helpers to avoid implicit waits or hardcoded thread sleeps.
* **Driver Layer (`/driver`):** Centralized driver creation via `DriverFactory` managing the thread-safe life cycle.

---

## 🛠️ Tech Stack

| Component | Technology Used |
| :--- | :--- |
| **Language** | Java 17 |
| **Automation Tool** | Selenium WebDriver 4 |
| **Test Runner** | TestNG |
| **Build Tool** | Gradle |
| **Containerization** | Docker & Docker Compose |
| **Reporting** | Allure |
| **Logging** | SLF4J + Logback |
| **CI/CD** | GitHub Actions |

---

## 📂 Project Structure

```text
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

## 🚦 How to Run the Project

### 1. Running Locally
By default, the framework is configured for local execution. Run the following command in your terminal:
```bash
./gradlew clean test
```

### 2. Running on Docker Selenium Grid
To utilize the distributed network and run tests across browsers simultaneously:

**Step A: Start the Grid**
```bash
docker compose up -d
```
> 💡 *You can verify the grid is live by visiting the dashboard at `http://localhost:4444/ui/`*

**Step B: Execute the Tests**
Pass the `executionMode` system property to override the local properties default:
```bash
./gradlew clean test -DexecutionMode=grid
```

---

## 📊 Generating Test Reports

This project uses Allure for highly visual reporting. To view your reports locally after a test run:

1. Generate and serve the report:
```bash
allure serve build/allure-results
```
2. Your default browser will open a local web server hosting the complete graphical suite analysis, complete with screenshots of any failed steps.

---

## 👨‍💻 Author

Krishna Dass

