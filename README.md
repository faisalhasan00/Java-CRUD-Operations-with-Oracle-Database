 #Java CRUD Operations with Oracle Database
This project demonstrates CRUD (Create, Read, Update, Delete) operations using Java with an Oracle Database. The application allows users to manage product records in a database table through a console-based interface.

🚀 Features
Add Product: Insert a new product into the database.
View Products: Display all products or a specific product by its code.
Update Product: Modify the price and quantity of an existing product.
Delete Product: Remove a product using its code.

Requirements
Ensure you have the following before running the project:

Java Development Kit (JDK)
Oracle Database installed and running
Oracle JDBC Driver (ojdbc6.jar or ojdbc8.jar)

Database Setup
Step 1: Create the Product Table
Run the following SQL script in your Oracle Database to create the PRODUCT table:
sql


CREATE TABLE PRODUCT (
    PCODE VARCHAR(10) PRIMARY KEY,
    PNAME VARCHAR(50),
    PRICE DOUBLE,
    QTY INTEGER
);

Project Setup
Step 2: Update Database Configuration
String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Update host and service name if needed
String uname = "your database username";          // Oracle username
String pswd = "your database paswword";          // Oracle password

Step 3: Add JDBC Driver
Add the Oracle JDBC Driver (ojdbc6.jar or ojdbc8.jar) to your project classpath.


