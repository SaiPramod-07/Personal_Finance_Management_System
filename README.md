Personal Finance Management System
1. Project Purpose

The Personal Finance Management System is a backend application developed using Java and Spring Boot to manage personal income and expense transactions. The main purpose of the project is to allow users to add, view, update, delete, and filter transactions and also get a financial summary showing total income, total expenses, remaining balance, and category-wise expenses. Since this is a small project, I used an in-memory ArrayList to temporarily store the transaction data instead of using a database.

2. Project Flow

The application follows a simple layered architecture:

Client / Postman
       ↓
   Controller
       ↓
     Service
       ↓
    ArrayList
       ↓
     Service
       ↓
   Controller
       ↓
Client / Postman

When a request comes from the client, the Controller receives it and passes it to the appropriate Service. The Service performs the required business logic and works with the ArrayList to store or retrieve transaction data. The result is then returned from the Service to the Controller, and the Controller sends the final response back to the client.

3. Project Structure

The project is divided into three main modules:

Model
Service
Controller

Each module has a separate responsibility.

4. Model Module

The Model module contains the classes that represent the data used in the application.

Transaction

The Transaction class represents an individual financial transaction.

It contains details such as:

Transaction ID
Amount
Transaction Type
Category
Date

The transaction type identifies whether the transaction is an INCOME or EXPENSE.

Purpose:
To represent and store the details of each financial transaction as an object.

TransactionSummary

The TransactionSummary class represents the calculated financial information.

It contains:

Total Income
Total Expense
Remaining Balance
Category-wise Expenses

Purpose:
To represent the final financial summary that is returned to the client.

5. Service Module

The Service module contains the main business logic of the application.

It contains two classes:

TransactionService
TransactionSummaryService
TransactionService

This class handles the main operations related to transactions.

Features implemented:
Add transaction
Get all transactions
Get transaction by ID
Update transaction
Delete transaction
Filter transactions
Validate transaction data
Check duplicate transaction IDs
Validate transaction type
Check whether an expense exceeds the available balance

Purpose:
To handle transaction-related operations and apply the required business rules before modifying or returning the data.

TransactionSummaryService

This class is responsible for generating the financial summary from the available transactions.

Features implemented:
Calculate total income
Calculate total expenses
Calculate remaining balance
Calculate category-wise expenses

Purpose:
To process the stored transactions and generate meaningful financial information for the user.

6. Controller Module

The Controller module handles REST API requests and responses.

It contains:

TransactionController
TransactionSummaryController
TransactionController

This controller exposes APIs for transaction operations.

It handles:

Creating transactions using POST
Retrieving transactions using GET
Updating transactions using PUT
Deleting transactions using DELETE
Filtering transactions

It uses Spring Boot annotations such as:

@PostMapping
@GetMapping
@PutMapping
@DeleteMapping

Purpose:
To receive transaction-related requests from the client and send them to TransactionService.

TransactionSummaryController

This controller exposes the API for getting the financial summary.

It sends the request to TransactionSummaryService, receives the calculated summary, and returns it to the client.

Purpose:
To provide the financial summary through a REST API.

7. Main Features
Transaction Management

Users can manage their financial transactions through REST APIs.

Add → View → Update → Delete
Filtering

Transactions can be filtered based on the supported filtering criteria.

Validation

The application validates transaction information and applies business rules such as duplicate ID checking and transaction type validation.

Financial Summary

The application calculates:

Total Income
Total Expense
Remaining Balance
Category-wise Expenses
REST APIs

All major operations are exposed through REST APIs and tested using Postman.

8. Data Storage

For this project, transaction data is stored in an ArrayList.

ArrayList<Transaction>

The ArrayList acts as temporary storage while the application is running.

I used this approach because the main focus of this project was to understand Spring Boot, REST APIs, layered architecture, validation, and business logic without adding database complexity.

Limitation: Since the data is stored in memory, it will be lost when the application is restarted.

9. API Testing

I used Postman to test the REST APIs.

I tested operations such as:

Creating transactions
Retrieving transactions
Updating transactions
Deleting transactions
Filtering transactions
Retrieving the financial summary
Testing validation and business rules

This helped me verify whether the application was correctly handling requests and returning responses.

10. Technologies Used
Java – Application development
Spring Boot – Backend development
Spring Web – REST API development
Jakarta Bean Validation – Input validation
ArrayList – Temporary data storage
Postman – API testing
Maven – Dependency and project management
11. What I Learned

Through this project, I learned how to build a REST API using Spring Boot and how different layers of a backend application work together.

I understood:

Controller and Service responsibilities
Layered architecture
REST API development
HTTP methods
Dependency Injection
Request and response handling
Validation
Business logic implementation
Working with ArrayList
Testing APIs using Postman
12. Overall Project Structure
Personal Finance Management System
│
├── Model
│   ├── Transaction
│   └── TransactionSummary
│
├── Service
│   ├── TransactionService
│   └── TransactionSummaryService
│
└── Controller
    ├── TransactionController
    └── TransactionSummaryController
Overall Flow

Client → Controller → Service → ArrayList → Service → Controller → Client
