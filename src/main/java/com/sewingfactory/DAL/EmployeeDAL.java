package com.sewingfactory.DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Employee;

public class EmployeeDAL {
    public static void createEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(Long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            Employee employee = session.byId(Employee.class).getReference(id);
            transaction.commit();
            return employee;
        }
    }

    public static void getStatisticsForEmployees() {
        throw new Error("Not implemented");
    }
}
