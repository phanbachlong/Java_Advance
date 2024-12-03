package com.vti;

import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;
import com.vti.repository.TypeQuestionRepository;
import com.vti.utils.ScannerUtils;

public class TypeQuestionFE {

    private static TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

    public static void getAllTypeQuestions() {
        List<TypeQuestion> typeQuestions = typeQuestionRepository.getAllTypeQuestions();
        for (TypeQuestion typeQuestion : typeQuestions) {
            System.out.println(typeQuestion);
        }
    }

    // public static void createTypeQuestion() {
    // TypeQuestion typeQuestion = new TypeQuestion();
    // typeQuestion.setTypeName(TypeName.ESSAY);

    // typeQuestionRepository.createTypeQuestion(typeQuestion);
    // }

    public static void menuTypeQuestion() {
        while (true) {
            System.out.println("Chon chuc nang cua type question: ");
            System.out.println("1. Hien danh sach\nn0. Thoat");
            int i = ScannerUtils.inputInt("Chon 0 | 1 :");
            switch (i) {
                case 1:
                    getAllTypeQuestions();
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
