# Selenium Cucumber Test Automation Framework

This is a test automation framework built with Selenium WebDriver, Cucumber, and TestNG in Java.

## Prerequisites

- Java JDK 11 or higher
- Maven
- Chrome/Firefox/Edge browser

## Project Structure

```
selenium-cucumber-framework/
├── src/
│   ├── main/java/com/automation/
│   │   ├── config/
│   │   │   └── WebDriverConfig.java
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   ├── GooglePage.java
│   │   │   ├── GoogleImagesPage.java
│   │   │   └── GoogleAdvancedSearchPage.java
│   │   └── utils/
│   │       └── HighlightElement.java
│   └── test/
│       ├── java/com/automation/
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions/
│       │       ├── Hooks.java
│       │       ├── GoogleSearchSteps.java
│       │       ├── GoogleImagesSteps.java
│       │       └── GoogleAdvancedSearchSteps.java
│       └── resources/
│           └── features/
│               ├── sample.feature
│               ├── google_image_search.feature
│               └── google_advanced_search.feature
└── pom.xml
```

## Features

- Page Object Model design pattern
- Cucumber BDD framework
- Parallel test execution support
- Screenshot capture on test failure
- Cross-browser testing support
- HTML and JSON test reports
- Element highlighting for visibility during test execution
- Tag-based test filtering (run tests by feature tags)
- Multiple demo features for search, image, and advanced search

## Running Tests

To run all tests (default):
```bash
mvn test
```

To run tests by feature tag (tags are only at feature level):
```bash
mvn test -Dcucumber.filter.tags="@search"
```
```bash
mvn test -Dcucumber.filter.tags="@image"
```
```bash
mvn test -Dcucumber.filter.tags="@advanced"
```
To run multiple features:
```bash
mvn test -Dcucumber.filter.tags="@search or @image"
```

## Reports

After test execution, you can find the reports in:
- `target/cucumber-reports/cucumber-pretty.html`
- `target/cucumber-reports/CucumberTestReport.json`

## Notes
- Tags are only used at the feature level for easier test suite management.
- All elements interacted with during tests are highlighted for better visibility.
- You can add more feature files and step definitions as needed for your application.

## Using this Project on Another Machine

To use this automation framework on a different machine, follow these steps:

1. **Clone or copy the project**
   - Use `git clone <repo-url>` if using version control, or copy the project folder manually.

2. **Install Java JDK (11 or higher)**
   - Make sure Java is installed and `java -version` works in your terminal.

3. **Install Maven**
   - On macOS: `brew install maven`
   - On Windows: Download from https://maven.apache.org/download.cgi and add to PATH
   - On Linux: Use your package manager (e.g., `sudo apt install maven`)

4. **(Optional) Install a supported browser**
   - Chrome, Firefox, or Edge should be installed and up to date.

5. **Install project dependencies**
   - In the project directory, run:
     ```bash
     mvn clean compile
     ```
   - This will download all required dependencies.

6. **Run the tests**
   - By default, running:
     ```bash
     mvn test
     ```
     will execute all tests in the project (if no tag filtering is set in the runner).
   - To run tests by tag, use:
     ```bash
     mvn test -Dcucumber.filter.tags="@search"
     ```
     or any other tag as described above.

**Note:**
- If you get a warning about 0 tests being executed and see a message like:
  > The test method 'io.cucumber.testng.AbstractTestNGCucumberTests.runScenario' will be skipped since its data provider 'scenarios' returned an empty array or iterator.

  This means the `tags` property in your `TestRunner.java` is set to a tag that does not exist in your feature files (e.g., `@regression`).

  **How to fix:**
  - Edit your `TestRunner.java` and remove the `tags` property or set it to an empty value:
    ```java
    // Remove or set to empty:
    // tags = "${cucumber.filter.tags:}",
    ```
  - This will ensure that all features run by default when you use `mvn test`.

No additional configuration is needed. WebDriver binaries are managed automatically by WebDriverManager.
