/*
 * Configuration é a classe com as referências básicas usadas 
 *  na interface gráfica e também pelo sistema Moto 68k
 */
package M68000.assistance;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author glaucomunsberg
 */
public class Configuration {
    private static volatile Configuration instance = null;
    private JTextArea log;
    public JTextField out;
    private JTextArea linkerListFile;
    public JTextField in;
    public JCheckBox comboMachine;
    public JCheckBox comboLink;
    public JCheckBox comboLoader;
    public JCheckBox comboAssembler;
    public JLabel recordPC;
    public JLabel recordACC;
    public JLabel recordAddress;
    public JLabel recordN;
    public JLabel recordZ;
    public JLabel recordV;
    public JLabel recordC;
    public JLabel recordX;
    public JLabel[] registerD;
    public JLabel[] registerA;
    
    /**
     * Construtor privado da classe
     */
    private Configuration() {

    }

    /**
    * Retorna a única instância desta classe
    * @return 
    */
    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
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
     * @param recordN
     * @param recordACC
     * @param recordAnddress 
     * @param recordZ 
     * @param recordV 
     * @param recordC 
     */
    public void setGeneralLabels(JLabel recordPC, JLabel recordACC, JLabel recordAnddress, JLabel recordN, JLabel recordZ, JLabel recordV, JLabel recordC, JLabel recordX){
        this.recordPC       = recordPC;
        this.recordACC      = recordACC;
        this.recordAddress  = recordAnddress;
        this.recordN        = recordN;
        this.recordZ        = recordZ;
        this.recordV        = recordV;
        this.recordC        = recordC;
        this.recordX        = recordX;
    }
    
    public void setRegisterData(JLabel[] registersD){
        this.registerD =  registersD;
    
    }
    
    public void setRegisterAnddress(JLabel[] registersA){
        this.registerA =  registersA;
    
    }
    
    /**
     *  Método que atualiza os valores da tab "General" 
     *  na interface
     * @param X
     * @param N
     * @param V
     * @param C
     * @param Z 
     */
    public void reloadCCR(short X, short N, short V, short C, short Z){
        this.recordX.setText(String.format("%d", X));
        this.recordN.setText(String.format("%d", N));
        this.recordV.setText(String.format("%d", V));
        this.recordC.setText(String.format("%d", C));
        this.recordZ.setText(String.format("%d", Z));
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
    public void setOutPut(JTextField out){
        this.out = out;
    }
    
    /**
     * Método que insere a referência do
     *  display out da interface 
     * @param linker
     */
    public void setLinkerListFile(JTextArea linker){
        this.linkerListFile = linker;
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
     * Método que insere a referência da combo
     *  no display o sistema 
     * @param assembler
     * @param linker
     * @param loader
     * @param virtualMachine
     */
    public void setGeralComboBox(JCheckBox assembler,JCheckBox linker, JCheckBox loader, JCheckBox virtualMachine){
        this.comboAssembler = assembler;
        this.comboLink      = linker;
        this.comboLoader    = loader;
        this.comboMachine   = virtualMachine;
    }
   
    /**
     * Método responsável por resetar o sistema inteiro
     *  para que se possa reentrar com um novo programa
     */
    public void resetSystem(){
        
        this.recordX.setText("-");
        this.recordN.setText("-");
        this.recordV.setText("-");
        this.recordC.setText("-");
        this.recordZ.setText("-");
        this.recordPC.setText("-");
        this.recordACC.setText("-");
        this.recordAddress.setText("-----------------");
        this.out.setText("");
        this.in.setText("");
    }
}

