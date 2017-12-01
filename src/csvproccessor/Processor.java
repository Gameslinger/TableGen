/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Owner
 */
public class Processor {
    public static void process(String inName, String specName, String outName){
        try {
            PersonReader pr = new PersonReader(inName);
            SpecReader specIn = new SpecReader(specName);
            FileWriter out = new FileWriter(outName);
            
            out.write("<html>");
            out.write(specIn.getStr("head"));
            out.write(specIn.getStr("body"));
            out.write(specIn.getStr("table"));
            
            String tr = specIn.getStr("tr");
            String td = specIn.getStr("td");
            
            for(Person person : pr.getPeople()){
                out.write(tr);
                out.write(td);
                out.write(person.getName());
                out.write("</td>");
                out.write(td);
                out.write(person.getAddress());
                out.write("</td>");
                out.write(td);
                out.write(person.getpNumber());
                out.write("</td>");
                out.write("</tr>");
            }
                out.write("</table>");
                out.write("</body>");
                out.write("</html>");
                
                out.flush();
                out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
