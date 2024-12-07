package com.vti;

import java.util.List;

import com.vti.entity.*;

import com.vti.repository.*;
import com.vti.utils.ScannerUtils;

public class Main {
    public static void main(String[] args) {
        detailDepartmentCRUD();
    }

    public static void addressCRUD() {
        AddressRepository addressRepository = new AddressRepository();

        while (true) {
            System.out.println("==========ADDRESS==========");
            System.out.println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chuc nang tuon ung: ");
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
            System.out.println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chuc nang tuon ung: ");
            switch (i) {
                case 1:
                    // Get all department
                    List<Department> departments = departmentRepository.getAllDepartments();

                    for (Department department : departments) {
                        System.out.println(department);
                    }
                    break;
                case 2:
                    // Create address
                    Department department = new Department("Waiting Room");
                    departmentRepository.createDepartment(department);
                    break;

                case 3:
                    // Update address
                    break;

                case 0:
                    return;
                default:
                    break;
            }
            ScannerUtils.waiting();
        }
    }

    public static void detailDepartmentCRUD() {
        DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        AddressRepository addressRepository = new AddressRepository();

        while (true) {
            System.out.println("==========DETAIL DEPARTMENT==========");
            System.out.println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chuc nang tuon ung: ");
            switch (i) {
                case 1:
                    // Get all detail department
                    List<DetailDepartment> detailDepartments = detailDepartmentRepository.getAllDetailDepartments();
                    for (DetailDepartment detailDepartment : detailDepartments) {
                        System.out.println(detailDepartment);
                    }
                    break;
                case 2:
                    // Create detail department
                    Address address = addressRepository.getAddressByID((short) 11);
                    Department department = departmentRepository.getDepartmentByID((short) 11);

                    System.out.println(address);
                    DetailDepartment detailDepartment = new DetailDepartment(department, address, (short) 0);
                    detailDepartmentRepository.createDetailDepartment(detailDepartment);
                    break;

                case 3:
                    // Update address
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