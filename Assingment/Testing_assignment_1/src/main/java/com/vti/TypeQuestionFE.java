package com.vti;

import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;
import com.vti.repository.TypeQuestionRepository;

public class TypeQuestionFE {

    private static TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

    public static void getAllTypeQuestions() {
        List<TypeQuestion> typeQuestions = typeQuestionRepository.getAllTypeQuestions();
        for (TypeQuestion typeQuestion : typeQuestions) {
            System.out.println(typeQuestion);
        }
    }

    public static void createTypeQuestion() {
        TypeQuestion typeQuestion = new TypeQuestion();
        typeQuestion.setTypeName(TypeName.ESSAY);

        typeQuestionRepository.createTypeQuestion(typeQuestion);
    }
}
