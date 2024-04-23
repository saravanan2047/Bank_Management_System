package com.maven.learn.project.bankingSystem.managecustomer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.maven.learn.project.bankingSystem.managebankpanel.ManageBankModel;
import com.maven.learn.project.bankingSystem.model.Customer;



public class ManageCustomerView 
{
	private ManageCustomerModel customerModel;
	Scanner scan= new Scanner(System.in);
	public ManageCustomerView()
	{
		customerModel = new ManageCustomerModel(this);
	}

	public void initAdd() {
		try {
			while (true) {
				// scan.nextLine();
				System.out.println(
						"Select the option you want to carry out: \n1) ADD Customer \n2) Search Customer \n3) SHOW All Customer \n4) Remove Customer \n5) Exit");
				String choice = scan.next();
				switch (choice) {
				case "1":
					addCustomer();
					break;
				case "2":
					searchCustomers();
					break;
				case "3":
					displayAllCustomers();
					break;
				case "4":
					removeCustomer();
				case "5":
					System.out.println("<~~~~~~~~~~~~~~> Redirecting To Main Page <~~~~~~~~~~~~~~>");
					new ManageBankModel().onComplete();
					break;
				default:
					System.out.println("\n ~~~~~~~~~> Please Enter a Valid Choice <~~~~~~~~ \n");
					break;
				}
				if (choice.equals(("5")))
					break;
			}
		} catch (InputMismatchException e) {
			System.out.println("\n!!!! Please Enter valid choice !!!!!!\n");
			initAdd();
		}
	}

	private void addCustomer() {
		Customer customer= new Customer();
		try {
			System.out.println("Enter the Customer's Account Number : ");
			int id = scan.nextInt();
			customer.setCustomerId(id);
			scan.nextLine();
			System.out.println("Enter the Customer's Name: ");
			String name = scan.nextLine();
			customer.setCustomerName(name);
			System.out.println("Enter the Customer's Email: ");
			String emial = scan.next();
			customer.setEmail(emial.toLowerCase());
			System.out.println("Enter the Customer's mobile number: ");
			String mobileNo = scan.next();
			customer.setPhoneNumber(mobileNo);
			System.out.println("Enter the Customer's PAN Number: ");
			String pan = scan.next();
			customer.setPanNo(pan);
			System.out.println("Enter the Customer's Address: ");
			scan.nextLine();
			String address = scan.nextLine();
			customer.setAddress(address.toLowerCase());
			customerModel.setCustomer(customer);

		} 
		catch (Exception e) {
			System.out.println("Enter the details correctly...!!!!\n");
		}
		
	}
	public void searchCustomers() {
		System.out.println("Enter the Customer Email Id :");
		String email = scan.next();
		System.out.println("\nThe Result of your search.....");
		Customer customers = customerModel.searchCustomer(email);

		if (customers != null) {
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.printf(" %10s %15s %20s %25s %25s", "Account NO","Customer Name", "Customer Email", "Customer PAN Number","Initial Balance");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------");		
			System.out.format("%10s %13s %23s %22s %23s", customers.getCustomerId(),customers.getCustomerName(),customers.getEmail(), customers.getPanNo(),customers.getMoney());
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("\nCustomer not found add customer.\n");
			initAdd();
		}
	}

	public void displayAllCustomers() {
		List<Customer> customerList = customerModel.getAllCustomer();
		if (!customerList .isEmpty()) {
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.printf(" %10s %15s %20s %25s %25s", "Account NO","Customer Name", "Customer Email", "Customer PAN Number","Initial Balance");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			for (Customer cust : customerList ) {
				System.out.format("%10s %13s %23s %22s %23s", cust.getCustomerId(),cust.getCustomerName(),cust.getEmail(), cust.getPanNo(),cust.getMoney());
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------------------------------------");
			}
			initAdd();
		} else {
			System.out.println("\nNo Customer found..!!!!\nADD CUSTOMERS FIRST...\\n");
			initAdd();
		}
	}

	private void removeCustomer() {
		System.out.println("Enter the Customer Email Id :");
		String email = scan.next();
		boolean stat = customerModel.deleteCustomer(email);
		if (stat) {
			System.out.println("\nCustomer Deleted Successfully...\n");
			initAdd();
		} else {
			System.out.println("\nCustomer Not Found Please Enter Correct Email.\n");
			initAdd();
		}

	}
	public void onSuccess() {
		System.out.println("\nCustomer addedd successfully\n\n");
	}

	public void alert(String message) {
		System.out.println(message);
	}

}
