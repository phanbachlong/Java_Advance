package com.vti.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Account;
import com.vti.demo.form.AccountFilterFrom;
import com.vti.demo.repository.IAccountRepository;
import com.vti.demo.specification.AccountSpecification;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    // @Override
    // public List<Account> getAllAccounts() {
    // return accountRepository.findAll();
    // }

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterFrom accountFilterFrom) {
        Specification<Account> where = AccountSpecification.buildWhere(search, accountFilterFrom);
        return accountRepository.findAll(where, pageable);
    }

    @Override
    public Account getAccountByID(int accountID) {
        if (accountID <= 0) {
            throw new IllegalArgumentException("Account ID must be positive: " + accountID);
        }

        Account account = accountRepository.findById(accountID)
                .orElseThrow(() -> new EntityNotFoundException("Account not exists with ID: " + accountID));
        return account;
    }
}
