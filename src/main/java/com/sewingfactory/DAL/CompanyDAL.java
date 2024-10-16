package com.sewingfactory.DAL;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.configurations.ValidationResponse;
import com.sewingfactory.entities.Company;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class CompanyDAL {
    public static void createCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {
        Transaction transaction = null;
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            company = session.byId(Company.class).getReference(id);

            if(company.getId() != id) throw new Error("Not found"); 

            transaction.commit();
        }
        return company;
    }

    public static ValidationResponse validateCompany(Company company) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Company>> violations = validator.validate(company);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Грешки: \n");
            for (ConstraintViolation<Company> violation : violations) {
                errorMessage.append(violation.getPropertyPath()).append(" ")
                            .append(violation.getMessage()).append("\n");
            }
            return new ValidationResponse(true, errorMessage.toString());
        }

        return new ValidationResponse(false);
    }

    public static void upateCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(company);
            transaction.commit();
        }
    }

    public static void getCompanyIncome() {
        throw new Error("Not implemented");
    }

    public static void getCompanyExpenses() {
        throw new Error("Not implemented");
    }

    public static void getCompanyProfit() {
        throw new Error("Not implemented");
    }

    public static void getCompanyProfitAfterTaxes() {
        throw new Error("Not implemented");
    }
}
