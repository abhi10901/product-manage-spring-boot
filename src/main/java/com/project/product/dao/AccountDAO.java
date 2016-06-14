package com.project.product.dao;

import com.project.product.domain.Account;

public interface AccountDAO {

	public Account findAccountById(Long id);
	public Account storeAccount(Account account);
	public boolean removeAccountById(Long id);
}
