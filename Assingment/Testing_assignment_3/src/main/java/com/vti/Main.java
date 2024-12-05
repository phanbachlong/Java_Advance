package com.vti;

import java.util.List;

import com.vti.entity.*;

import com.vti.repository.*;
import com.vti.utils.ScannerUtills;

public class Main {
    public static void main(String[] args) {
        addressCRUD();
    }

    public static void addressCRUD() {
        AddressRepository addressRepository = new AddressRepository();

        while (true) {
            System.out.println("==========ADDRESS==========");
            System.out.println("1. Hien thi\n2. Them moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtills.inputInt("Nhap vao 0 | 1 | 2 | 3 | 4 | 5 de chon chu nang tuon ung: ");
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
            ScannerUtills.waiting();
        }
    }

    public void departmentCRUD() {

    }
}