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
            System.out.println("Generating "+args[1]+" people to \""+args[2]+"\"");
            Generator.generate(number, args[2]);
        } else if(args[0].equalsIgnoreCase("process")){
            System.out.println("Processing \""+args[1]+"\" styled by \""+args[2]+"\" to \""+args[3]+"\"");
            Processor.process(args[1], args[2],args[3]);
        }else if(args[0].equalsIgnoreCase("genSpec")){
            SpecWriter.writeDefault(args[1]);
        }
        System.out.println("Finished");
    }else{
            System.out.println("Improper usage!\n"
                    + "ex: generate [num] output\n"
                    + "ex: process input specs output"
                    + "ex: genSpec output");
        }
    }

    
}
