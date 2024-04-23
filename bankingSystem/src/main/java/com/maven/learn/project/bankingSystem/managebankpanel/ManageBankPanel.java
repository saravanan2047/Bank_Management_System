package com.maven.learn.project.bankingSystem.managebankpanel;

import com.maven.learn.project.bankingSystem.datalayer.BankingDataBase;
import com.maven.learn.project.bankingSystem.model.Bank;
import com.maven.learn.project.bankingSystem.model.Validation;



public class ManageBankPanel 
{
	private ManageBankModel panelView;
	private Bank bank;
	ManageBankPanel (ManageBankModel transactionView)
	{
		this. panelView=transactionView;
		bank= BankingDataBase.createInstance().getBank();
	}
	public void initateSetUp() {
		if (bank == null)
		{
			 panelView.initiateSetUp();
		} else {
			 panelView.onComplete();
		}
	}

	public void createBankPanel(Bank bank) {
		Validation valid = new Validation();
		boolean stat = valid.validEmail(bank.getEmail()) && valid.validPhoneNo(bank.getPhoneNumber());
		if (stat) {
			BankingDataBase.createInstance().insertBank(bank);
			 panelView.onSuccess();
		} else {
			 panelView.showAlert("Invalid Company details....... \n\nPlease re enter proper details....\n");
			 panelView.initiateSetUp();

		}
	}


}
