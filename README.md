#**BANK MANAGEMENT SYSTEM**


**_Overview_**

The Bank Management System is a Java application designed to manage basic banking operations. This program allows users to create and manage bank accounts, perform transactions, and view account details.

**_Features_**

1. _Account Creation:_ Users can create new bank accounts with unique account numbers. Details such as Account number, phone number, email,pan number& address are required.

2. _Deposit and Withdrawal:_ Users can deposit and withdraw funds from their accounts. Details required account number through which the money is deducted and updated in the account.

3. _Balance Inquiry:_ Users can check the balance of their accounts using their account number.

4. _Customer Details:_ Manager can view the details of their customer, including their address, contact details and balance.


**Concepts and Techniques Used**

_1. Object-Oriented Programming (OOP)_
Classes and Objects: The system uses classes such as Bank, user, and Transaction to model the entities in the bank.
Encapsulation: Data fields are encapsulated within classes, and access is provided through public methods.
Inheritance: If applicable, different types of users can be handled through inheritance.
Polymorphism: Methods that perform similar operations on different types of data can be overridden in subclasses if needed.

_3. Data Structures_

ArrayLists: Used to maintain dynamic lists of users and transactions.

_4. File Handling_

Reading and Writing: The system may use file I/O to persist the library's inventory and transaction records.

_5. Exception Handling_

Try-Catch Blocks: Used to handle errors gracefully and ensure the system remains robust and user-friendly.

**How to Run**

_Compile the Program:_ Use the following command to compile the Java program:

bash
Copy code
javac BankManagementSystem.java
Run the Program: Use the following command to run the compiled Java program:

bash
Copy code
java BankManagementSystem


**_Usage_**

_Create an Account:_ Follow the prompts to enter account details such as account number, account holder's name, and initial deposit.

_Deposit Funds:_ Select the deposit option and enter the amount to deposit into the account.

_Withdraw Funds:_ Select the withdrawal option and enter the amount to withdraw from the account.

_Check Balance:_ Select the balance inquiry option to view the current balance of the account.

_View Account Details:_ Select the option to view all details of the account.

**_Code Structure_**

_BankManagementSystem.java:_ The main file containing the implementation of the banking operations.

_Account Class:_ Manages individual account information and transactions.

_BankManagementSystem Class:_ Handles user interaction and overall system operations.

**_Requirements_**

Java Development Kit (JDK): Ensure that JDK is installed on your system to compile and run the program.

_**IMAGES**_

**1) LOGIN**

![Login](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/c96bdfe0-8f03-4ef5-b964-0b18976fd945)

**2) LOGOUT**

![logout](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/827f9e8c-e87e-4bc0-a68f-e93150f8ba66)

**3) BANK CREATION**

![bankcreation](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/a7dfe5bc-8e2d-4c8f-9bbf-77b407aabb30)

**4) CREATE CUSTOMER**

![customerAdd](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/addf6f3f-ef3f-4bb9-ba4f-a576ddfa8846)

**5) DISPLAY CUSTOMER**

![displayallcustomer](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/e9d997e9-af6f-466e-b389-bb7c8e2d40a6)

**6) SEARCH CUSTOMER**

![searchCustomer](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/23d058b8-b750-4fd3-bbb6-929ce410d6f3)

**7) DELETE CUSTOMER**

![deletecustomer](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/268a753c-5ca9-41a4-96a7-fe63035c875c)

**8) MANAGE TRANSACTION**

![ManageingTransaction](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/912b0b70-528e-47d8-88ce-2f9bd452dee3)

**9) DEPOSIT MONEY**

![moneydeposit](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/ab310684-3470-4e2a-aae1-1ec3bee2a230)

**10) WITHDRAW MONEY**

![withdraw](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/7b7f05e4-ec85-45d7-869b-61ce08bb5820)

**11) EXIT**

![Exit](https://github.com/saravanan2047/Bank_Management_System/assets/95707512/1d8ac5a6-06f7-44d4-9adb-52856b4c69a2)


**_Contributions_**

Feel free to contribute to the project by forking the repository and submitting pull requests. For major changes, please open an issue to discuss what you would like to change.

**_License_**

This project is open-source and available under the MIT License.

