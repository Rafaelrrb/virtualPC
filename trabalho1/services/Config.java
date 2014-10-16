/*
 * Config é a classe base de configuração para o sistema
 */
package services;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import system.Memory;

/**
 *
 * @author glaucomunsberg
 */
public class Config {
    private static volatile Config instance = null;
    private static Memory memory = Memory.getInstance();
    private static Catalog command = Catalog.getInstance();
    private int startLocation;
    private JTextArea log;
    private JTextArea out;
    public JTextField in;
    private JComboBox comboBoxMode;
    private JLabel recordPC;
    private JLabel recordMOP;
    private JLabel recordRE;
    private JLabel recordRI;
    private JLabel recordSP;
    private JLabel recordACC;
    private JLabel recordAddress;
   
    
    /**
     * Construtor privado da classe
     */
    private Config() {

    }

    /**
    * Retorna a única instância desta classe
    * @return 
    */
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
     * Método que atualiza os valores da tab "General" 
     *  na interface
     * @param pc
     * @param sp
     * @param acc
     * @param mop
     * @param re
     * @param ri 
     */
    public void reloadDisplayLabels(short pc, short sp, short acc, short mop, short re, short ri){
        this.recordPC.setText(String.format("%d", pc));
        this.recordSP.setText(String.format("%d", sp));
        this.recordACC.setText(String.format("%d", acc));
        this.recordRE.setText(String.format("%d", re));
        this.recordRI.setText(String.format("%d", ri));
        this.recordMOP.setText(String.format("%d", mop));
    }
    
    /**
     * Método responsável por resetar o sistema inteiro
     *  para que se possa reentrar com um novo programa
     */
    public void resetSystem(){
        this.recordPC.setText("0");
        this.recordMOP.setText("0");
        this.recordRE.setText("0");
        this.recordRI.setText("0");
        this.recordSP.setText("0");
        this.recordACC.setText("0");
        this.recordAddress.setText("0");
        this.out.setText(" ");
        this.in.setText(" ");
        memory.resetMemory();
        command.resetCommand();
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
     *  display log da interface
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
            this.log.setText(this.log.getText()+line+"\n");
    }
    
    
    /**
     * Método que insere a referência do
     *  display out da interface
     * @param out 
     */
    public void setOutPut(JTextArea out){
        this.out = out;
    }
    
    /**
     * Método que insere a referência do
     *  display in da interface para ser
     *  manipulado
     * @param text 
     */
    public void setInPut(JTextField text){
        this.in = text;
    }
    
    /**
     * Método que insere uma nova linha
     *  no output do sistema
     * @param line 
     */
    public void setOutPut(String line){
        
        this.out.setText(this.out.getText()+line+"\n");
    }
    
    /**
     * Método que retorna qual dos modos de operação
     *  foi seleciado pelo operador.
     * @return short 
     */
    public short getComboBoxModeSelected(){
        
        return (short) this.comboBoxMode.getSelectedIndex();
    }
    
    
    /**
     * Método que insere a referência da combo
     *  no display o sistema
     * @param box 
     */
    public void setComboBoxMode(JComboBox box){
        this.comboBoxMode = box;
        this.comboBoxMode.setSelectedIndex(2);
    }
}
