package com.sewingfactory;
import org.hibernate.SessionFactory;

import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Company;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory session = SessionFactoryUtil.getSessionFactory();
        Company company = CompanyDAL.getCompanyById(1);
        Launcher.main(args);
    }
}
