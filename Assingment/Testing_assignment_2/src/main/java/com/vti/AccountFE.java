package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.utils.ScannerUtils;

public class AccountFE {
    private static AccountRepository accountRepository = new AccountRepository();

    public static void getAllAccount() {
        List<Account> accounts = accountRepository.getAllAccounts();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static void createAccount() {
        Account account = new Account("1phantrongvinh98@gmail.com", "phtrvinh", "Phan Trong", "Vinh");

        accountRepository.createAccount(account);
    }

    public static void updateAccount() {
        Account account = new Account((short) 11, "phantrongvinh98@gmail.com", "phtrvinh", "Phan Bach", "Long");

        accountRepository.updateAccount(account);
    }

    public static void softDeleteAccount() {
        accountRepository.softDeleteAccount((short) 11);
    }

    public static void restoreAccount() {
        accountRepository.restoreAccount((short) 11);
    }

    public static void deleteAccount() {
        accountRepository.deleteAccount((short) 11);
    }

    public static void menuAccount() {
        while (true) {
            System.out.println("Chon chuc nang cua account: ");
            System.out.println(
                    "1. Hien danh sach\n2. Tao moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n6. Xoa hoan toan\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 | 4 | 5 | 6 :");
            switch (i) {
                case 1:
                    getAllAccount();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    softDeleteAccount();
                    break;
                case 5:
                    restoreAccount();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
            ScannerUtils.waiting();
        }
    }
}
