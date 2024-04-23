package com.maven.learn.project.bankingSystem.managebankpanel;

import java.util.Scanner;

import com.maven.learn.project.bankingSystem.datalayer.BankingDataBase;
import com.maven.learn.project.bankingSystem.login.LoginView;
import com.maven.learn.project.bankingSystem.managecustomer.ManageCustomerView;
import com.maven.learn.project.bankingSystem.managetransaction.ManageTransactionView;
import com.maven.learn.project.bankingSystem.model.Bank;

public class ManageBankModel {
	private ManageBankPanel panelModel;
	Scanner scan = new Scanner(System.in);

	public ManageBankModel() {
		panelModel = new ManageBankPanel(this);
	}

	public void init() {
		panelModel.initateSetUp();
	}

	public void onSuccess() {
		System.out.println("\n******************************************");
		System.out.println("\nBank Details Completed Completed successfully...\n");
		System.out.println("Current Company Name : " + BankingDataBase.createInstance().getBank().getName());
		System.out.println("\n******************************************");
		onComplete();
	}
	
	public void onComplete() {

		try {
			while (true) {
				System.out.println(
						"Select option for further Step :\n1) Manage Customer \n2) Manage Transaction \n3) Log Out \n0) EXIT  ");
				String choice = scan.next();

				switch (choice) {
				case "1":
					new ManageCustomerView().initAdd();
					break;
				case "2":
					new ManageTransactionView().init();
					break;
				case "3":
					System.out.println("\n************ Logged Out Successfully ************\n\n");
					new LoginView().init();
					break;
				case "0":
					System.out.println("~~~~~~~~~~~~ ` Thanks For Using `~~~~~~~~~~~");
					break;
				default:
					System.out.println("\n Please Enter a Valid Choice\n");
				}
				if (choice.equals("0"))
					System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("\n!!!! Please Enter valid choice !!!!!!\n");
			onComplete();
		}

	}

	public void initiateSetUp() {
		try {
			Bank bank = new Bank();
			System.out.println("Enter Company ID : (Ex: 1245)");
			int id = scan.nextInt();
			bank.setBankId(id);
			scan.nextLine();
			System.out.println("Enter the Company Name : (Ex: NCD pvt ltd) ");
			String companyName = scan.nextLine();
			bank.setName(companyName);
			System.out.println("Enter the company Email : (Ex: zsgs2024@gmail.com) ");
			String email = scan.next();
			bank.setEmail(email.toLowerCase());
			System.out.println("Enter the company Address : (Ex: tenkasi TN 627581) ");
			scan.nextLine();
			String address = scan.nextLine();
			bank.setAddress(address);
			System.out.println("Enter the phone number : (Ex: 987456310 or 987-654-3210 or (123) 456-7890 ");
			String mobileno = scan.next();
			bank.setPhoneNumber(mobileno);

			panelModel.createBankPanel(bank);
		}

		catch (Exception e) {
			System.out.println("\nEnter the corrrect details....\n\n");
			initiateSetUp();
		}

	}

	public void showAlert(String string) {
		System.out.println("\n" + string + "\n");
		initiateSetUp();
	}

}
