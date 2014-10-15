/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.util.LinkedList;

/**
 *
 * @author glaucomunsberg
 */
public class Memory {
    private static volatile Memory instance = null;
    private short position;
    private short symbols[];
    
    private Memory() {
        position = 0;
        symbols = new short[64];
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
    
    public void setOnMemory(Short value){
        symbols[position]=value;
        position++;
    }
}
