package com.maven.learn.project.bankingSystem.login;

import java.util.Scanner;
import com.maven.learn.project.bankingSystem.model.Bank;

public class LoginModel 
{
	private LoginView loginView;

	LoginModel(LoginView loginView) 
	{
		this.loginView = loginView;
	}	
	public void validateUser(String userName, String password) {
		if (isValidName(userName)) {
			if (isValidPassword(password)) {
				loginView.onSuccess();
			} else {
				loginView.showAlert("Invalid Password");
			}

		} else {
			loginView.showAlert("Invalid UserName \nEnter the Credential Again.");
		}

	}

	private boolean isValidName(String name) {
		return name.equals("SBI");
	}

	private boolean isValidPassword(String password) {
		return password.equals("sbi123");
	}
	
}
