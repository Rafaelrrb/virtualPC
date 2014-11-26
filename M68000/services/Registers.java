package M68000.services;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Registers {
    private static Logger logger;
    
    private char[][] registers;
    private char[] CCR;
    private static volatile Registers instance = null;
    
    private Registers() {
        
        /**
         * 
         * X—Extend Set to the value of the C-bit for arithmetic operations;
         * otherwise not affected or set to a specified result. 
         * 
         * N—Negative Set if the most significant bit of the result is set; otherwise clear.
         * 
         * Z—Zero Set if the result equals zero; otherwise clear. 
         * 
         * V—Overflow Set if an arithmetic overflow occurs implying that the result cannot be
         * represented in the operand size; otherwise clear.
         * 
         * C—Carry Set if a carry out of the most significant bit of the operand
         * occurs for an addition, or if a borrow occurs in a subtraction;
         * otherwise clear.
         * 
         */
        CCR = new char[5]; // All positions of CCR [0]X [1]N [2]Z [3]V [4]C
        registers = new char[8][16];
        
        logger = Logger.getLogger(Registers.class.getName());
        logger.info("Registers Loaded");
        
    }
    
    /**
     * Retorna a única instância desta classe
     * @return 
     */
    public static Registers getInstance() {
        if (instance == null) {
            synchronized (Memory.class) {
                if (instance == null) {
                    instance = new Registers();
                }
            }
        }
        return instance;
    }
    
    public char[] getRegisterD(int position){
        if(position <= 8 || position >= 0){
            return registers[position];
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador não existe {0}", position);
            return null;
        }
        
    }
}
