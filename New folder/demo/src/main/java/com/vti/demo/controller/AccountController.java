package com.vti.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.AccountDTO;
import com.vti.demo.entity.Account;
import com.vti.demo.form.AccountFilterFrom;
import com.vti.demo.service.IAccountService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    // @GetMapping()
    // public List<AccountDTO> getAllAccounts() {
    // List<Account> accounts = accountService.getAllAccounts();

    // List<AccountDTO> accountDTOs = accounts.stream().map(account ->
    // modelMapper.map(account, AccountDTO.class))
    // .collect(Collectors.toList());

    // return accountDTOs;
    // }

    @GetMapping
    public Page<AccountDTO> getAllAccounts(Pageable pageable,
            @RequestParam(value = "search", required = false) String search, AccountFilterFrom accountFilterFrom) {
        Page<Account> pageAccounts = accountService.getAllAccounts(pageable, search, accountFilterFrom);

        Page<AccountDTO> pageAccountDTOs = pageAccounts
                .map(pageAccount -> modelMapper.map(pageAccount, AccountDTO.class));

        return pageAccountDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") int accountID) {
        try {
            Account account = accountService.getAccountByID(accountID);

            AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

            return ResponseEntity.status(HttpStatus.FOUND).body(accountDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
