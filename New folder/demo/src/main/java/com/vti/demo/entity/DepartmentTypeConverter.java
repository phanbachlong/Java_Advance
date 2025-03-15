package com.vti.demo.entity;

import com.vti.demo.entity.Department.Type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentTypeConverter implements AttributeConverter<Department.Type, String> {

    @Override
    public String convertToDatabaseColumn(Type attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getTypeName();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Department.Type.toEnum(dbData);
    }
}
