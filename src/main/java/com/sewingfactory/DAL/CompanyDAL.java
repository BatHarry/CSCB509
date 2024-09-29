package com.sewingfactory.DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Company;

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
