/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.macro;

import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Macro {
    private static volatile Macro instance = null;
    private final static Logger logger = Logger.getLogger(Macro.class.getName());
    
    private Macro(){
        logger.info("Macro Processor Loaded");
    }
    
    public static Macro getInstance() {
        if (instance == null) {
            synchronized (Macro.class) {
                if (instance == null) {
                    instance = new Macro();
                }
            }
        }
        return instance;
    }
    
    
    public String[] processText(String[] texto){
        logger.info("Macro Processor start process the string...");
        // 1. Acha as macros e armazenas elas em 
        // 2. quando acha uma referência a elas então substitui
        // 3. salva o texto final em outro arquivo que deve ser chamado "out_macro" por exemplo
        // 3. retorna a string que foi salva como out_macro
        return new String[0];
    }
   
}
