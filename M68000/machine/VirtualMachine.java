/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.machine;

import M68000.services.Memory;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class VirtualMachine {
    private static volatile VirtualMachine instance = null;
    private final static Logger logger = Logger.getLogger(VirtualMachine.class.getName());
    private Memory memory;
    
    private VirtualMachine(){
        logger.info("Virtual Machine Loaded");
        memory = Memory.getInstance();
    }
    
    public static VirtualMachine getInstance() {
        if (instance == null) {
            synchronized (VirtualMachine.class) {
                if (instance == null) {
                    instance = new VirtualMachine();
                }
            }
        }
        return instance;
    }
    
    public void startMachine(){
         logger.info("Iniciando a execução");
         memory.printMemory();
         // passa por todas as posições de memoria
         // para cada posicao:
         //     verifica que comando é e então executa
    }
    
}
