package com.sewingfactory.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.LeatherDetail;

public class LeatherDetailDAO {
    public static void createLeatherDetail(LeatherDetail leatherDetail) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(leatherDetail);
            transaction.commit();
        }
    }

    public static LeatherDetail getLeatherDetailById(Long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            LeatherDetail leatherDetail = session.byId(LeatherDetail.class).getReference(id);
            transaction.commit();
            return leatherDetail;
        }
    }

    public static void getInventory() {
        throw new Error("Not implemented");
    }
}
