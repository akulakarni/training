package com.pkrma.transactions.service;

import com.pkrma.transactions.model.Account;

public interface AccountService {
	void createAccount(Account account) throws Exception;
	void transferFunds(Account account1,Account account2,Double amount) throws Exception;
	Double withDrawFunds(Account account) throws Exception;
	void depositFunds(Account account) throws Exception;
	Double getBalanceAmount(Account account) throws Exception;
}
