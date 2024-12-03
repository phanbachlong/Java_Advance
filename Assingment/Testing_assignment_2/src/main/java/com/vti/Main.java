package com.vti;

import com.vti.utils.ScannerUtils;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out
                    .println("1. Department\n2. Position\n3. Salary\n4. Account\n5. Group\n6. TypeQuestion\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon table: ");
            switch (i) {
                case 1:
                    DepartmentFE.menuDepartment();
                    break;
                case 2:
                    PositionFE.menuPosition();
                    break;
                case 3:
                    SalaryFE.menuSalary();
                    break;
                case 4:
                    AccountFE.menuAccount();
                    break;
                case 5:
                    GroupFE.menuGroup();
                    break;
                case 6:
                    TypeQuestionFE.menuTypeQuestion();
                    break;
                case 7:
                    CategoryQuestionFE.menuCategory();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}