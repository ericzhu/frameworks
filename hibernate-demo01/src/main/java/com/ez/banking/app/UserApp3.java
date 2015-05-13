package com.ez.banking.app;

import java.util.Date;

import com.ez.banking.entity.Address;
import com.ez.banking.entity.User;

public class UserApp3 extends BaseApp {

	@Override
	public void execute() {
		User u = new User();
		u.setFirstName("Eric");
		u.setLastName("Zhu");
		u.setBirthDate(new Date());
		u.setLastUpdatedDate(new Date());
		u.setLastUpdatedBy("Eric");
		u.setCreatedDate(new Date());
		u.setCreatedBy("Eric");
		u.setEmailAddress("eric@eric.com");
		
		Address address = new Address();
		address.setAddressLine1("123 abc Street");
		address.setAddressLine2("QC Canada");
		address.setCity("Montreal");
		address.setState("QC");
		address.setZipCode("1A1 W2W");
		
		u.setAddress(address);
		
		
		Address office1 = new Address();
		office1.setAddressLine1("123 abc Street");
		office1.setAddressLine2("QC Canada");
		office1.setCity("Montreal");
		office1.setState("QC");
		office1.setZipCode("1A1 W2W");
		
		Address office2 = new Address();
		office2.setAddressLine1("123 abc Street");
		office2.setAddressLine2("QC Canada");
		office2.setCity("Montreal");
		office2.setState("QC");
		office2.setZipCode("1A1 W2W");
		
		u.getOffices().add(office1);
		u.getOffices().add(office2);
		
		session.save(u);
	}
	
	public static void main(String[] args) {
		new UserApp3().runApp();
	}

}
