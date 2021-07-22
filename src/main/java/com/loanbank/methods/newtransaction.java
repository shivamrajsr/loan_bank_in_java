package com.loanbank.methods;

import java.util.List;

import com.loanbank.backend.backend;
import com.loanbank.models.LoanAccount;
import com.loanbank.models.Transaction;

public class newtransaction {
      /**
     * Creates a new {@link Transaction} with given arhuments and adds it to corresponding account
     * @param arguments Array of string
     */
    public static void addTransaction(final String[] arguments) {
        LoanAccount acc = findAcccount(arguments[1], arguments[2]);
        Transaction transaction = makeTransaction(Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]));
        acc.addtransaction(transaction);
    }
    // returning a new transaction instance
    private static Transaction makeTransaction(final int lumpsum, final int emi_no) {
        return new Transaction(lumpsum, emi_no);
    }

    /**
     * Searches for an account in the database with given bank name and borrower name
     * @param bank name of the bank
     * @param borrower name of borrower
     * @return {@link LoanAccount}
     */
    public static LoanAccount findAcccount(final String bank, final String borrower) {
        return backend.getdatabase().findaccount(bank, borrower);
    }

    // finding the balance
     /**
     * Calculates the total amount paid and remaining number of emis
     * @param arguments Array of string
     */
    public static void calculateBalance(final String[] arguments) {
        LoanAccount acc = findAcccount(arguments[1], arguments[2]);
        int emi_no = Integer.parseInt(arguments[3]);
        calculateBalance_(acc, emi_no);
    }

    public static void calculateBalance_(LoanAccount acc, int emi_number){
        List<Transaction> transactions = acc.transactions;

        int remaining_emi = 12*acc.years;
        int total_amount = acc.principal + Interest(acc.principal, acc.years, acc.rate);
        int total_paid = 0;
        int emi_amount = (int)Math.ceil((double)total_amount/remaining_emi);
        int last_emi = 0;
        // there r no transactions
        if(transactions.size() == 0) {
            Balance(total_amount,acc, total_paid, remaining_emi, emi_amount, emi_number, last_emi);
            return;
        }
        // if there r transactions 
        // we need to check the lumpsum amount if any
        for(Transaction transaction : transactions){
            // if emi no is more than emi no done of a transaction
            // then lumpsum should be added to total paid
            if(emi_number >= transaction.emi_no_done){
                total_paid= total_paid+transaction.lumpsum;
            }
        
        }
        // calling for balance check in case of transaction is not zero
        Balance(total_amount,acc, total_paid, remaining_emi, emi_amount, emi_number, last_emi);
    }

    private static void Balance(int total,LoanAccount acc, int total_paid, int remaining_emi, int emi_amount, int emi_number,
            int last_emi) {
         //calculating total paid 
        total_paid += emi_amount*(emi_number-last_emi);
        if(total_paid>=total)
        {    last_emi= emi_amount-(total_paid-total);
            total_paid= total;
            remaining_emi=0;
        }
        else{
            if(total-total_paid >= emi_amount){
                remaining_emi = (int)Math.ceil((double)(total-total_paid)/emi_amount);
            }else{
            
                remaining_emi = 1;
                last_emi = total-total_paid;
            }
        }
        
        System.out.println(acc.bank + " " + acc.borrower + " "+  total_paid + " " + remaining_emi);
    }

    /**
     * Simple interest calculator
     * @param amount units
     * @param time in years
     * @param rate per annum
     * @return
     */
    private static int Interest(final int amount, final int time, final int rate) {
        return (int)Math.ceil((double)amount*time*rate)/100;
    }
    
}
