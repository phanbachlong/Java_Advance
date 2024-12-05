package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`TypeQuestion`")
public class TypeQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TypeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short typeQuestionID;

    @Column(name = "TypeName")
    @Enumerated(EnumType.ORDINAL)
    private TypeName typeName;

    @OneToMany(mappedBy = "typeQuestion")
    private List<Question> questions;

    private enum TypeName {
        ESSAY, MULTIPLE_CHOICE;
    }

    public TypeQuestion() {
    }

    public TypeQuestion(TypeName typeName) {
        this.typeName = typeName;
    }

    public TypeQuestion(short typeQuestionID, TypeName typeName) {
        this.typeQuestionID = typeQuestionID;
        this.typeName = typeName;
    }

    public short getTypeQuestionID() {
        return typeQuestionID;
    }

    public void setTypeQuestionID(short typeQuestionID) {
        this.typeQuestionID = typeQuestionID;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return String.format("TypeQuestion [typeQuestionID = %s, typeName = %s]", typeQuestionID, typeName);
    }

}
