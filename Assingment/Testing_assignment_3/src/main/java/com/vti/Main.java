package com.vti;

import java.util.List;

import com.vti.entity.*;

import com.vti.repository.*;

public class Main {
    public static void main(String[] args) {
        GroupAccountRepository groupAccountRepository = new GroupAccountRepository();

        List<GroupAccount> groupAccounts = groupAccountRepository.getAllGroupAccounts();
        for (GroupAccount groupAccount : groupAccounts) {
            System.out.println(groupAccount);
        }
    }
}