# 🚗 Car Marketplace API Testing Framework

This project is an automated testing framework for a **Car Marketplace REST API**. It is built using **Java**, **REST Assured**, and **Cucumber (BDD)** to ensure scalable, readable, and maintainable API tests.

---

## 🚀 Technologies Used

- **Java 17** – Main programming language  
- **REST Assured** – API testing and validation  
- **Cucumber (BDD)** – Behavior Driven Development  
- **JUnit 4 / JUnit Platform** – Test execution  
- **Maven** – Build & dependency management  
- **Allure Report** – Test reporting  
- **Jackson** – JSON serialization/deserialization  
- **AssertJ** – Fluent assertions  
- **Postman Mock Server** – API mocking & contract simulation  

---

## 📁 Project Structure

```text
.
├── src
│   └── test
│       ├── java
│       │   └── com.car.api
│       │       ├── builders
│       │       ├── constants
│       │       ├── hooks
│       │       ├── pojoModels
│       │       ├── runners
│       │       ├── services
│       │       ├── stepdefinitions
│       │       └── utils                      
│       │
│       └── resources
│           ├── config
│           ├── features
│           ├── schemas
│           ├── testdata
│           └── junit-platform.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Installation

### Prerequisites

- Java 17+
- Maven 3+

### Setup

```bash
git clone <repo-url>
cd car-marketplace-api-tests
mvn clean install -DskipTests
```

---

## 🧪 Running Tests

### Run all tests (default env)
```bash
mvn test
```

### Run with specific environment
```bash
mvn test -Denv=stage
```

### Run via Runner
```text
src/test/java/com/car/api/runners
```

---

## 📊 Reports (Allure)

Generate report:
```bash
mvn allure:report
```

Serve report:
```bash
mvn allure:serve
```

---

## 🧩 Postman Mock Server Setup

This project supports a **Postman Mock Server** to simulate API responses without relying on a backend.

### 📌 Why use it?
- Backend unavailable
- Stable deterministic responses
- Contract testing
- Early frontend/backend parallel work

---

### 🛠️ Setup Steps

1. Open Postman
2. Import collection from:
   ```
   src/test/resources/postman
   ```
3. Add examples to requests:
   - Open request
   - Click **Save Response → Save as Example**

4. Create Mock Server:
   - Postman → Mock Servers → Create
   - Select your collection
   - Enable “Use examples”

5. Copy Mock URL:
   ```
   https://xxxx.mock.pstmn.io
   ```

---

### 🔧 Configure Framework

Update config:
```properties
base.url=https://xxxx.mock.pstmn.io
```

Or run:
```bash
mvn test -Denv=mock
```

---

## 🧠 Architecture Highlights

- Service layer abstraction over REST Assured
- BDD with Cucumber feature files
- Reusable API client wrapper
- Builder pattern for test data
- Schema validation for responses
- Environment-based configuration system

---

## 🧪 Test Resources

Located in:
```
src/test/resources
```

- `config/` → environment configs
- `features/` → Cucumber scenarios
- `schemas/` → JSON schema validation
- `testdata/` → static test data
- `junit-platform.properties` → JUnit configuration

---

## 🚀 Future Improvements

- Parallel execution (ThreadLocal support)
- WireMock integration alternative
- Dockerized test execution
- CI/CD pipeline (GitHub Actions / Jenkins)
- Contract testing (Pact)

---

## 👨‍💻 Author Notes

This framework is designed for scalability, maintainability, and real-world API testing workflows used in modern QA automation pipelines.

