/*
 * Esta Classe representa a tabela de simbolos
 *      do sistema usado pelo Assembler
 */
package system;

import java.util.LinkedList;
import services.Symbol;

/**
 *
 * @author glaucomunsberg
 */
public class SymbolTable {
    private static volatile SymbolTable instance = null;
    private LinkedList symbols;
    
    private SymbolTable() {
        symbols = new LinkedList();
        //symbols.add(new Symbol(0,0));
    }

    public static SymbolTable getInstance() {
        if (instance == null) {
            synchronized (SymbolTable.class) {
                if (instance == null) {
                    instance = new SymbolTable();
                }
            }
        }
        return instance;
    }
    
    public LinkedList getReferencesSymbol(Symbol symbol){
        return null;
    }
}
