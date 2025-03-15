package com.vti.demo.validation.Account;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.demo.service.IAccountService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountIDNotExistsValidator implements ConstraintValidator<AccountIDNotExists, Integer> {

    @Autowired
    private IAccountService accountService;

    @Override
    public boolean isValid(Integer accountID, ConstraintValidatorContext constraintValidatorContext) {
        if (accountID == null) {
            return true;
        }
        return accountService.isAccountExistsByID(accountID);
    }

}
