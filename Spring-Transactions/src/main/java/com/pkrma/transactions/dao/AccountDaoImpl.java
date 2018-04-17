package com.pkrma.transactions.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pkrma.transactions.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void createAccount(Account account) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNumber", account.getAccountNumber());
		paramMap.put("accountHolder", account.getAccountHolder());
		paramMap.put("amount", account.getAmount());
		namedJdbcTemplate.update(SQLConstants.CREATE_ACCOUNT, paramMap);
	}

	public void updateAccount(Account account) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNumber", account.getAccountNumber());
		paramMap.put("amount", account.getAmount());
		namedJdbcTemplate.update(SQLConstants.UPDATE_ACCOUNT, paramMap);
	}

	public Double getAmount(Account account) {
		double amount = 0;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNumber", account.getAccountNumber());
		amount = namedJdbcTemplate.queryForObject(SQLConstants.GET_AMOUNT, paramMap, Double.class);

		return amount;
	}

}
