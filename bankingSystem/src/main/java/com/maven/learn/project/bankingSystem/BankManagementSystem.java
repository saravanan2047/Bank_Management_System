package com.maven.learn.project.bankingSystem;

import com.maven.learn.project.bankingSystem.login.LoginView;

public class BankManagementSystem 
{
		private static BankManagementSystem bank;
		private String appName = "Banking System";
		private String version = "1.0.1";

		public BankManagementSystem() {

		}

		public static BankManagementSystem getInstance() {
			if (bank == null) {
				bank = new BankManagementSystem();
			}
			return bank;
		}

		public void create() {
			LoginView loginview = new LoginView();
			loginview.initCreation();
		}

		public String getAppName() {
			return bank.appName;
		}

		public String getVersion() {
			return bank.version;
		}

		public static void main(String[] args) {
			BankManagementSystem.getInstance().create();

		}

	}
