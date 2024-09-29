package com.sewingfactory.DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.LeatherDetail;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class LeatherDetailDAL {
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

    public static List<LeatherDetail> getAllLeatherDetails() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LeatherDetail> cq = cb.createQuery(LeatherDetail.class);
            Root<LeatherDetail> rootEntry = cq.from(LeatherDetail.class);
            CriteriaQuery<LeatherDetail> all = cq.select(rootEntry);
            TypedQuery<LeatherDetail> allQuery = session.createQuery(all);
            return allQuery.getResultList();
        }
    }
}
