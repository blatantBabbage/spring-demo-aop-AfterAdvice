package com.nitesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointcutExps {

    // Pointcut declaration to enable aspect to be executed before add* method inside com.nitesh.aopdemo.dao package
    @Pointcut("execution(* com.nitesh.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.nitesh.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.nitesh.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // combining pointcuts
    @Pointcut("forDaoPackage() && !(getter() && setter())")
    public void forDaoPackageExcludingGetterSetter() {}

}
