package com.pkrma.transactions.dao;

import com.pkrma.transactions.model.Account;

public interface AccountDao {
	void createAccount(Account account);
	void updateAccount(Account account);
	Double getAmount(Account account);
}
