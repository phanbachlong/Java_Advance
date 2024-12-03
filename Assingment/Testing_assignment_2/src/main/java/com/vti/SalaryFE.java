package com.vti;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.entity.Salary.SalaryName;
import com.vti.repository.SalaryRepository;
import com.vti.utils.ScannerUtils;

public class SalaryFE {

    private static SalaryRepository salaryRepository = new SalaryRepository();

    public static void getAllSalaries() {
        List<Salary> salaries = salaryRepository.getAllSalaries();
        for (Salary salary : salaries) {
            System.out.println(salary);
        }
    }

    public static void softDeleteSalary() {
        salaryRepository.softDeleteSalary((short) 3);
    }

    public static void restoreSalary() {
        salaryRepository.restorePosition((short) 3);
    }

    public static void menuSalary() {
        while (true) {
            System.out.println("Chon chuc nang cua salary: ");
            System.out.println("1. Hien danh sach\n2. Xoa\n3. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 :");
            switch (i) {
                case 1:
                    getAllSalaries();
                    break;
                case 2:
                    softDeleteSalary();
                    break;
                case 3:
                    restoreSalary();
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
