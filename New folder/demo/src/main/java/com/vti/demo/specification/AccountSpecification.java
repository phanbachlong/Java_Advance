package com.vti.demo.specification;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.demo.entity.Account;
import com.vti.demo.form.Account.AccountFilterFrom;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Configuration
public class AccountSpecification {

    @SuppressWarnings("deprecation")
    public static Specification<Account> buildWhere(String search, AccountFilterFrom accountFilterFrom) {

        Specification<Account> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();

            CustomSpecification name = new CustomSpecification("userName", search);
            CustomSpecification departmentName = new CustomSpecification("departmentName", search);
            where = Specification.where(name).or(departmentName);
        }
        if (accountFilterFrom != null && accountFilterFrom.getMinID() != null) {
            CustomSpecification minID = new CustomSpecification("minID", accountFilterFrom.getMinID());
            if (where == null) {
                where = minID;
            } else {
                where = where.and(minID);
            }
        }
        if (accountFilterFrom != null && accountFilterFrom.getMaxID() != null) {
            CustomSpecification maxID = new CustomSpecification("maxID", accountFilterFrom.getMaxID());
            if (where == null) {
                where = maxID;
            } else {
                where = where.and(maxID);
            }
        }

        return where;
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("userName")) {
            return criteriaBuilder.like(root.get("userName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("departmentName")) {
            return criteriaBuilder.like(root.get("department").get("departmentName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("maxID")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get("accountID"), value.toString());
        }

        if (field.equalsIgnoreCase("minID")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("accountID"), value.toString());
        }

        return null;
    }

}
