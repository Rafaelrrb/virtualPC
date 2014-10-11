/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

/**
 *
 * @author glaucomunsberg
 */
public class Memory {
    private static volatile Memory instance = null;
    
    private Memory() {
        
        //symbols.add(new Symbol(0,0));
    }
    
    public static Memory getInstance() {
        if (instance == null) {
            synchronized (SymbolTable.class) {
                if (instance == null) {
                    instance = new Memory();
                }
            }
        }
        return instance;
    }
}
