package com.maven.learn.project.bankingSystem.managecustomer;

import java.util.List;

import com.maven.learn.project.bankingSystem.datalayer.BankingDataBase;
import com.maven.learn.project.bankingSystem.model.Customer;
import com.maven.learn.project.bankingSystem.model.Validation;
public class ManageCustomerModel 
{
	private  ManageCustomerView customerView;
	
	ManageCustomerModel(ManageCustomerView customerView)
	{
		this.customerView=customerView;
	}
	
	public void setCustomer(Customer customer) {
		Validation valid = new Validation();
		boolean validation = valid.validEmail(customer.getEmail()) && valid.validName(customer.getCustomerName())
				&& valid.validPhoneNo(customer.getPhoneNumber());
		if (validation) {
			boolean stat = BankingDataBase.createInstance().insertCustomers(customer);
			if (stat)
				customerView.onSuccess();
			else
				customerView.alert("\nCandidate already present Enter new One\n");
		} else {
			customerView.alert("\nEnter Correct and Valid details\n");
		}
	}
	public List<Customer> getAllCustomer() {
		return BankingDataBase.createInstance().getAllCustomers();
	}

	// for seacrhing candidates
	public Customer searchCustomer(String email) {
		List<Customer> custList = BankingDataBase.createInstance().getAllCustomers();
		if (!custList.isEmpty()) {
			for (Customer cust : custList) {
				if (cust.getEmail().equals(email)) {
					return cust;
				}
			}
		}
		return null;
	}
	public boolean deleteCustomer(String email) {
		List<Customer> arr = BankingDataBase.createInstance().getAllCustomers();
		for (Customer cust : arr) {
			if (cust.getEmail().equals(email)) {
				return BankingDataBase.createInstance().removeCustomer(cust);

			}
		}
		return false;

	}
}
