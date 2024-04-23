package com.maven.learn.project.bankingSystem.managetransaction;

import java.util.Scanner;
import com.maven.learn.project.bankingSystem.datalayer.BankingDataBase;

public class ManageTransactionModel {
	private ManageTransactionView transactionView;
	Scanner scan = new Scanner(System.in);
	ManageTransactionModel(ManageTransactionView transactionView) {
		this.transactionView = transactionView;
	}

	public void init() {
	}
	public boolean depositMoney(int accNo, double money) {
		if (BankingDataBase.createInstance().isPresent(accNo)) {
			return BankingDataBase.createInstance().depositeMoney(accNo, money);
		} else {
			System.out.println("Account not Found \n");
			return false;
		}
	}
	public boolean withdrawMoney(int accNo, double withdrawAmount) {
		if (BankingDataBase.createInstance().isPresent(accNo)) {
			return BankingDataBase.createInstance().withdrawMoney(accNo, withdrawAmount);
		} else {
			System.out.println("Account not Found \n");
			return false;
		}
	}
	public double checkBalance(int accNo) {
		if (BankingDataBase.createInstance().isPresent(accNo)) {
			return BankingDataBase.createInstance().checkBalance(accNo);
		} else {
			return -1;
		}
	}
}
