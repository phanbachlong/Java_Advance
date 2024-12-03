package com.vti.entity;

import com.vti.entity.Position.PositionName;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {

    @Override
    public String convertToDatabaseColumn(PositionName positionName) {
        if (positionName == null) {
            return null;
        }
        return positionName.getPositionNameItem();
    }

    @Override
    public PositionName convertToEntityAttribute(String sqlPositionName) {
        if (sqlPositionName == null) {
            return null;
        }
        return Position.PositionName.toEnum(sqlPositionName);
    }

}
