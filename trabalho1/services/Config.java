/*
 * Config é a classe base de configurações para o sistema inteiro
 */
package services;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import system.Memory;

/**
 *
 * @author glaucomunsberg
 */
public class Config {
    private static volatile Config instance = null;
    private static Memory memory = Memory.getInstance();
    private int startLocation;
    private JTextArea log;
    private JLabel recordPC;
    private JLabel recordMOP;
    private JLabel recordRE;
    private JLabel recordRI;
    private JLabel recordSP;
    private JLabel recordACC;
    private JLabel recordAddress;
    
    
    
    
    private Config() {

    }

    public static Config getInstance() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }
    
    /**
     * Método que pega a referência da Interface gráfica e
     *  permite que seja manipulados os displays de registradores
     *  pela classe Config
     * @param recordPC
     * @param recordMOP
     * @param recordRE
     * @param recordRI
     * @param recordSP
     * @param recordACC
     * @param recordAnddress 
     */
    public void setDisplayLabels(JLabel recordPC, JLabel recordMOP, JLabel recordRE, JLabel recordRI, JLabel recordSP, JLabel recordACC, JLabel recordAnddress){
        this.recordPC       = recordPC;
        this.recordMOP      = recordMOP;
        this.recordRE       = recordRE;
        this.recordRI       = recordRI;
        this.recordSP       = recordSP;
        this.recordACC      = recordACC;
        this.recordAddress  = recordAnddress;
    
    }
    
    /**
     * Método responsável por resetar o sistema inteiro
     *  para que se possa reentrar com um novo programa
     */
    public void resetSystem(){
        this.recordPC.setText("0");
        this.recordMOP.setText("--");
        this.recordRE.setText("--");
        this.recordRI.setText("--");
        this.recordSP.setText("--");
        this.recordACC.setText("--");
        this.recordAddress.setText("0");
        
        memory.resetMemory();
    }
    
    /**
     * Atualiza o Display do Andrress
     * segundo o uso de memória até então
     */
    public void reloadDisplayRecordAddress(){
        this.recordAddress.setText(String.format("%d", memory.getPosition()));
    }
    
    
    /**
     * Insere no sistema a referência do
     *  display out da interface
     * @param log 
     */
    public void setLog(JTextArea log){
        this.log = log;
    }
   
    /**
     * Insere uma nova linha no log do display
     * @param line 
     */
    public void setLog(String line){
        if(this.log != null)
            this.log.setText(this.log.getText()+"\n"+line);
    }
}
