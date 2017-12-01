/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;

import java.io.FileWriter;
import java.io.OutputStream;

/**
 *
 * @author Owner
 */
public class Person {
    private String name;
    private String address;
    private String pNumber;

    public Person(String name, String address, String pNumber) {
        this.name = name;
        this.address = address;
        this.pNumber = pNumber;
    }

    public Person() {
        this.name = randomString((int)(Math.random()*17)+3);
        this.address = randomString((int)(Math.random()*12)+5);
        this.pNumber = randomPhoneNumber();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getpNumber() {
        return pNumber;
    }
    
    private static String randomString(int maxLen) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            str.append((char) ((Math.random() * 25) + 'a'));
        }
        return str.toString();
    }

    private static String randomPhoneNumber() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str.append((char) ('0' + ((int) (Math.random() * 9))));
            if (i == 2 || i == 5) {
                str.append('-');
            }
        }
        return str.toString();
    }

    public String toCSV() {
    return this.name+","+this.address+","+this.pNumber;
    }
}
