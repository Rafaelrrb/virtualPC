/*
 * Config é a classe base de configurações para o sistema inteiro
 */
package services;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author glaucomunsberg
 */
public class Config {
    private static volatile Config instance = null;
    private int startLocation;
    private JTextArea log;
    public JLabel recordPC;
    public JLabel recordMOP;
    public JLabel recordRE;
    public JLabel recordRI;
    public JLabel recordSP;
    public JLabel recordACC;
    
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
    
    public void setLog(JTextArea log){
        this.log = log;
    }
    
    public void setLog(String line){
        if(this.log != null)
            this.log.setText(this.log.getText()+"\n"+line);
    }
}
