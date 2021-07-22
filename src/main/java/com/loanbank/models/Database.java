package com.loanbank.models;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<LoanAccount> accounts= new ArrayList<>();

    public void addaccount(LoanAccount account){
        accounts.add(account);
 
    }

    public LoanAccount findaccount(final String bank_name, final String borrower_name){
        
         for(LoanAccount ac: accounts){
             if(ac.bank.equals(bank_name) && ac.borrower.equals(borrower_name))
             {
                 return ac;
             }
         }
        return null ;

    }
    
    @Override public String toString() {
        return "DataBase{" +
                "accounts=" + accounts +
                '}';
    }
}
