package com.maven.learn.project.bankingSystem.datalayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.maven.learn.project.bankingSystem.login.LoginView;
import com.maven.learn.project.bankingSystem.model.Bank;
import com.maven.learn.project.bankingSystem.model.Customer;

public class BankingDataBase {
	private static BankingDataBase bankingDb;
	private List<Customer> customerList = new ArrayList<>();
	private String bankFile = "Bank.json";
	private String customerFile = "customers.json";

	BankingDataBase() {
	}

	// -----
	public Map<String, Double> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Double> accounts) {
		this.accounts = accounts;
	}

	private Map<String, Double> accounts;

	// ---

	public static BankingDataBase createInstance() {
		if (bankingDb == null) {
			bankingDb = new BankingDataBase();
		}
		return bankingDb;
	}

	public void insertBank(Bank bank) {
		try {
			File file = new File(bankFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectMapper companyObj = new ObjectMapper();
			companyObj.enable(SerializationFeature.INDENT_OUTPUT);
			companyObj.writeValue(file, bank);
		} catch (Exception e) {
			new LoginView().showAlert("Error Occured in adding Bank");
		}
	}

	public Bank getBank() {
		ObjectMapper companyObj = new ObjectMapper();
		try {

			return companyObj.readValue(new File(bankFile), Bank.class);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean insertCustomers(Customer customer) {
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			File fileCandidate = new File(customerFile);
			if (!fileCandidate.exists())
				fileCandidate.createNewFile();
			if (fileCandidate.length() > 0) {// verifying that the length of the file is not empty
				customerList = candidateObj.readValue(new File(customerFile), new TypeReference<List<Customer>>() {
				});
				for (Customer cand : customerList) {
					if (customer.getEmail().equals(cand.getEmail()))
						return false;
				}
				customerList.add(customer);
				candidateObj.writeValue(fileCandidate, customerList);
				return true;
			} else { 

				customerList.add(customer);
				candidateObj.writeValue(fileCandidate, customerList);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public List<Customer> getAllCustomers() {
		ObjectMapper customerObj = new ObjectMapper();
		try {
			return customerList = customerObj.readValue(new File(customerFile), new TypeReference<List<Customer>>() {
			});
		} catch (Exception e) {
			return null;
		}
	}

	public boolean removeCustomer(Customer cust) {

		ObjectMapper customerObj = new ObjectMapper();
		try {
			File fileCustomer = new File(customerFile);
			if (customerList.remove(cust)) {
				customerObj.writeValue(fileCustomer, customerList);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean depositeMoney(int accNo, double money) {
		ObjectMapper customerObj = new ObjectMapper();
		try {
			File fileCustomer = new File(customerFile);
			customerList = getAllCustomers();
			for (Customer c : customerList) {
				if (c.getCustomerId() == accNo) {

					c.setMoney(c.getMoney()+money);
					customerObj.writeValue(fileCustomer, customerList);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean withdrawMoney(int accNo, double withdrawAmount) {
		ObjectMapper customerObj = new ObjectMapper();
		try {
			File fileCustomer = new File(customerFile);
			customerList = getAllCustomers();
			for (Customer c : customerList) {
				if (c.getCustomerId() == accNo) {
					if (c.getMoney() >= withdrawAmount) {
						c.setMoney(c.getMoney() - withdrawAmount);
						customerObj.writeValue(fileCustomer, customerList);
						return true;
					} else
						return false;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public double checkBalance(int accNo) {
		customerList = getAllCustomers();
		for (Customer cust : customerList) {
			if (accNo == cust.getCustomerId()) {
				return cust.getMoney();
			}
		}
		return 0;
	}

	public boolean isPresent(int accNo) {
		customerList = getAllCustomers();
		for (Customer cust : customerList) {
			if (accNo == cust.getCustomerId()) {
				return true;
			}
		}
		return false;
	}
}
