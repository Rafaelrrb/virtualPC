/*
 * Symbol é a classe usada para representar os simbolos do Moto 68k
 */
package M68000.assistance;

import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Symbol {
    private final static Logger logger = Logger.getLogger(Symbol.class.getName());
    
    final private String symbol;
    private int anddress;
    private boolean defined;
    private boolean global;
    private boolean XDEF;
    private boolean XREF;
    
    /**
     * Cria um symbolo padrão com
     *  definição falsa, não global e tipo posição de memória
     * @param simbolo 
     * @param defined 
     * @param anddress 
     */
    
    public Symbol(String simbolo,boolean defined,int anddress) {
        this.symbol = simbolo;
        this.defined = defined;
        this.global = false;
        this.XDEF = false;
        this.XREF = false;
        this.anddress = anddress;
    }
    
    public Symbol(String simbolo,boolean XDEF, boolean XREF) {
        this.symbol = simbolo;
        this.defined = false;
        
        this.global = XDEF || XREF;
            
        this.XDEF = XDEF;
        this.XREF = XREF;
    }
    
    /**
     * Insere o endereço para o simbolo já definido anteriormente
     * @param endereco 
     */
    public void setEndereco(int endereco) {
        this.anddress = endereco;
    }

    /**
     * Retorna o endereço
     * @return 
     */
    public int getEndereco() {
        return anddress;
    }

    /**
     * Retorna o simbolo
     * @return 
     */
    public String getSimbolo() {
        return symbol;
    }

    
    
    
    

    /**
     * Retorna o booleano se é definido
     * @return 
     */
    public boolean isDefined() {
        return defined;
    }
    
    public void setIsDefined(boolean value){
         defined = value;
    }

    /**
     * Retorna o booleano se é global
     * @return 
     */
    public boolean isGlobal() {
        return global;
    }

    /**
     * Seta o simbolo como global 
     */
    public void setGlobal() {
        this.global = true;
    }

    public void setXDEF(boolean value){
        this.XDEF = value;
    }
    
    public boolean isXDEF(){
        return this.XDEF;
    }
    
    public boolean isXREF(){
        return this.XREF;
    }
    
    public void setXREF(boolean value){
        this.XREF = value;
    }

    @Override
    public String toString(){
        return "{symbol:"+this.symbol+", defined:"+this.defined+", anddress:"+this.anddress+", XREF:"+this.XREF+", XDEF:"+this.XDEF+"}";   
    }
}
