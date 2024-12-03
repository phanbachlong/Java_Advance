package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.ScannerUtils;

public class DepartmentFE {
    private static DepartmentRepository departmentRepository = new DepartmentRepository();

    public static void getAllDepartments() {
        List<Department> departments = departmentRepository.getAllDepartments();

        for (Department department : departments) {
            System.out.println(department);
        }
    }

    public static void createDepartment() {
        Department department = new Department("Waiting Room");
        departmentRepository.createDepartment(department);
    }

    public static void updateDepartment() {
        Department department = new Department((short) 11, "Training Room");
        departmentRepository.updateDepartment(department);
    }

    public static void softDeleteDepartment() {
        departmentRepository.softDeleteDepartment((short) 1);
    }

    public static void restoreDepartment() {
        departmentRepository.restoreDepartment((short) 1);
    }

    public static void menuDepartment() {
        while (true) {
            System.out.println("Chon chuc nang cua department: ");
            System.out.println("1. Hien danh sach\n2. Tao moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 | 4 | 5 :");
            switch (i) {
                case 1:
                    getAllDepartments();
                    break;
                case 2:
                    createDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    softDeleteDepartment();
                    break;
                case 5:
                    restoreDepartment();
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
