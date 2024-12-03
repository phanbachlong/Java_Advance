package com.vti;

import java.time.LocalDateTime;
import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;
import com.vti.utils.ScannerUtils;

public class GroupFE {
    private static GroupRepository groupRepository = new GroupRepository();

    public static void getAllGroups() {
        List<Group> groups = groupRepository.getAllGroups();
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    public static void createGroup() {
        String groupName = "VTI IT";
        boolean isGroupNameExist = groupRepository.isGroupExistsByName(groupName);
        if (isGroupNameExist == false) {
            Group group = new Group(groupName, LocalDateTime.now());
            groupRepository.createGroup(group);
        }
    }

    public static void getGroupByID() {
        Group group = groupRepository.getGroupByID((short) 11);
        System.out.println(group);

    }

    public static void getGroupByName() {
        Group group = groupRepository.getGroupByName("VTI IT");
        System.out.println(group);
    }

    public static void updateGroup() {
        Group group = new Group((short) 11, "VTI IT Training", LocalDateTime.now());
        groupRepository.updateGroup(group);
    }

    public static void deleteGroup() {
        groupRepository.deleteGroup((short) 11);
    }

    public static void softDeleteGroup() {
        groupRepository.softDeleteGroup((short) 5);
    }

    public static void restoreGroup() {
        groupRepository.restoreGroup((short) 5);
    }

    public static void menuGroup() {
        while (true) {
            System.out.println("Chon chuc nang cua group: ");
            System.out.println(
                    "1. Hien danh sach\n2. Tao moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n6. Xoa hoan toan\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 | 4 | 5 | 6 :");
            switch (i) {
                case 1:
                    getAllGroups();
                    break;
                case 2:
                    createGroup();
                    break;
                case 3:
                    updateGroup();
                    break;
                case 4:
                    softDeleteGroup();
                    break;
                case 5:
                    restoreGroup();
                    break;
                case 6:
                    deleteGroup();
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
