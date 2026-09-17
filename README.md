# 🎓 Placement Management System

A web-based **Placement Management System** developed using **Java, Spring Boot, MySQL, JWT Authentication, HTML, CSS, and JavaScript**.

The system is designed to manage students, companies, job opportunities, and student applications through a centralized platform.

---

## 🚀 Features

### 🔐 Authentication & Security

* User Registration
* User Login
* JWT-based Authentication
* Protected Backend APIs
* Logout functionality
* Role selection for Student, Admin, and Company

### 👨‍🎓 Student Management

* Add Student
* View Students
* Update Student
* Delete Student
* Manage student details, course, skills, email, and phone

### 🏢 Company Management

* Add Company
* View Companies
* Update Company
* Delete Company

### 💼 Job Management

* Add Job
* View Jobs
* Update Job
* Delete Job
* Manage job title, company, location, salary, and requirements

### 📝 Application Management

* Apply for jobs
* View applications
* Update application status
* Edit applications
* Delete applications

---

## 🛠️ Technologies Used

| Technology      | Purpose                       |
| --------------- | ----------------------------- |
| Java 21         | Backend Programming           |
| Spring Boot     | Backend Framework             |
| Spring Web      | REST APIs                     |
| Spring Data JPA | Database Operations           |
| Spring Security | Application Security          |
| JWT             | Authentication                |
| MySQL           | Database                      |
| HTML5           | Frontend                      |
| CSS3            | Styling                       |
| JavaScript      | Frontend Logic                |
| Maven           | Build & Dependency Management |
| Git & GitHub    | Version Control               |

---

## 🏗️ Project Architecture

```text
Placement-Management-System
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── placement
│       │           ├── placement_management_system
│       │           │
│       │           ├── config
│       │           │   ├── JwtService.java
│       │           │   ├── JwtAuthenticationFilter.java
│       │           │   └── SecurityConfig.java
│       │           │
│       │           ├── controller
│       │           │   ├── AuthController.java
│       │           │   ├── StudentController.java
│       │           │   ├── CompanyController.java
│       │           │   ├── JobController.java
│       │           │   └── ApplicationController.java
│       │           │
│       │           ├── model
│       │           │   ├── User.java
│       │           │   ├── Student.java
│       │           │   ├── Company.java
│       │           │   ├── Job.java
│       │           │   └── Application.java
│       │           │
│       │           └── repository
│       │               ├── UserRepository.java
│       │               ├── StudentRepository.java
│       │               ├── CompanyRepository.java
│       │               ├── JobRepository.java
│       │               └── ApplicationRepository.java
│       │
│       └── resources
│           ├── application.properties
│           │
│           └── static
│               ├── index.html
│               └── auth.html
│
├── pom.xml
└── README.md
```

---

## 🔑 Authentication Flow

```text
User
  │
  ▼
Register
  │
  ▼
Login
  │
  ▼
Spring Boot Authentication
  │
  ▼
JWT Token Generated
  │
  ▼
Token Stored in Browser
  │
  ▼
Protected API Request
  │
  ▼
JWT Authentication Filter
  │
  ▼
Access Granted
```

---

## 🌐 API Endpoints

### Authentication

```text
POST /api/auth/register
POST /api/auth/login
```

### Students

```text
GET    /api/students
GET    /api/students/{id}
POST   /api/students
PUT    /api/students/{id}
DELETE /api/students/{id}
```

### Companies

```text
GET    /api/companies
GET    /api/companies/{id}
POST   /api/companies
PUT    /api/companies/{id}
DELETE /api/companies/{id}
```

### Jobs

```text
GET    /api/jobs
GET    /api/jobs/{id}
POST   /api/jobs
PUT    /api/jobs/{id}
DELETE /api/jobs/{id}
```

### Applications

```text
GET    /api/applications
GET    /api/applications/{id}
POST   /api/applications
PUT    /api/applications/{id}
DELETE /api/applications/{id}
```

---

## 💻 How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/puneetkumar27/Placement-Management-System.git
```

### 2. Open the Project

Open the project in **VS Code** or **IntelliJ IDEA**.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE placement_db;
```

Configure your database credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/placement_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
server.port=8081
```

Set your database password through the environment variable:

```powershell
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

### 4. Start the Application

From the project directory:

```powershell
./mvnw.cmd spring-boot:run
```

The backend will start on:

```text
http://localhost:8081
```

### 5. Open Authentication Page

```text
http://localhost:8081/auth.html
```

After login, the main application can be accessed at:

```text
http://localhost:8081/
```

---

## 🔒 Security

The project uses:

* Spring Security
* JWT Authentication
* Password Encoding
* Stateless Session Management
* Protected REST APIs

Authentication token is sent with protected requests using:

```text
Authorization: Bearer <JWT_TOKEN>
```

---

## 📊 Main Modules

```text
             Placement Management System
                       │
       ┌───────────────┼────────────────┐
       │               │                │
       ▼               ▼                ▼
 Authentication    Management       Applications
       │               │                │
       │        ┌──────┼──────┐         │
       │        │      │      │         │
       ▼        ▼      ▼      ▼         ▼
     Login   Student Company Job      Apply
     Register                          Track
     JWT                               Status
```

---

## 🎯 Project Objectives

The main objectives of this project are:

1. To provide a centralized platform for placement management.
2. To manage student information efficiently.
3. To maintain company and job information.
4. To manage student job applications.
5. To implement secure user authentication.
6. To provide RESTful APIs for backend operations.
7. To reduce manual placement management work.
8. To provide a foundation for future intelligent placement features.

---

## 🔮 Future Enhancements

Planned improvements include:

* Role-Based Access Control
* Admin Dashboard
* Student Dashboard
* Company Dashboard
* Job Search and Filtering
* Resume Upload
* Placement Eligibility Checking
* Email Notifications
* Application Status Notifications
* Advanced Dashboard Analytics
* AI-based Job Recommendation
* Student-Job Matching
* Placement Prediction
* Interview Scheduling

---

## 📚 Academic & Research Scope

This project can be extended for academic research by incorporating:

* Intelligent job recommendation
* Student-job matching algorithms
* Skill gap analysis
* Placement prediction
* Machine learning-based candidate ranking
* Data-driven placement analytics

These extensions can provide opportunities for experimentation, evaluation, and research-paper development.

---

## 👨‍💻 Developer

**Puneet Kumar**

MCA Fresher | Java Full Stack Developer

### GitHub

`https://github.com/puneetkumar27`

---

## ⭐ Project Status

**Current Status:** 🚧 Active Development

The core authentication, student, company, job, and application management modules are implemented. Further improvements are planned to make the system more secure, scalable, and production-ready.

---

## 📄 License

This project is developed for **educational and academic purposes**.
