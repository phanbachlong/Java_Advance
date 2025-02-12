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

            CustomSpecification userName = new CustomSpecification("userName", search);
            CustomSpecification firstName = new CustomSpecification("firstName", search);
            CustomSpecification lastName = new CustomSpecification("lastName", search);
            where = Specification.where(userName).or(firstName).or(lastName);
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

        if (field.equalsIgnoreCase("firstName")) {
            return criteriaBuilder.like(root.get("firstName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("lastName")) {
            return criteriaBuilder.like(root.get("lastName"), "%" + value.toString() + "%");
        }

        return null;
    }

}
