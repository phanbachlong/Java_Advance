package com.vti;

import java.util.List;

import com.vti.entity.*;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Salary.SalaryName;
import com.vti.repository.*;
import com.vti.utils.ScannerUtils;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Hien thi\n2. Them moi\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap table tuon ung: ");
            switch (i) {
                case 1:
                    addressCRUD();
                    break;

                case 2:
                    departmentCRUD();
                    break;

                case 0:
                    return;

                default:
                    break;
            }
        }

    }

    public static void addressCRUD() {
        AddressRepository addressRepository = new AddressRepository();

        while (true) {
            System.out.println("==========ADDRESS==========");
            System.out.println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chu nang tuon ung: ");
            switch (i) {
                case 1:
                    // Get all address
                    List<Address> addresses = addressRepository.getAllAddresses();

                    for (Address address : addresses) {
                        System.out.println(address);
                    }
                    break;

                case 2:
                    // Create address
                    Address address = new Address("P909");
                    addressRepository.createAddress(address);
                    break;

                case 3:
                    // Update address
                    Address upAddress = new Address((short) 11, "P999");
                    addressRepository.updateAddress(upAddress);
                    break;

                case 4:
                    // Soft delete
                    addressRepository.softDeletedAddress((short) 1);
                    break;

                case 5:
                    addressRepository.restoreAddress((short) 1);
                    break;

                case 6:
                    // Delete address
                    addressRepository.deleteAddress((short) 11);
                    break;

                case 0:
                    return;

                default:
                    break;
            }
            ScannerUtils.waiting();
        }
    }

    public static void departmentCRUD() {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        while (true) {
            System.out.println("==========DEPARTMENT==========");
            System.out
                    .println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n6. Xoa hoa toan\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chu nang tuon ung: ");
            switch (i) {
                case 1:
                    // Get all department
                    List<Department> departments = departmentRepository.getAllDepartments();
                    for (Department department : departments) {
                        System.out.println(department);
                    }
                    break;

                case 2:
                    // Create department
                    Department department = new Department("Waiting Room");
                    departmentRepository.createDepartment(department);
                    break;

                case 3:
                    // Update department
                    int departmentID = ScannerUtils.inputInt("Nhap vao ID cua department muon cap nhat: ");
                    String departmentName = ScannerUtils.inputString("Nhap vao Name cua department muon cap nhat: ");

                    Department updDepartment = new Department((short) departmentID, departmentName);
                    boolean isDepartmentName = departmentRepository.getDepartmentForUpdate(updDepartment);

                    while (isDepartmentName) {
                        departmentName = ScannerUtils.inputString("Nhap lai Name cua department: ");
                        updDepartment = new Department((short) departmentID, departmentName);
                        isDepartmentName = departmentRepository.getDepartmentForUpdate(updDepartment);
                    }

                    departmentRepository.updateDepartment(updDepartment);

                    break;

                case 4:
                    // Soft delete
                    departmentRepository.softDeleteDepartment((short) 1);
                    break;

                case 5:
                    // restore
                    departmentRepository.restoreDepartment((short) 1);
                    break;

                case 6:
                    // Delete department
                    departmentRepository.deleteDepartment((short) 1);
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