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
    private short cod;
    private char mod;
    
    public ObjectLine(short cod, char mod){
        this.cod = cod;
        this.mod = mod;
    }
    
    public void setCod(short cod){
        this.cod = cod;
    }
    
    public void setMod(char mod){
        this.mod = mod;
    }
    
    public char getMod(){
        return this.mod;
    }
    
    public short getCod(){
        return this.cod;
    }
}
