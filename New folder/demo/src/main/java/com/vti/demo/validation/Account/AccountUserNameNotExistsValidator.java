package com.vti.demo.validation.Account;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.demo.service.IAccountService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountUserNameNotExistsValidator implements ConstraintValidator<AccountUserNameNotExists, String> {

    @Autowired
    private IAccountService accountService;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(userName)) {
            return true;
        }
        return !accountService.isAccountExistsByUserName(userName);
    }
}
