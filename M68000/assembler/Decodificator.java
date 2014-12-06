/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.linker.DecodificatedInstruction;
import M68000.services.Registers;
import M68000.services.TableSymbol;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Decodificator {
    private static volatile Decodificator instance = null;
    private final static Logger logger = Logger.getLogger(Decodificator.class.getName());
    private TableSymbol tableSymbols;
    private Registers registers;
    
    private Decodificator(){
        logger.info("Decodificator Loaded");
        tableSymbols = TableSymbol.getInstance();
        tableSymbols.resetTableSymbol();
        registers = Registers.getInstance();
        
    }
    
    public static Decodificator getInstance() {
        if (instance == null) {
            synchronized (Decodificator.class) {
                if (instance == null) {
                    instance = new Decodificator();
                }
            }
        }
        return instance;
    }
    
    
    public void processInstruction(String line){
        Instruction instruction = new Instruction(line);
        
        logger.info(instruction.toString());
        
        if(instruction.hasLabel()){
            tableSymbols.defineAnddress(instruction.getLabel(), registers.getPC());
            System.out.println("nova label: "+instruction.getLabel());
        }
        
        switch(instruction.getOperation()){
            case "XDEF":
                processGlobalInstruction(instruction,"XDEF");
                break;
            case "XREF":
                processGlobalInstruction(instruction,"XREF");
                break;
            default:
                processInstruction(instruction);
                break;
        }
        
    }
    
    private void processGlobalInstruction(Instruction instruction,String type){
        int start = 0;
        
        if( type.equals("XDEF") ){
           start = instruction.getStringOrigin().indexOf("XDEF");
        }else{
           start = instruction.getStringOrigin().indexOf("XREF");
        }
        
        String labelsGroup = instruction.getStringOrigin().substring(start+5,instruction.getStringOrigin().length());
        int startAt = 0;
        
        /**
         * Processa as labels
         */
        for(int a=0; a < labelsGroup.length(); a++){
            if(labelsGroup.charAt(a) == ','){
                
               tableSymbols.addSymbol(labelsGroup.substring(startAt, a),type.equals("XDEF"), type.equals("XREF"));
               
               startAt = a+1;
            }else{
                if(labelsGroup.charAt(a) == '\t' || labelsGroup.charAt(a) == ' '){
                    startAt = a+1;
                }
            }
        }
        /**
         * última Label
         */
        tableSymbols.addSymbol(labelsGroup.substring(startAt, labelsGroup.length()), type.equals("XDEF"), type.equals("XREF"));
        tableSymbols.printTableSymbol();
    }
    private void processInstruction(Instruction instruction){
        switch(instruction.getOperation()){
            case "ADD":
                break;
            case "STOP":
                break;        
        }
    }
}
