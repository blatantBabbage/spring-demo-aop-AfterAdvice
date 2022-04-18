package com.nitesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-5)
public class MyLogToCloudAsyncAspect {

    // reusing pointcut declaration on another Advice
    @Before("com.nitesh.aopdemo.aspect.MyPointcutExps.forDaoPackageExcludingGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n======>>>> Performing cloud analytics");
    }
}
