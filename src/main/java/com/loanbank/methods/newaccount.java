package com.loanbank.methods;

import com.loanbank.backend.backend;
import com.loanbank.models.LoanAccount;

public class newaccount {
     /**
     * Creates a new {@link Account} with given arguments and puts into database
     * @param arguments Array of string
     */

    public static void openaccount(String[] arguments){
        LoanAccount account= new LoanAccount( arguments[1],arguments[2],Integer.parseInt(arguments[3]),
        Integer.parseInt(arguments[4]),Integer.parseInt(arguments[5])
        );
         
        backend.getdatabase().addaccount(account);
    }
    
}
