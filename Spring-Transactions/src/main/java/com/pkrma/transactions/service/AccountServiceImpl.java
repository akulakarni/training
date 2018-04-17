package com.pkrma.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pkrma.transactions.dao.AccountDao;
import com.pkrma.transactions.model.Account;
import com.pkrma.transactions.util.InSufficientFundException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void createAccount(Account account) throws Exception {
		try {
			accountDao.createAccount(account);
		} catch (Exception e) {
			System.out.println("Exception occured while creating an account." + e);
			throw e;
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void transferFunds(Account account1, Account account2, Double amount) throws Exception {
		try {
			double account1Balance = accountDao.getAmount(account1);
			if (amount > account1Balance) {
				throw new InSufficientFundException(
						String.format("Current balance %d is less than requested amount %d", account1Balance, amount));
			}
			double updatedAccount1Amount = account1Balance - amount;
			account1.setAmount(updatedAccount1Amount);
			accountDao.updateAccount(account1);
			
			double account2Balance = accountDao.getAmount(account2);
			double updatedAccount2Amount = account2Balance + amount;
			account2.setAmount(updatedAccount2Amount);
			accountDao.updateAccount(account2);
		} catch (Exception e) {
			System.out.println("Exception occured while transfering funds." + e);
			throw e;
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Double withDrawFunds(Account account) throws Exception {
		double balance = 0;
		double requiredAmount = account.getAmount();
		try {
			balance = accountDao.getAmount(account);
			if (requiredAmount > balance) {
				throw new InSufficientFundException(String.format("Current balance %d is less than requested amount %d",
						balance, account.getAmount()));
			}
			double amount = balance - requiredAmount;
			account.setAmount(amount);
			accountDao.updateAccount(account);
		} catch (Exception e) {
			System.out.println("Exception occured while withDraw Funds from account." + e);
			throw e;
		}
		return requiredAmount;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void depositFunds(Account account) throws Exception {
		try {
			double accountBalance = accountDao.getAmount(account);
			double updatedAmount = accountBalance + account.getAmount();
			account.setAmount(updatedAmount);
			accountDao.updateAccount(account);
		} catch (Exception e) {
			System.out.println("Exception occured while creating an account." + e);
			throw e;
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Double getBalanceAmount(Account account) throws Exception {
		double balance = 0;
		try {
			balance = accountDao.getAmount(account);
		} catch (Exception e) {
			System.out.println("Exception occured while getting balance." + e);
			throw e;
		}
		return balance;
	}

}
