package com.loanbank.models;

public class Transaction {
    public int lumpsum;
    public int emi_no_done;

    public Transaction(int ls,int emi){
        this.lumpsum= ls;
        this.emi_no_done=emi;
    }

    @Override
    public String toString(){
        return "Transaction{"+
        "lumpsum =" + lumpsum +
        ", emi_n0=" + emi_no_done +
        "}";
    }
}
