package com.sewingfactory.configurations;

import com.sewingfactory.entities.Company;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.schema.Action;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration
            .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/java-project-db")
            .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "user")
            .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "password")
            .setProperty(AvailableSettings.AUTOCOMMIT, "true")
            .setProperty("hibernate.validator.apply_to_ddl", "true")
            .setProperty("hibernate.validator.autoregister_listeners", "true")
            .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION, Action.SPEC_ACTION_DROP_AND_CREATE)
            .addAnnotatedClass(Company.class)
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(LeatherDetail.class)
            .addAnnotatedClass(ManufacturedLeatherDetail.class);

            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}