package com.vti.entity;

import com.vti.entity.Salary.SalaryName;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String> {

    @Override
    public String convertToDatabaseColumn(SalaryName salaryName) {
        if (salaryName == null) {
            return null;
        }
        return salaryName.getSalaryNameValue();
    }

    @Override
    public SalaryName convertToEntityAttribute(String sqlSalaryName) {
        if (sqlSalaryName == null) {
            return null;
        }
        return Salary.SalaryName.toEnum(sqlSalaryName);
    }

}
