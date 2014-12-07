/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.assistance.Configuration;
import M68000.services.Registers;
import java.util.ArrayList;

/**
 *
 * @author glaucomunsberg
 */
public class ObjectCode {
    private ArrayList<ObjectLine> table;
    private Configuration configuration = Configuration.getInstance();
    private Registers registers = Registers.getInstance();
    public ObjectCode(){
        table = new ArrayList<ObjectLine>();
    }
    
    public void setNewLine(int cod, char mod){
        table.add( new ObjectLine(cod,mod));
        registers.addToPC(1);
        printObjectLine();
    }

    public ObjectLine getObjectLine(int anddress){
        registers.addToPC(1);
        return table.get(anddress);
    }
    
    public void setAtPosition(int anddress, int cod, char mod){
        if(anddress > table.size()-1){
            while(anddress != table.size()-1){
                table.add(new ObjectLine(0,'R'));
            }
            registers.addToPC(registers.getPC()-registers.getPC());
            registers.addToPC(anddress);
        }
        table.set(anddress, new ObjectLine(cod,mod));
        printObjectLine();
    }
    public void printObjectLine(){
    
        configuration.getObjectCode().setText(null);
        int position=0;
        for(int a=0;a< table.size(); a++){
            switch(table.get(a).getCod()){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 12:
                case 55:
                case 57:
                case 58:
                    try{
                        configuration.getObjectCode().setText(configuration.getObjectCode().getText()+a+" "+table.get(a).toString()+" "+table.get(a+1).toString()+" "+table.get(a+2).toString()+"\n");
                    }catch(Exception e){
                    
                    }
                    a+=2;
                    break;
                case 11:
                case 31:
                case 32:
                case 48:
                case 52:
                case 54:
                case 59:
                    try{
                        configuration.getObjectCode().setText(configuration.getObjectCode().getText()+a+" "+table.get(a).toString()+" "+table.get(a+1).toString()+"\n");
                    }catch(Exception e){
                        
                    }   
                    a+=1;
                    break;
                default:
                        configuration.getObjectCode().setText(configuration.getObjectCode().getText()+a+" "+table.get(a).toString()+"\n");
                    
            }
        }
    }
    
    public void salveOnFileObjectCode(){
    
    }
}
