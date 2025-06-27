# employee-payroll
The Employee Payroll System is a backend service that helps HR teams efficiently manage employee records, salary details, departments, and more — with secure RESTful APIs and database integration.

 ## What Does It Do?
✅ Add, update, and delete employee records

✅ Store employee details (name, salary, gender, departments)

✅ Assign departments and track employee associations

✅ Fetch employee list with filtering by ID or department

✅ Fully RESTful API with proper validation and error handling

## Tech Stack
| Technology    | Description                     |
| ------------- | ------------------------------- |
| Java 21       | Programming Language            |
| Spring Boot   | Backend Framework               |
| MySQL / H2    | Database                        |
| Lombok        | Reduce boilerplate code         |
| Hibernate JPA | ORM for DB interaction          |
| Maven         | Build and dependency management |
| Swagger       | API Documentation (Optional)    |

## How It Works (Step-by-Step)
<img src="https://github.com/user-attachments/assets/a20bb497-08e1-47e4-b40d-e50fd5a81b4b" alt="image" width="400"/>




## Sample APIs
| Method | Endpoint         | Description           |
| ------ | ---------------- | --------------------- |
| POST   | `/employee`      | Add a new employee    |
| GET    | `/employee`      | Get all employees     |
| GET    | `/employee/{id}` | Get employee by ID    |
| PUT    | `/employee/{id}` | Update employee by ID |
| DELETE | `/employee/{id}` | Delete employee       |
