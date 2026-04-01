# 🛒 Ecommerce UI Automation Framework

A high-performance, scalable, and fully containerized UI test automation framework built with **Java, Selenium, TestNG, and Gradle**. This project is designed to simulate real-world automation practices used in modern, high-concurrency QA environments.

---

## 🚀 Key Features

* **Selenium 4 Grid Architecture:** Fully containerized Hub-and-Node architecture using Docker Compose, allowing tests to run in isolated Linux environments without local browser dependencies.
* **True Cross-Browser Parallelism:** Configured to execute test suites on Chrome and Firefox simultaneously, dramatically reducing execution time.
* **Thread-Safe Driver Management:** Leverages Java's `ThreadLocal<WebDriver>` for instances to prevent data leaks and collisions during high-concurrency parallel runs.
* **Smart Flaky-Test Management:** Custom `RetryAnalyzer` automatically catches transient failures, captures screenshots, and retries the test to ensure stable builds.
* **Dynamic Suite & Environment Execution:** Allows developers to choose execution mode (Local vs. Grid) and specific TestNG suites directly via terminal arguments without altering code.
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
🔹 Layers Explained
Tests (/tests): Contain assertions only. They represent business scenarios and do not interact with the WebDriver directly.

Flows (/flows): Encapsulate user workflows (e.g., login, checkout) and coordinate multiple page objects to improve readability and reusability.

Page Objects (/pages): Represent UI pages. They contain locators and actions only, strictly avoiding assertions or test logic.

Utilities (/utils): Handles explicit waits (WaitUtils), screenshot utilities, and common reusable helpers to avoid implicit waits or hardcoded thread sleeps.

Driver Layer (/driver): Centralized driver creation via DriverFactory managing the thread-safe life cycle.

🛠️ Tech Stack
Component	Technology Used
Language	Java 17
Automation Tool	Selenium WebDriver 4
Test Runner	TestNG
Build Tool	Gradle
Containerization	Docker & Docker Compose
Reporting	Allure
Logging	SLF4J + Logback
CI/CD	GitHub Actions
📂 Project Structure
Plaintext
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
🚦 How to Run the Project
The framework accepts dynamic command-line arguments to dictate where and how tests are run.

⚙️ Command-Line Arguments
-DexecutionMode: Options are local (default) or grid.

-Dsuite: Points to the specific TestNG XML file in your root folder. Options include:

testng.xml (Default sequential run)

testngparallel.xml (Runs classes in parallel)

testngparallelbrowser.xml (Cross-browser parallel execution)

1. Running Locally (Sequential or Parallel)
To run tests on your local setup (will fire up the default browser setup in config.properties):

Bash
# To run sequential tests locally
./gradlew clean test

# To run parallel tests locally
./gradlew clean test -Dsuite=testngparallel.xml
2. Running on Docker Selenium Grid (Remote)
To run tests at scale across isolated network containers:

Step A: Spin up the Grid

Bash
docker compose up -d
💡 You can verify the hub and nodes are running by visiting http://localhost:4444/ui/

Step B: Execute against the Grid

Bash
# Run cross-browser parallel tests on the Grid
./gradlew clean test -Dsuite=testngparallelbrowser.xml -DexecutionMode=grid
📊 Generating Test Reports
This project uses Allure for highly visual reporting. To view your reports locally after a test run:

Generate and serve the report:

Bash
allure serve build/allure-results
Your default browser will open a local web server hosting the complete graphical suite analysis, complete with screenshots of any failed steps.

👨‍💻 Author
Krishna Dass