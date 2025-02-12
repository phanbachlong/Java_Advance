package com.vti.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.demo.entity.Account;
import com.vti.demo.form.Account.AccountFilterFrom;
import com.vti.demo.form.Account.CreatingAccountForm;

public interface IAccountService {

    Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterFrom accountFilterFrom);

    Account getAccountByID(int accountID);

    void createAccount(CreatingAccountForm creatingAccountForm);
}
