/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assistance;

import M68000.services.Anddress;
import java.util.logging.Logger;

/**
 *
 * @author Ruhan
 */
public class Symbol {
    private final static Logger logger = Logger.getLogger(Symbol.class.getName());
    
    final private String symbol;
    private Anddress anddress;
    private boolean definido;
    private boolean global;
    private String valor; // apenas para DC
    /*
     * Define se é EQU,DC,DS ou POSICAO DE MEMORIA
     * 0: Posição de Memória
     * 1: EQU
     * 2: DC
     * 3: DS
     *
     */
    private int tipo;
    
    public Symbol(String simbolo) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.tipo = 0;
        this.valor = "";
    }
    
    public Symbol(String simbolo, int tipo ,String valor) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Symbol(String simbolo, int tipo) {
        this.symbol = simbolo;
        this.definido = false;
        this.global = false;
        this.tipo = tipo;
    }
    
    public void setEndereco(int endereco) {
        this.anddress = new Anddress(endereco);
        definido = true;
    }

    public Anddress getEndereco() {
        return anddress;
    }

    public String getSimbolo() {
        return symbol;
    }

    public void setEndereco(Anddress endereco) {
        if(this.definido){
            logger.severe("Invalidet Operation!");
            return;
        }
        
        this.anddress = endereco;
        this.definido = true;
    }

    public boolean isDefinido() {
        return definido;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal() {
        this.global = true;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

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
