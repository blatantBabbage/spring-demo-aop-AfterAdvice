package com.nitesh.aopdemo.aspect;

import com.nitesh.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(10)
public class MyDemoLoggingAspect {

    // AfterThrowing advice
    @AfterThrowing(pointcut = "execution(* com.nitesh.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice (JoinPoint joinPoint, Throwable exc) {

        // print the method we're advising on
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n======>>>> Executing @AfterThrowing advice on Method : " + methodSignature);

        // log exception
        System.out.println("\n======>>>> the exception is : " + exc);
    }

    // After return advice
    @AfterReturning(pointcut = "execution(* com.nitesh.aopdemo.dao.AccountDAO.findAccount(..))",
                    returning = "tempAccount")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> tempAccount) {

        // print the method we're advising on
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n======>>>> Executing @AfterReturning advice on Method : " + methodSignature);

        // print result of the method call
        System.out.println("\n======>>>> Result is (tempAccount) : " + tempAccount);

        // call the method that makes changes to return value of findAccount
        updateAccountNameToUpperCase(tempAccount);

        // print the result again after name have been converted to uppercase
        System.out.println("\n======>>>> Names in uppercase Result is (tempAccount) : " + tempAccount);
    }

    private void updateAccountNameToUpperCase(List<Account> tempAccount) {

        // loop through accounts
        for(Account eachAccount : tempAccount) {

            // here getName is getter method in Account class
            String upperCaseName = eachAccount.getName().toUpperCase();

            // update uppercase name in list returned from the findAccount method
            eachAccount.setName(upperCaseName);
        }
    }

    // Before Advice
    @Before("com.nitesh.aopdemo.aspect.MyPointcutExps.forDaoPackageExcludingGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>>> Executing @Before advice on method()");

        // get method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method :" + methodSignature);

        // get method args
        Object[] methodArgs = joinPoint.getArgs();

        // print args and its values
        for(Object tempArgs : methodArgs){
            System.out.println(tempArgs);

            // printing arg value
            if (tempArgs instanceof Account) {

                // downcast and print Account specific stuff
                // Account theAccount = (Account) tempArgs;


                // downcasting tempArgs and print Account specific stuff
                System.out.println("account_name : " + ((Account) tempArgs).getName());
                System.out.println("account_name : " + ((Account) tempArgs).getLevel());
            }
        }
    }
}
