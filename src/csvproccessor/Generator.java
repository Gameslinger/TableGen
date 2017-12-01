/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Owner
 */
public class Generator {
    
    public static void generate(int number, String fName) {
        FileWriter out = null;
        
        try {
            out = new FileWriter(fName);
        
        for (int i = 0; i < number; i++) {
                out.write(new Person().toCSV());
                if(i!= number -1)out.write(',');
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try {
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    
}
