/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Owner
 */
public class SpecReader {
    String fileName;
    Map<String,String> attr = new HashMap<>();
    public SpecReader(String fileName){
        this.fileName = fileName;
        FileReader in = null;
        
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        
        int lastKey = '\0';
        
        boolean onKey = true;
        try {
            in = new FileReader(fileName);
            int chr;
            while((chr = in.read())!= -1){
                switch (chr) {
                    case '\n':
                        onKey = true;
                        attr.put(key.toString(), value.toString()+"\n");
                        key = new StringBuilder();
                        value = new StringBuilder();
                        break;
                    case ':':
                        onKey = false;
                        break;
                    case '\r':
                        break;
                    default:
                        if(onKey){
                            key.append((char)chr);
                        }else{
                            value.append((char)chr);
                        }    break;
                }
               attr.put(key.toString(), value.toString());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Spec file incomplete");
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public String getStr(String key){
        return attr.get(key);
    }
}
