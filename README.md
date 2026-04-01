# 🛒 Ecommerce UI Automation Framework

A high-performance, scalable, and fully containerized UI test automation framework built with **Java, Selenium, TestNG, and Gradle**. This project is designed to simulate real-world automation practices used in modern, high-concurrency QA environments.

---

## 🚀 Key Features

- **Selenium 4 Grid Architecture** — Fully containerized Hub-and-Node architecture using Docker Compose, allowing tests to run in isolated Linux environments without local browser dependencies.
- **True Cross-Browser Parallelism** — Configured to execute test suites on Chrome and Firefox simultaneously, dramatically reducing execution time.
- **Thread-Safe Driver Management** — Leverages Java's `ThreadLocal<WebDriver>` to prevent data leaks and driver collisions during high-concurrency parallel runs.
- **Smart Flaky-Test Management** — Custom `RetryAnalyzer` automatically catches transient failures, captures screenshots, and retries tests to ensure stable builds.
- **Dynamic Suite & Environment Execution** — Allows developers to choose execution mode (`local` vs `grid`) and specific TestNG suites via terminal arguments without altering any code.
- **Rich Interactive Reporting** — Native integration with **Allure Reports** featuring step-by-step breakdowns, screenshot attachments on failures, and historical execution trends.

---

## 🧱 Architecture & Design

The framework follows a layered design to ensure maintainability and readability.

```
Tests  →  Flows  →  Page Objects  →  Driver / Utils
```

| Layer | Location | Responsibility |
|---|---|---|
| **Tests** | `/tests` | Assertions only. Represent business scenarios, no direct WebDriver interaction. |
| **Flows** | `/flows` | Encapsulate user workflows (e.g. login, checkout) by coordinating multiple page objects. |
| **Page Objects** | `/pages` | Contain locators and UI actions only. No assertions or test logic. |
| **Utilities** | `/utils` | Explicit waits (`WaitUtils`), screenshot utilities, and reusable helpers. |
| **Driver Layer** | `/driver` | Centralised driver creation via `DriverFactory` with thread-safe lifecycle management. |

---

## 🛠️ Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Automation Tool | Selenium WebDriver 4 |
| Test Runner | TestNG |
| Build Tool | Gradle |
| Containerisation | Docker & Docker Compose |
| Reporting | Allure |
| Logging | SLF4J + Logback |
| CI/CD | GitHub Actions |

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
    └── java
        ├── base
        ├── tests
        ├── listeners
        └── dataproviders
```

---

## 🚦 How to Run

The framework accepts dynamic command-line arguments to control where and how tests run.

### Command-Line Arguments

| Argument | Options | Default |
|---|---|---|
| `-DexecutionMode` | `local`, `grid` | `local` |
| `-Dsuite` | See suite options below | `testng.xml` |

**Available Suites:**

| Suite File | Description |
|---|---|
| `testng.xml` | Default sequential run |
| `testngparallel.xml` | Runs test classes in parallel |
| `testngparallelbrowser.xml` | Cross-browser parallel execution |

---

### 1. Running Locally

```bash
# Sequential tests (default)
./gradlew clean test

# Parallel tests locally
./gradlew clean test -Dsuite=testngparallel.xml
```

---

### 2. Running on Docker Selenium Grid

**Step 1 — Spin up the Grid:**

```bash
docker compose up -d
```

> Verify the hub and nodes are running at [http://localhost:4444/ui](http://localhost:4444/ui)

**Step 2 — Execute tests against the Grid:**

```bash
# Cross-browser parallel tests on Grid
./gradlew clean test -Dsuite=testngparallelbrowser.xml -DexecutionMode=grid
```

---

## 📊 Generating Test Reports

This project uses Allure for visual reporting. After any test run, generate and serve the report with:

```bash
allure serve build/allure-results
```

Your browser will open a local web server with the full graphical suite analysis, including screenshots of any failed steps.

---

## 👨‍💻 Author

**Krishna Dass**
