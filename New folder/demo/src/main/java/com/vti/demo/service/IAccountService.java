package com.vti.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.demo.entity.Account;
import com.vti.demo.form.Account.AccountFilterFrom;
import com.vti.demo.form.Account.CreatingAccountForm;
import com.vti.demo.form.Account.UpdatingAccountForm;

public interface IAccountService extends UserDetailsService {

    Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterFrom accountFilterFrom);

    Account getAccountByID(int accountID);

    void createAccount(CreatingAccountForm creatingAccountForm);

    void updateAccount(UpdatingAccountForm updatingAccountForm);

    void deleteAccounts(List<Integer> accountIDs);

    Account getAccountByUserName(String userName);

    boolean isAccountExistsByUserName(String userName);

    boolean isAccountExistsByID(int accountID);

}
