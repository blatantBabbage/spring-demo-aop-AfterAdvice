package com.nitesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyPerformApiAnalyticsAspect {

    // reusing pointcut declaration on another Advice
    @Before("com.nitesh.aopdemo.aspect.MyPointcutExps.forDaoPackageExcludingGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n======>>>> Performing api analytics");
    }

}
