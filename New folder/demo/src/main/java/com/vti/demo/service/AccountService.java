package com.vti.demo.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Account;
import com.vti.demo.form.Account.AccountFilterFrom;
import com.vti.demo.form.Account.CreatingAccountForm;
import com.vti.demo.form.Account.UpdatingAccountForm;
import com.vti.demo.repository.IAccountRepository;
import com.vti.demo.specification.AccountSpecification;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, String search,
            AccountFilterFrom accountFilterFrom) {
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

    @Override
    public void createAccount(CreatingAccountForm creatingAccountForm) {
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class,
                Account.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getAccountID());
                }
            });
        }
        creatingAccountForm.setPassword(passwordEncoder.encode(creatingAccountForm.getPassword()));
        Account account = modelMapper.map(creatingAccountForm, Account.class);
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(UpdatingAccountForm updatingAccountForm) {
        // updatingAccountForm.setPassword(passwordEncoder.encode("123456"));
        Account account = modelMapper.map(updatingAccountForm, Account.class);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccounts(List<Integer> accountIDs) {
        accountRepository.deleteAllById(accountIDs);
    }

    @Override
    public boolean isAccountExistsByUserName(String userName) {
        return accountRepository.existsByUserName(userName);
    }

    @Override
    public boolean isAccountExistsByID(int accountID) {
        return accountRepository.existsById(accountID);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUserName(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(account.getUserName(), account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole().toString()));
    }

    @Override
    public Account getAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }
}