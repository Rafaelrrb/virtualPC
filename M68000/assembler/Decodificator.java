/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.services.Instruction;
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
    private TableSymbol symbols;
    private Registers registers;
    
    private Decodificator(){
        logger.info("Decodificator Loaded");
        symbols = TableSymbol.getInstance();
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
            symbols.defineAnddress(instruction.getLabel(), registers.getPC());
        }
        DecodificatedInstruction instruc = new DecodificatedInstruction(instruction);
        
    }
    
    public void processInstructionGlobal(String line){
    
    }
}
