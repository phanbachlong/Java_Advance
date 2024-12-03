package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                int i = Integer.parseInt(sc.nextLine());
                if (i < 0) {
                    System.out.println("Nhap so lon hon 0: ");
                } else {
                    return i;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap dung dinh dang so nguyen: ");
            }
        }

    }

    public static void waiting() {
        System.out.println("Nhap bat ky de tiep tuc");
        String s = sc.nextLine();
    }
}
