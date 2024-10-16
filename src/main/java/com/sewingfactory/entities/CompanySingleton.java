package com.sewingfactory.entities;

import org.hibernate.ObjectNotFoundException;

import com.sewingfactory.DAL.CompanyDAL;

public class CompanySingleton {
    private static Company company;

    public static Company getCompany() {
        if(CompanySingleton.company == null) {
            Company companyFromDB;

            try {
                companyFromDB = CompanyDAL.getCompanyById(1);
            }catch (ObjectNotFoundException e) {
                System.out.println("Company not found");
                companyFromDB = new Company("", 0, 0);
                CompanyDAL.createCompany(companyFromDB);
                System.out.println("Blank company created");
            }

            CompanySingleton.company = companyFromDB;
        }

        return CompanySingleton.company;
    }

}
