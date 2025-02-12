package com.vti.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.AccountDTO;
import com.vti.demo.entity.Account;
import com.vti.demo.form.Account.AccountFilterFrom;
import com.vti.demo.form.Account.CreatingAccountForm;
import com.vti.demo.form.Account.UpdatingAccountForm;
import com.vti.demo.service.IAccountService;
import com.vti.demo.validation.Account.AccountIDExists;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Validated
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<AccountDTO> getAllAccounts(Pageable pageable,
            @RequestParam(value = "search", required = false) String search, AccountFilterFrom accountFilterFrom) {
        Page<Account> pageAccounts = accountService.getAllAccounts(pageable, search, accountFilterFrom);

        Page<AccountDTO> pageAccountDTOs = pageAccounts
                .map(pageAccount -> modelMapper.map(pageAccount, AccountDTO.class));

        return pageAccountDTOs;
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountByID(@PathVariable(name = "id") int accountID) {
        Account account = accountService.getAccountByID(accountID);

        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        return accountDTO;
    }

    @PostMapping()
    public void createAccount(@RequestBody @Valid CreatingAccountForm creatingAccountForm) {
        accountService.createAccount(creatingAccountForm);
    }

    @PutMapping("/{id}")
    public void updateAccount(@AccountIDExists @PathVariable(value = "id") int accountID,
            @RequestBody @Valid UpdatingAccountForm updatingAccountForm) {
        updatingAccountForm.setAccountID(accountID);
        accountService.updateAccount(updatingAccountForm);
    }

    @DeleteMapping()
    public void deleteAccounts(@RequestBody List<Integer> accountIDs) {
        accountService.deleteAccounts(accountIDs);
    }

}
