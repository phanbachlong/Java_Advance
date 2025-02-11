package com.vti.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.demo.entity.Account;
import com.vti.demo.form.AccountFilterFrom;

public interface IAccountService {

    Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterFrom accountFilterFrom);

    Account getAccountByID(int accountID);
}
