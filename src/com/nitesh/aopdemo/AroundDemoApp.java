package com.nitesh.aopdemo;

import com.nitesh.aopdemo.dao.AccountDAO;
import com.nitesh.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the TrafficFortuneService bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\n\nMain program: Around advice");
        System.out.println("Calling getFortuneService");


        boolean tripwire = true;
        String fortune = trafficFortuneService.getFortune(tripwire);
        System.out.println("\nMy fortune is :" + fortune);

        System.out.println("Finished");
        // close the context
        context.close();

    }
}
