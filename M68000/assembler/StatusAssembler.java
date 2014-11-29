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
public enum StatusAssembler {
    BEGIN(0),GLOBAL(1),END(2);
    private int value;
    
    private StatusAssembler(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
}
