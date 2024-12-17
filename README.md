
# Java CRUD Operations with Oracle Database

This project demonstrates CRUD (Create, Read, Update, Delete) operations using Java with an Oracle Database. The application allows users to manage product records in a database table through a console-based interface.


🚀 Features
-  Add Product:  Insert a new product into the database.
- View Products: Display all products or a specific product by its code.
-  Update Product: Modify the price and quantity of an existing product.
- Delete Product: Remove a product using its code.



## 🛠 Requirements
- To run the project, ensure you have:
- Java Development Kit (JDK) installed.
- Oracle Database installed and running.
- Oracle JDBC Driver (ojdbc6.jar or ojdbc8.jar).
## 📂 Database Setup
### Step 1: Create the Product Table
- Run the following SQL script in your Oracle Database to create the PRODUCT table:

```http
 CREATE TABLE PRODUCT ( 
    PCODE VARCHAR(10) PRIMARY KEY, 
    PNAME VARCHAR(50), 
   PRICE DOUBLE, 
    QTY INTEGER 
 );
```

## ⚙️ Project Setup
### Step 2: Update Database Configuration
- Modify the database connection details in your CRUD_OPERATION.java file:

```http
String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Update host and service name if needed
String uname = "your database username";           // Oracle username
String pswd = "your database password";            // Oracle password

```

### Step 3: Add JDBC Driver
- Add the Oracle JDBC Driver (ojdbc6.jar or ojdbc8.jar) to your project’s classpath.


## ▶️ Running the Project
- Follow these steps to run the project:
#### 1. Compile the Program.
#### 2. Run the Program.

#### 3. Follow the Console Menu:
- Use the menu options to perform CRUD operations:

```http
==== Choose ====
1 ADD
2 DISPLAY
3 UPDATE
4 DELETE
Enter your choice:
```
## 📜 Notes
- Ensure the Oracle Database server is running before starting the application.
- Update the connection URL, username, and password as per your - database configuration.
- Add the JDBC driver to your project classpath.
## 🛠 Technologies Used

- Java
- Oracle Database
- JDBC (Java Database Connectivity)
## License

This project is licensed under the [MIT](https://choosealicense.com/licenses/mit/)

