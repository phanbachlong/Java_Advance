package com.vti.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.DepartmentFilterForm;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecification {
    public static Specification<Department> buildWhere(String search, DepartmentFilterForm departmentFilterForm) {
        Specification<Department> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();

            DepartmentCustomSpecification departmentName = new DepartmentCustomSpecification("departmentName", search);
            where = Specification.where(departmentName);
        }
        return where;
    }
}

@RequiredArgsConstructor
class DepartmentCustomSpecification implements Specification<Department> {

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("departmentName")) {
            return criteriaBuilder.like(root.get("departmentName"), "%" + value.toString() + "%");
        }
        return null;
    }
}
