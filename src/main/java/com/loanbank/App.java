package com.loanbank;

import java.io.IOException;
import com.loanbank.backend.backend;

/**
 * Hello world!
 *
 */
public final class App 
{
    private App() {
    }


    
    /**
     * @param args The arguments of main
     */

    public static void main( String[] args )
    {
        String filename = args[0];
        try {
            backend.execute(filename);
        } catch (IOException e) {
                e.printStackTrace();
        }
        
    }
}
