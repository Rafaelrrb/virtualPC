/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Decodificator {
    private static volatile Decodificator instance = null;
    private final static Logger logger = Logger.getLogger(Decodificator.class.getName());
    
    private Decodificator(){
        logger.info("Decodificator Loaded");
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
    
    
    public void processInstructionBegin(String line){
    
    }
    
    public void processInstructionGlobal(String line){
    
    }
}
