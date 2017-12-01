/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvproccessor;


/**
 *
 * @author Owner
 */
public class CSVProccessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 0){

        if (args[0].equalsIgnoreCase("generate")) {
            int number = Integer.parseInt(args[1]);
            Generator.generate(number, args[2]);
        } else if(args[0].equalsIgnoreCase("process")){
            Processor.process(args[1], args[2],args[3]);
        }
    }else{
            System.out.println("Improper usage!\n"
                    + "Try: generate [num] output\n"
                    + "or: process input specs output");
        }
    }

    
}
