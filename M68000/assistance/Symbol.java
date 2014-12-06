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
    private Anddress anddress;
    private boolean definido;
    private boolean global;
    private boolean XDEF;
    private boolean XREF;
    private String valor; // apenas para DC
    
    private int tipo;
    
    /**
     * Cria um symbolo padrão com
     *  definição falsa, não global e tipo posição de memória
     * @param simbolo 
     */
    public Symbol(String simbolo) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.XDEF = false;
        this.XREF = false;
        this.tipo = 0;
        this.valor = "";
        
        this.anddress = new Anddress(0);
    }
    
    public Symbol(String simbolo,boolean XDEF, boolean XREF) {
        this.symbol = simbolo;
        this.definido = false;
        
        this.global = XDEF || XREF;
            
        this.XDEF = XDEF;
        this.XREF = XREF;
        this.tipo = 0;
        this.valor = "";
        
        this.anddress = new Anddress(0);
    }
    
    /**
     * Cria o symbolo com os seus parametros
     * @param simbolo
     * @param tipo
     * @param valor 
     */
    public Symbol(String simbolo, int tipo ,String valor) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.XDEF = false;
        this.XREF = false;
        this.tipo = tipo;
        this.valor = valor;
        
        this.anddress = new Anddress(0);
    }

    /**
     * Cria simbolo padrão com definição falsa e como local
     * @param simbolo
     * @param tipo 
     */
    public Symbol(String simbolo, int tipo) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.tipo = tipo;
        this.XDEF = false;
        this.XREF = false;
        this.anddress = new Anddress(0);
    }
    
    /**
     * Insere o endereço para o simbolo já definido anteriormente
     * @param endereco 
     */
    public void setEndereco(int endereco) {
        this.anddress = new Anddress(endereco);
        definido = true;
    }

    /**
     * Retorna o endereço
     * @return 
     */
    public Anddress getEndereco() {
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
     * Insere o endereço
     * @param endereco 
     */
    public void setEndereco(Anddress endereco) {
        if(this.definido){
            logger.severe("Invalidet Operation!");
            return;
        }
        
        this.anddress = endereco;
        this.definido = true;
    }

    /**
     * Retorna o booleano se é definido
     * @return 
     */
    public boolean isDefinido() {
        return definido;
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

    /**
     * Insere o tipo do simbolo
     * 0: Posição de Memória
     * 1: EQU
     * 2: DC
     * 3: DS
     * @param tipo 
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o tipo do simbolo
     * @return 
     */
    public int getTipo() {
        return tipo;
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

    /**
     * retorna o valor
     * @return 
     */
    public String getValor() {
        return valor;
    }
    
    @Override
    public String toString(){
        String resposta;
        if(this.definido){
            resposta = this.symbol +": " +this.anddress +"\n*Tipo: " +this.tipo +"\n*Global? " +this.global;
            return resposta;
        }else{
            resposta = this.symbol +": xx" +"\n*Tipo: " +this.tipo +"\n*Global? " +this.global;
            return resposta;
        }
    }
}
