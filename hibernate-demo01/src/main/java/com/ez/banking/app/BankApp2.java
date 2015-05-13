package com.ez.banking.app;

import java.util.Date;

import com.ez.banking.entity.Address;
import com.ez.banking.entity.Bank;

public class BankApp2 extends BaseApp {

	@Override
	public void execute() {
		Bank bank = new Bank();
		bank.setName("TD");
		bank.setInternational(true);
		bank.setLastUpdatedDate(new Date());
		bank.setLastUpdatedBy("Kevin");
		bank.setCreatedDate(new Date());
		bank.setCreatedBy("John");

		Address address = new Address();
		address.setAddressLine1("123 abc Street");
		address.setAddressLine2("QC Canada");
		address.setCity("Montreal");
		address.setState("QC");
		address.setZipCode("1A1 W2W");
		
		bank.setAddress(address);

		bank.getContacts().add("John Doe");
		bank.getContacts().add("Foo Bar");
		
		session.save(bank);
		
	}
	
	public static void main(String[] args) {
		new BankApp2().runApp();
	}
}
