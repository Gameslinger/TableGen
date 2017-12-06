/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel.Maxfield
 */
public class SpecWriter {
    private static final String defaultSpecs = 
            "head:<head></head>\n" +
            "body:<body>\n" +
            "table:<table><tr><th>Name</th><th>Phone Number</th><th>Address</th></tr>\n" +
            "tr:<tr>\n" +
            "td:<td>";
    public static void writeDefault(String name){
        FileWriter out = null;
        try {
            out = new FileWriter(name);
            out.write(defaultSpecs);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(out != null){
                try {
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
