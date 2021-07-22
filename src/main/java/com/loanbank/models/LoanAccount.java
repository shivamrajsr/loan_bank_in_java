package com.loanbank.models;

import java.util.ArrayList;
import java.util.List;

public class LoanAccount {
    public String bank;
    public String borrower;
    public int principal;
    public int years;
    public int rate;
    public int paid;
    public List<Transaction> transactions;
    
    public LoanAccount(String bank_name,String borrower_name,int principal,int years,int 
    rate){
        this.bank= bank_name;
        this.borrower= borrower_name;
        this.principal= principal;
        this.years= years;
        this.rate= rate;
        this.paid= 0;
        this.transactions= new ArrayList<Transaction>();
    }
    // to add atransaction into the list of transactions
    public void addtransaction(Transaction transaction){
        this.transactions.add(transaction);

    }
    // whenever a new account added then below is displayed on console
    @Override public String toString() {
        return  "LoanAccount{" +
        "BANK_NAME= '" + bank + '\'' +
        ",BORROWER_NAME='" + borrower+ '\'' +
        ",PRINCIPAL=" + principal +
        ",NO_OF_YEARS=" + years+
        ",RATE_OF_INTEREST=" + rate+
        ", transactions=" + transactions +
        "}";
    }
    
}
