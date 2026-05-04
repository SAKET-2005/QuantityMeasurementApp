# Quantity Measurement App

## Project Overview
The **Quantity Measurement App** is a Java-based application designed to compare numerical values measured in feet.  
It demonstrates basic **unit testing using JUnit 5**, along with proper project structuring using `main` and `test` directories.

---

## Use Case 1: Equality Check in Feet

### Description
This use case checks whether two given numerical values (in feet) are equal.

The system:
- Accepts two numeric inputs
- Validates the inputs
- Compares them for equality
- Returns a boolean result (`true` or `false`)

---

## Key Concepts
- Java Methods
- Input Validation
- Equality Comparison
- JUnit Testing (JUnit 5)
- Test-driven development basics

---

## Project Structure
```
QuantityMeasurementApp
├── src
│ ├── main
│ │ └── java
│ │ └── com.quantity
│ │ └── QuantityMeasurementApp.java
│ │
│ └── test
│ └── java
│ └── com.quantity
│ └── QuantityMeasurementAppTest.java
```

---

## Technologies Used
- Java 8+
- JUnit 5.10.0
- IntelliJ IDEA

---

## How to Run the Project

### 1. Run Main Class
You can run the program in two ways:

#### Option A: Using Command Line Arguments

```
5 5
```


#### Option B: Using Scanner Input (if implemented)

Enter values manually when prompted.

---

### 2. Run Test Cases
- Navigate to: `QuantityMeasurementAppTest`
- Right click → Run Tests
- Or use:

```
JUnit Test Runner
```


---

## Test Cases Covered
- Equal values → returns `true`
- Different values → returns `false`
- Zero values → returns `true`
- Negative values → returns `true` if equal

---

## Sample Output

```
=== Quantity Measurement App ===
Version: 1.0

Equality Result: true
```


---

## Learning Outcome
This project helps understand:
- How to structure Java applications
- How to separate business logic from test logic
- How to write unit test cases using JUnit 5
- Importance of clean code architecture

---

## Author
Saket-2005

---

## Note
This project follows a modular approach and will be extended for multiple use cases (UC2–UC20) involving different unit conversions and comparisons.
