/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.linker;

import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Linker {
    
    private static volatile Linker instance = null;
    private final static Logger logger = Logger.getLogger(Linker.class.getName());
    
    private Linker(){
        logger.info("Linker Loaded");
    }
    
    public static Linker getInstance() {
        if (instance == null) {
            synchronized (Linker.class) {
                if (instance == null) {
                    instance = new Linker();
                }
            }
        }
        return instance;
    }
    
}
