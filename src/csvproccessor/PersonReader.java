/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class PersonReader {
    List<Person> pList = new ArrayList<>();
    public PersonReader(String inName) throws FileNotFoundException, IOException{
        FileReader in = new FileReader(inName);
        int chr;
        StringBuilder[] str = new StringBuilder[3];
        for(int i = 0; i < str.length; i++){
            str[i] = new StringBuilder();
        }
        int attrCount = 0;
        while((chr = in.read())!= -1){
            if(chr != ','){
                str[attrCount].append((char)chr);
            }else {
                attrCount++;
                if(attrCount == 3){
                    attrCount = 0;
                    pList.add(new Person(str[0].toString(),str[1].toString(),str[2].toString()));
                }
            }
        }
    }
    public List<Person> getPeople(){
        return pList;
    }
}
