package com.vti.utils;

import java.util.Scanner;

public class ScannerUtills {

    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                int i = Integer.parseInt(sc.nextLine());
                if (i <= 0) {
                    System.out.println("Vui long nhap vao so lon hon 0");
                } else {
                    return i;
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap vao 1 so nguyen duong");
            }
        }
    }

    public static void waiting() {
        System.out.println("Nhap bat ki de tiep tuc");
        String s = sc.nextLine();
    }
}
