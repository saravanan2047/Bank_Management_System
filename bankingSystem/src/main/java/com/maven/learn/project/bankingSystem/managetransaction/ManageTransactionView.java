package com.maven.learn.project.bankingSystem.managetransaction;

import java.util.Scanner;

import com.maven.learn.project.bankingSystem.login.LoginView;
import com.maven.learn.project.bankingSystem.managebankpanel.ManageBankModel;
import com.maven.learn.project.bankingSystem.managecustomer.ManageCustomerView;

public class ManageTransactionView {
	private ManageTransactionModel transactionModel;
	Scanner scan = new Scanner(System.in);

	public ManageTransactionView() {
		transactionModel = new ManageTransactionModel(this);
	}

	public void init() {

		try {
			while (true) {
				System.out.println(
						"Select the choice \n1) Deposit \n2) Withdraw \n3) Check Balance \n0) Return TO Home ");
				String choice = scan.next();
				switch (choice) {
				case "1":
					deposit();
					break;
				case "2":
					withdraw();
					break;
				case "3":
					checkBalance();
					break;
				case "0":
					System.out.println("~~~~~~~~~~~~ ` Thanks For Using `~~~~~~~~~~~");
					break;
				default:
					System.out.println("\n Please Enter a Valid Choice\n");
				}
				if (choice.equals("0"))
					new ManageBankModel().onComplete();
			}
		} catch (Exception e) {
			System.out.println("\n!!!! Please Enter valid choice !!!!!!\n");
			init();
		}
	}

	public void deposit() {
		System.out.println("Enter the Account number : ");
		int accNo = scan.nextInt();
		System.out.print("Enter deposit amount: ");
		double depositAmount = scan.nextDouble();
		if (transactionModel.depositMoney(accNo, depositAmount)) {
			System.out.println("Money Deposited Successfully.....\n");
			init();
		} else {
			System.out.println("Enter a valid details...");
			init();
		}
	}

	public void checkBalance() {
		System.out.print("Enter account number: ");
		int checkBalanceAccNumber = scan.nextInt();
		double currentBalance = transactionModel.checkBalance(checkBalanceAccNumber);
		if (currentBalance != -1)
			System.out.println("Current balance: " + currentBalance + "\n");
		else
			System.out.println("Account Not Found Enter Correct details");
		init();
	}

	public void withdraw() {
		System.out.print("Enter account number: ");
		int withdrawAccNumber = scan.nextInt();
		System.out.print("Enter withdrawal amount: ");
		double withdrawAmount = scan.nextDouble();
		if (transactionModel.withdrawMoney(withdrawAccNumber, withdrawAmount)) {
			System.out.println(
					withdrawAmount + " amount deducted Successfully from " + withdrawAccNumber + " Account Number\n");
			init();
		} else {
			System.out.println(
					"Withdrawn Amount is greater than Current balance\nPlease enter withdrawing amount less than Current Balance");
			init();
		}
	}
	
	public void alert(String message) {
		System.out.println(message + "\n");
		init();
	}
}
