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
        }
        
        switch(instruction.getOperation()){
            case "XDEF":
            case "XREF":
                processGlobalInstruction(instruction);
                break;
            default:
                processInstruction(instruction);
                break;
        }
        if(instruction.getOperation().equals("XDEF")){
        
        }else{
        
        }
        if(instruction.getOperation().equals("XREF")){
        
        }
        
        
    }
    
    private void processGlobalInstruction(Instruction instruction){
        logger.info("Processing global instruction");
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
