# demo-test-framework
This a Selenium-TestNg-Java-Gradle demo project that can be used as a boiler plate

# Demo Test Framework Setup Guide

This guide explains how to set up the directory structure for the Demo Test Framework project using Gradle.

## Prerequisites

- Java JDK installed
- Gradle installed
- Git (optional)

## Project Initialization

### Windows Commands
```batch
# Initialize Gradle project
gradle init --type basic --dsl groovy --project-name DemoTestNGWithGradle

# Create main directory structure
mkdir src\test\java\com\codescratcher\demo
mkdir src\test\resources

# Create sub-directories
mkdir src\test\java\com\codescratcher\demo\base
mkdir src\test\java\com\codescratcher\demo\test
mkdir src\test\java\com\codescratcher\demo\utilities
```

### Linux/MacOS Commands
```bash
# Initialize Gradle project
gradle init --type basic --dsl groovy --project-name DemoTestNGWithGradle

# Create main directory structure
mkdir -p src/test/java/com/codescratcher/demo
mkdir -p src/test/resources

# Create sub-directories
mkdir -p src/test/java/com/codescratcher/demo/base
mkdir -p src/test/java/com/codescratcher/demo/test
mkdir -p src/test/java/com/codescratcher/demo/utilities
```

## Project Structure

After executing these commands, you should have the following directory structure:

```
demo-test-framework/
├── gradle/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── codescratcher/
│       │           └── demo/
│       │               ├── base/
│       │               ├── test/
│       │               └── utilities/
│       └── resources/
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
```

## Directory Purpose

- `base/`: Contains base test classes and configurations
- `test/`: Contains actual test cases
- `utilities/`: Contains helper classes and utility functions
- `resources/`: Contains test configuration files, test data, etc.
```
