/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000;

import M68000.assembler.Assembler;
import M68000.assistance.Configuration;
import M68000.services.Memory;

/**
 *
 * @author glaucomunsberg
 */
public class Application {
    
    public Assembler assembler;
    public Configuration configuration;
    public Memory memory;
            
    public Application(){
        assembler = new Assembler(); 
        configuration = Configuration.getInstance();
        memory =    Memory.getInstance();
    }
  
    
    public void restart(){
        
    }
    
    public void start(){
        if(configuration.in.getText() != ""){
            if (configuration.comboAssembler.isSelected()) {
                Assembler assembler = new Assembler();
                assembler.execute(configuration.in.getText());
            }
        }else{
        
            configuration.setLog("Set the file to open");
        }
    
    }
    
}
