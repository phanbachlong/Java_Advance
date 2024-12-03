package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`TypeQuestion`")
public class TypeQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum TypeName {
        ESSAY, MULTIPLE_CHOICE;
    }

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short typeID;

    @Column(name = "TypeName")
    @Enumerated(EnumType.ORDINAL)
    private TypeName typeName;

    public TypeQuestion() {
    }

    public short getTypeID() {
        return typeID;
    }

    public void setTypeID(short typeID) {
        this.typeID = typeID;
    }

    public TypeName isTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion [typeID = " + typeID + ", typeName = " + typeName + "]";
    }
}
