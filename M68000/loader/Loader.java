/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.loader;

import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Loader {
    private static volatile Loader instance = null;
    private final static Logger logger = Logger.getLogger(Loader.class.getName());
    
    private Loader(){
        logger.info("Loader Loaded");
    }
    
    public static Loader getInstance() {
        if (instance == null) {
            synchronized (Loader.class) {
                if (instance == null) {
                    instance = new Loader();
                }
            }
        }
        return instance;
    }
}
