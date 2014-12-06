/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

/**
 *
 * @author glaucomunsberg
 */
public class ObjectLine {
    private int cod;
    private char mod;
    
    public ObjectLine(int cod, char mod){
        this.cod = cod;
        this.mod = mod;
    }
    
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public void setMod(char mod){
        this.mod = mod;
    }
    
    public char getMod(){
        return this.mod;
    }
    
    public int getCod(){
        return this.cod;
    }
    
    @Override
    public String toString(){
        return cod+" "+String.valueOf(mod);
    }
}
