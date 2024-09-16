package com.sewingfactory;

import com.sewingfactory.configurations.SessionFactoryUtil;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactoryUtil.getSessionFactory();
        Launcher.main(args);
    }
}
