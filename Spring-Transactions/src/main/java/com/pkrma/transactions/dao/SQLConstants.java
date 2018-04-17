package com.pkrma.transactions.dao;

public interface SQLConstants {

	String CREATE_ACCOUNT = "INSERT INTO cust_account(account_number,acount_holder,amount)"
			+ " VALUES(:accountNumber,:accountHolder,:amount)";

	String UPDATE_ACCOUNT = "UPDATE cust_account SET amount =:amount WHERE acount_number =:accountNumber";

	String GET_AMOUNT = "SELECT amount FROM cust_account where account_number =:accountNumber";
}
