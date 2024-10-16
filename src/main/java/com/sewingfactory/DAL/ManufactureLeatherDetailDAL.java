package com.sewingfactory.DAL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
                        ld.id,
                        ld.name,
                        ld.base_price,
                        count(mfld.leather_detail_id) 
                    FROM 
                        manufactured_leather_details mfld
                    LEFT JOIN leather_details ld ON ld.id = mfld.leather_detail_id 
                    WHERE mfld.issold = false
                    GROUP BY 
                        ld.id,
                        ld.name,
                        ld.base_price""", 
                    InventoryStats.class
                )
                .setTupleTransformer((tuple, aliases) -> {
                    return new InventoryStats((Long)tuple[0], (String)tuple[1], (Float)tuple[2], (Long)tuple[3]);
                })
                .getResultList();
            return results;
        }
    }

    public static List<ManufacturedLeatherDetail> sellManufactoredLeatherDetail(Long ldId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ManufacturedLeatherDetail> query = builder.createQuery(ManufacturedLeatherDetail.class);
            Root<ManufacturedLeatherDetail> mldrRoot = query.from(ManufacturedLeatherDetail.class);

            query.select(mldrRoot)
                .where(builder.equal(mldrRoot.get("leather_detail").get("id"), ldId));

            List<ManufacturedLeatherDetail> mlds = session.createQuery(query).getResultList();
            ManufacturedLeatherDetail toBeSold = mlds.get(0);
            toBeSold.setIsSold(true);

            transaction.commit();

            return mlds;
        }
    }

    public static Double[] getReport() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            List<Double> incomeResults = session
                .createNativeQuery("""
                    SELECT 
                        SUM(ld.base_price)
                    FROM 
                        manufactured_leather_details mfld
                    LEFT JOIN leather_details ld ON ld.id = mfld.leather_detail_id 
                    WHERE mfld.issold = true
                    """, 
                    Double.class
                )
                .getResultList();

            List<Double> expensesResults = session
                .createNativeQuery("""
                    SELECT 
                        SUM(mfld.price_for_manufacturing)
                    FROM 
                        manufactured_leather_details mfld
                    """, 
                    Double.class
                )
                .getResultList();

            Double income = incomeResults.get(0);
            Double expenses = expensesResults.get(0);
            Double[] results = {income == null ? 0 : income, expenses == null ? 0 : expenses};
            return results;
        }
    }
}
