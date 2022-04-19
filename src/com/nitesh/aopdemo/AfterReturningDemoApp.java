package com.nitesh.aopdemo;

import com.nitesh.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the AccountDAO bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the find account method
        List<Account> accounts = theAccountDAO.findAccount();

        // display accounts
        System.out.println("\n\nMain program: After return advice");
        System.out.println("----");
        System.out.println(accounts);

        // close the context
        context.close();

    }
}
