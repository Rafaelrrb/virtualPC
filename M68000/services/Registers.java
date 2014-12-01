package M68000.services;
/*
 * Registers, ou registradores, contêm os registradores do Moto 68k e contam
 *  tanto os registradores de Dados e Endereços, como o CCR e o PC.
 */
import M68000.assistance.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Registers {
    private static final Logger logger = Logger.getLogger(Registers.class.getName());
    
    private Configuration configuration;
    private char[][] registersData;
    private char[][] registersAnddress;
    private short[] CCR;
    private int pc;
    private static volatile Registers instance = null;
    
    private Registers() {
        
       
        
        configuration = Configuration.getInstance();
        resetRegisters();
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
            if (configuration.registerD != null)
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
            return registersAnddress[position];
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
            registersAnddress[position] = value;
            String string = "";
            for(char i :value){
                string +=value;
            }
            if (configuration.registerA != null)
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
        registersAnddress[7] = value;
        String string = "";
        for(char i :value){
            string +=value;
        }
        if (configuration.registerA != null)
            configuration.registerA[7].setText(string);
    }
    
    /**
     * Insere no registrador especial SSP
     * @param value 
     */
    public void setRegistradorSSP(char[] value){
        registersAnddress[8] = value;
        String string = "";
        for(char i :value){
            string +=value;
        }
        if (configuration.registerA != null)
            configuration.registerA[8].setText(string);
    }
    
    /**
     * Retorna o Stack Pointer (user)
     * @return 
     */
    public char[] getRegisterUSP(){
        return registersAnddress[7];
    }
    
    /**
     * Stack Pointer (supervisor)
     * @return 
     */
    public char[] getRegisterSSP(){
        return registersAnddress[8];
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
    
    
    public void resetRegisters(){
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
        CCR = new short[5]; // All positions of CCR [0]X [1]N [2]Z [3]V [4]C
        registersAnddress = new char[9][16];
        registersData = new char[8][16];
        
        for(int a=0;a < 7; a++){
            this.setRegisterA(a, "0000000000000000".toCharArray());
        } 
         for(int a=0;a < 8; a++){
            this.setRegisterD(a, "0000000000000000".toCharArray());
        }
         
        setCCRX(0);
        setCCRN(0);
        setCCRZ(0);
        setCCRV(0);
        setCCRC(0);
        
        setRegistradorSSP("0000000000000000".toCharArray());
        setRegistradorUSP("0000000000000000".toCharArray());
        pc=0;
    }
    
    public int getCCRX(){
        return CCR[0];
    }
    
    public void setCCRX(int value){
        if(value == 0){
            CCR[0] = 0;
        }else{
            CCR[0] = 1;
        }
        if (configuration.recordX != null)
            configuration.recordX.setText(String.format("%d", CCR[0]));
    }
    
    public int getCCRN(){
        return CCR[1];
    }
    
    public void setCCRN(int value){
        if(value == 0){
            CCR[1] = 0;
        }else{
            CCR[1] = 1;
        }
        if (configuration.recordN != null)
            configuration.recordN.setText(String.format("%d", CCR[1]));
        
    }
    
    public int getCCRZ(){
        return CCR[2];
    }
    
    public void setCCRZ(int value){
        if(value == 0){
            CCR[2] = 0;
        }else{
            CCR[2] = 1;
        }
        if (configuration.recordZ != null)
            configuration.recordZ.setText(String.format("%d", CCR[2]));
        
    }
    
    public int getCCRVX(){
        return CCR[3];
    }
    
    public void setCCRV(int value){
        if(value == 0){
            CCR[3] = 0;
        }else{
            CCR[3] = 1;
        }
        if (configuration.recordV != null)
            configuration.recordV.setText(String.format("%d", CCR[3]));
    }
    
    public int getCCRC(){
        return CCR[4];
    }
    
    public void setCCRC(int value){
        if(value == 0){
            CCR[4] = 0;
        }else{
            CCR[4] = 1;
        }
        if (configuration.recordC != null)
            configuration.recordC.setText(String.format("%d", CCR[4]));
    }
}
