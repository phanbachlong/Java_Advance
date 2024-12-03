package com.vti.entity;

import com.vti.entity.Salary.SalaryName;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SalarySalaryNameConverter implements AttributeConverter<Salary.SalaryName, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SalaryName salaryName) {
        if (salaryName == null) {
            return 0;
        }
        return salaryName.getSalaryValue();
    }

    @Override
    public SalaryName convertToEntityAttribute(Integer sqlSalaryName) {
        if (sqlSalaryName == null) {
            return null;
        }
        return Salary.SalaryName.toEnum(sqlSalaryName);
    }

}
