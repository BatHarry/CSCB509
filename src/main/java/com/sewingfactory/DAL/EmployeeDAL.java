package com.sewingfactory.DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Employee;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    public static List<Employee> getAllEmployees() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> rootEntry = cq.from(Employee.class);
            CriteriaQuery<Employee> all = cq.select(rootEntry);
            TypedQuery<Employee> allQuery = session.createQuery(all);
            return allQuery.getResultList();
        }
    }

    public static void getStatisticsForEmployees() {
        throw new Error("Not implemented");
    }
}
