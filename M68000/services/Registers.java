package M68000.services;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Registers {
    private static Logger logger;
    
    private char[][] registersData;
    private char[][] registersAnddress;
    private char[] CCR;
    private int pc;
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
        registersAnddress = new char[8][16];
        registersData = new char[8][16];
        
        logger = Logger.getLogger(Registers.class.getName());
        pc = 0;
        logger.info("Registers Loaded");
        
    }
    
    /**
     * Retorna a unica instancia desta classe
     * 
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
            return registersData[position];
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador não existe {0}", position);
            return null;
        }
        
    }
    
    public char[] getRegisterA(int position){
        if(position <= 6 || position >= 0){
            return registersData[position];
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador não existe {0}", position);
            return null;
        }
        
    }
    
    /**
     * Stack Pointer (user)
     */
    public char[] getRegisterAUSP(){
        return registersData[7];
    }
    
    /**
     * Stack Pointer (supervisor)
     */
    public char[] getRegisterSSP(){
        return registersData[8];
    }
    
    public int getPC(){
        return pc;
    }
    
    public void addToPC(int plus){
        pc += plus;
    }
    
}
