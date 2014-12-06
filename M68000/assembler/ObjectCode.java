/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import java.util.ArrayList;

/**
 *
 * @author glaucomunsberg
 */
public class ObjectCode {
    private ArrayList<ObjectLine> table;
    
    public ObjectCode(){
        
    }
    
    public void setNewLine(short cod, char mod){
        table.add( new ObjectLine(cod,mod));
    }

    public ObjectLine getObjectLine(short enddress){
        return table.get(enddress);
    }
}
