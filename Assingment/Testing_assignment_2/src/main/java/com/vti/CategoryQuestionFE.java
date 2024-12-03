package com.vti;

import java.util.List;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRepository;
import com.vti.utils.ScannerUtils;

public class CategoryQuestionFE {

    private static CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();

    public static void getAllCategoryQuestions() {
        List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.getAllCategoryQuestions();

        for (CategoryQuestion categoryQuestion : categoryQuestions) {
            System.out.println(categoryQuestion);
        }
    }

    public static void createCategoryQuestion() {
        CategoryQuestion categoryQuestion = new CategoryQuestion();
        categoryQuestion.setCategoryName("ABC");
        categoryQuestionRepository.createCategoryQuestion(categoryQuestion);
    }

    public static void updateCategoryQuestion() {
        CategoryQuestion categoryQuestion = new CategoryQuestion((short) 11, "Math");
        categoryQuestionRepository.updateCategoryQuestion(categoryQuestion);
    }

    public static void softDeleteCategory() {
        categoryQuestionRepository.softDeleteCategory((short) 11);
    }

    public static void restoreCategory() {
        categoryQuestionRepository.restoreCategory((short) 11);
    }

    public static void menuCategory() {
        while (true) {
            System.out.println("Chon chuc nang cua category question: ");
            System.out.println("1. Hien danh sach\n2. Tao moi\n3. Cap nhat\n4. Xoa\n5. Khoi phuc\n0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 | 2 | 3 | 4 | 5 :");
            switch (i) {
                case 1:
                    getAllCategoryQuestions();
                    break;
                case 2:
                    createCategoryQuestion();
                    break;
                case 3:
                    updateCategoryQuestion();
                    break;
                case 4:
                    softDeleteCategory();
                    break;
                case 5:
                    restoreCategory();
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
