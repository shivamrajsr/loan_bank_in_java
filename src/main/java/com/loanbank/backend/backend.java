package com.loanbank.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.loanbank.models.Database;
import com.loanbank.constants.*;
import com.loanbank.methods.newaccount;
import com.loanbank.methods.newtransaction;

public class backend {
    private static Database DB =new Database();
    //get database
    public static Database getdatabase(){
        return DB;
    }

    public static void execute(final String filename) throws IOException
    {
        FileReader freader= new FileReader(filename);
        BufferedReader bfreader= new BufferedReader(freader);
        while(true){
            String line = bfreader.readLine();
            if(line == null)break;
            String[]arguments = line.split(" ");
            // acccount command
            if(arguments[0].equals(constant.LOAN)){
                newaccount.openaccount(arguments);
            }
            //payment command
            if(arguments[0].equals(constant.PAYMENT)){
                newtransaction.addTransaction(arguments);
            }
            // balance command
            if(arguments[0].equals(constant.BALANCE)){
                newtransaction.calculateBalance(arguments);
            }
        }
        //closing the readers
        freader.close();
        bfreader.close();
    }
}
