package com.vti.entity;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.vti.repository.ExamRepository;

public class ExamCodeGenerator implements IdentifierGenerator {

    private ExamRepository examRepository;

    public ExamCodeGenerator() {
        examRepository = new ExamRepository();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Exam exam = (Exam) object;
        short duration = exam.getDuration();
        int count = examRepository.getCountByDuration(duration);

        if (duration > 0 && duration < 90) {
            return "S" + "-" + (count + 1);
        } else if (duration >= 90 && duration < 180) {
            return "M" + "-" + (count + 1);
        } else {
            return "L" + "-" + (count + 1);
        }
    }

}
