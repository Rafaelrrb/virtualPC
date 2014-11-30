package M68000.services;

import M68000.assistance.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Registers {
    private static Logger logger;
    
    private Configuration configuration;
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
        configuration = Configuration.getInstance();
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
    
    /**
     * insere o registrador de endereço D[position]
     * @param position
     * @param value 
     */
    public void setRegisterD(int position, char[] value){
        if(position <= 7 || position >= 0){
            registersData[position] = value;
            String string = "";
            for(char i :value){
                string +=value;
            }
            configuration.registerD[position].setText(string);
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador D{0} não existe", position);
        }
    }
    
    /**
     * Retornar o registrador de dado D[position]
     * @param position
     * @return 
     */
    public char[] getRegisterD(int position){
        if(position <= 7 || position >= 0){
            return registersData[position];
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador D{0} não existe", position);
            return null;
        }
        
    }
    
   /**
    * Retorna o registrador de endereço A[position]
    * @param position
    * @return 
    */
    public char[] getRegisterA(int position){
        if(position <= 6 || position >= 0){
            return registersData[position];
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador A{0} não existe", position);
            return null;
        }
        
    }
    
    /**
     *  Insere o novo valor ao registrador de endereço A[position]
     * @param position
     * @param value 
     */
    public void setRegisterA(int position, char[] value){
        if(position <= 6 || position >= 0){
            registersData[position] = value;
            String string = "";
            for(char i :value){
                string +=value;
            }
            configuration.registerA[position].setText(string);
        }else{
            logger.log(Level.SEVERE, "Ooops! Registrador não existe {0}", position);
        }
    }
    
    /**
     * Insere no registrador especial USP
     * @param value 
     */
    public void setRegistradorUSP(char[] value){
        registersData[7] = value;
        String string = "";
        for(char i :value){
            string +=value;
        }
        configuration.registerA[7].setText(string);
    }
    
    /**
     * Insere no registrador especial SSP
     * @param value 
     */
    public void setRegistradorSSP(char[] value){
        registersData[8] = value;
        String string = "";
        for(char i :value){
            string +=value;
        }
        configuration.registerA[8].setText(string);
    }
    
    /**
     * Retorna o Stack Pointer (user)
     * @return 
     */
    public char[] getRegisterUSP(){
        return registersData[7];
    }
    
    /**
     * Stack Pointer (supervisor)
     * @return 
     */
    public char[] getRegisterSSP(){
        return registersData[8];
    }
    
    /**
     * Retorna o PC do sistema
     * @return int
     */
    public int getPC(){
        return pc;
    }
    
    /**
     * Adiciona o valor plus ao contador atual
     *  pc + plus
     * @param plus 
     */
    public void addToPC(int plus){
        pc += plus;
        configuration.recordPC.setText(String.format("%d", pc));
        
    }
    
}
