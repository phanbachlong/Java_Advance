package com.vti.demo.specification;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.demo.entity.Account;
import com.vti.demo.entity.Role;
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
        if (accountFilterFrom != null && accountFilterFrom.getRole() != null) {
            CustomSpecification role = new CustomSpecification("role",
                    accountFilterFrom.getRole());
            where = (where == null) ? role : where.and(role);
        } else {
            System.out.println("filter speci: none");

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
        System.out.println("Field: " + field + "| Value: " + value);
        if (field.equalsIgnoreCase("userName")) {
            return criteriaBuilder.like(root.get("userName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("firstName")) {
            return criteriaBuilder.like(root.get("firstName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("lastName")) {
            return criteriaBuilder.like(root.get("lastName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("role")) {
            if (value instanceof Role) {
                System.out.println("✅ Role matched: " + value);

                return criteriaBuilder.equal(root.get("role"), value);
            } else if (value instanceof String) {
                try {
                    Role role = Role.valueOf(((String) value).toUpperCase());
                    System.out.println("✅ Convert role matched: " + value);

                    return criteriaBuilder.equal(root.get("role"), role);
                } catch (IllegalArgumentException e) {
                    System.out.println(" Invalid: " + value);

                    return null;
                }
            }
        }

        return null;
    }

}
