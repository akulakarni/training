package com.pkrma.transactions.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrma.transactions.model.Account;
import com.pkrma.transactions.service.AccountService;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring.xml" });

		AccountService accountservice = (AccountService) appContext.getBean("accountServiceImpl");

		// create account
		Account account = new Account();
		account.setAccountNumber("101010101010");
		account.setAccountHolder("Customer-Prokarma");
		account.setAmount(new Double(20000));
		try {
			accountservice.createAccount(account);
		} catch (Exception e) {
			System.out.println("Exception while creating account." + e);
		}

		// get Balance amount
		account = new Account();
		account.setAccountHolder("101010101010");
		try {
			accountservice.getBalanceAmount(account);
		} catch (Exception e) {
			System.out.println("Exception while getting balance amount." + e);
		}

		// deposit amount
		account = new Account();
		account.setAccountHolder("101010101010");
		account.setAmount(new Double(3000));
		try {
			accountservice.depositFunds(account);
		} catch (Exception e) {
			System.out.println("Exception while deposit." + e);
		}

		// withdraw amount
		account = new Account();
		account.setAccountHolder("101010101010");
		account.setAmount(new Double(6000));
		try {
			accountservice.withDrawFunds(account);
		} catch (Exception e) {
			System.out.println("Exception while withdraw." + e);
		}

		// transfer amount
		Account account1 = new Account();
		account1.setAccountNumber("101010101010");

		Account account2 = new Account();
		account2.setAccountNumber("202020202020");
		try {
			accountservice.transferFunds(account1, account2, new Double(10000));
		} catch (Exception e) {
			System.out.println("Exception while transfering the funds." + e);
		}

	}
}
