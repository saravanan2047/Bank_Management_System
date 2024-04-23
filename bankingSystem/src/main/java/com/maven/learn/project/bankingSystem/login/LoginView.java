package com.maven.learn.project.bankingSystem.login;

import java.util.Scanner;
import com.maven.learn.project.bankingSystem.BankManagementSystem;
import com.maven.learn.project.bankingSystem.managebankpanel.ManageBankModel;
public class LoginView 
{
	Scanner scanner = new Scanner(System.in);
	private static LoginModel loginmodel;
	
	public LoginView()
	{
		loginmodel=new LoginModel(this);	
	}
	public void initCreation() {
		System.out.println("-------------------" + BankManagementSystem.getInstance().getAppName() + " -------------------- \n\t\t   Version: "
				+ BankManagementSystem.getInstance().getVersion()+"\n");
		init();

	}

	public void init() 
	{
		System.out.println("****************** WELCOME TO BMS ****************");
		System.out.println("\n************* Please Login To Proceed ************");
		System.out.println("\nEnter the user name:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		loginmodel.validateUser(userName, password);
	}
	public void onSuccess() {
		System.out.println("\n\n**************** Login successful *****************\n\n --------- Welcome To SBI "
				+ BankManagementSystem.getInstance().getAppName() + " ---------\n  " + "\n\t\t ----- V"
				+ BankManagementSystem.getInstance().getVersion() + "----\n  ");
		// ManagePanelView managePanelView = new ManagePanelView();
		new ManageBankModel().init(); // calling the next package method
	}
	
	public void showAlert(String message) {
		System.out.println(message);
		checkForLogin();
	}
	private void checkForLogin() {
		System.out.println("Do you try again? \n\n Type 1) Yes \n2) No");
		
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("1")) {
			init();
		} else if (choice.equalsIgnoreCase("2")) {
			System.out.println("\n <------------> Thanks You <------------>");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForLogin();
		}
	}
}
