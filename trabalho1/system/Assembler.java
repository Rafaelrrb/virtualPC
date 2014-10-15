/*
 * Assembler é a classe que executará de fato
 *      todas as operações de montagem
 */
package system;

import services.Config;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author glaucomunsberg
 */
public class Assembler {
    
    
    private final Config config;
    public Assembler(){
        config = Config.getInstance();
    }
    
    /**
     * Referência das labes para serem manipuladas pelo 
     * @param recordPC
     * @param recordMOP
     * @param recordRE
     * @param recordRI
     * @param recordSP
     * @param recordACC 
     */
    public void setRecordes(JLabel recordPC,JLabel recordMOP,JLabel recordRE,JLabel recordRI,JLabel recordSP,JLabel recordACC){
    
    
    }
    
    /**
     * Método para começar a análise
     */
    public void start(){
    
    }
    
    /**
     * Método para resetar todos os valores
     */
    public void reset(){
        config.resetSystem();
    }
    
    public void nextStep(){
    
    }
    
    public void setOperatingMode(String mode){
    
    }
}
