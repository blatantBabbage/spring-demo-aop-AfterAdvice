package com.nitesh.aopdemo.dao;

import com.nitesh.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": Doing getter name stuff");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": Doing name setter stuff");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": Doing getter service stuff");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": Doing service setter stuff");
        this.serviceCode = serviceCode;
    }

    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work - adding an account");
    }

    public void addAccount(Account account, boolean addOrNot) {
        System.out.println(getClass() + ": adding an Account");
    }

    public List<Account> findAccount(boolean tripwire) {

        // for learning purpose, throwing exception to trigger AfterThrow advice
        if(tripwire){
            throw new RuntimeException("purposely throwing exception!!");
        }

        // initializing a list
        List<Account> tempAccount = new ArrayList<>();

        // creating data objects
        Account acc1 = new Account("Nitesh", "SDE 1");
        Account acc2 = new Account("Nitesh Kumar", "SDE 2");
        Account acc3 = new Account("Nitesh Singh", "SDE 3");

        // adding data object to the Account list
        tempAccount.add(acc1);
        tempAccount.add(acc2);
        tempAccount.add(acc3);

        // returning list of accounts
        return tempAccount;
    }
}
