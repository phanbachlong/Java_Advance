package com.vti;

import java.util.List;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;
import com.vti.utils.ScannerUtils;

public class PositionFE {

    private static PositionRepository positionRepository = new PositionRepository();

    public static void getAllPositions() {
        List<Position> positions = positionRepository.getAllPositions();

        for (Position position : positions) {
            System.out.println(position);
        }
    }

    public static void softDeletePosition() {
        positionRepository.softDeletePosition((short) 2);
    }

    public static void restorePosition() {
        positionRepository.restorePosition((short) 2);
    }

    public static void menuPosition() {
        while (true) {
            System.out.println("Chon chuc nang cua position: ");
            System.out.println("1. Hien danh sach\n2. Xoa\n3. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 :");
            switch (i) {
                case 1:
                    getAllPositions();
                    break;
                case 2:
                    softDeletePosition();
                    break;
                case 3:
                    restorePosition();
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
