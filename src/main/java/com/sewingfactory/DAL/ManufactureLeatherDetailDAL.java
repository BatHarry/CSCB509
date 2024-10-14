package com.sewingfactory.DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

public class ManufactureLeatherDetailDAL {

    public static void createManufactureLeatherDetailDAL(ManufacturedLeatherDetail manufacturedLeatherDetail) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(manufacturedLeatherDetail);
            transaction.commit();
        }
    }

    public static List<InventoryStats> getManufacturedLeatherDetailsInventory() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            List<InventoryStats> results = session
                .createNativeQuery("""
                    SELECT 
                        ld.name, 
                        count(mfld.leather_detail_id) 
                    FROM 
                        manufactured_leather_details mfld
                    LEFT JOIN leather_details ld ON ld.id = mfld.leather_detail_id 
                    GROUP BY 
                        ld.name""", 
                    InventoryStats.class
                )
                .setTupleTransformer((tuple, aliases) -> {
                    return new InventoryStats((String)tuple[0], (Long)tuple[1]);
                })
                .getResultList();
            return results;
        }
    }

    public static List<InventoryStats> getManufacturedLeatherDetailsInventoryWithPrice() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            List<InventoryStats> results = session
                .createNativeQuery("""
                    SELECT 
                        ld.name,
                        ld.base_price,
                        count(mfld.leather_detail_id) 
                    FROM 
                        manufactured_leather_details mfld
                    LEFT JOIN leather_details ld ON ld.id = mfld.leather_detail_id 
                    GROUP BY 
                        ld.name,
                        ld.base_price""", 
                    InventoryStats.class
                )
                .setTupleTransformer((tuple, aliases) -> {
                    return new InventoryStats((String)tuple[0], (Float)tuple[1], (Long)tuple[2]);
                })
                .getResultList();
            return results;
        }
    }
}
