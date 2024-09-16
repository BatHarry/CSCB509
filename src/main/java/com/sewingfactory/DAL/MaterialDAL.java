package com.sewingfactory.DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Material;

public class MaterialDAL {
        public static void createLeatherDetail(Material material) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(material);
            transaction.commit();
        }
    }

    public static Material getLeatherDetailById(Long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            Material material = session.byId(Material.class).getReference(id);
            transaction.commit();
            return material;
        }
    }
}
