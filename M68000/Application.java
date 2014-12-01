/*
 * Application é a interface de aplicação usada para iniciar e reiniciar o sistema.
 *  moto 68k. Esse classe é usada pela Principal.java para iniciar o sistema
 */
package M68000;

import M68000.assembler.Assembler;
import M68000.assistance.Configuration;
import M68000.services.Memory;
import M68000.services.TableSymbol;
import M68000.services.TableUsage;

/**
 *
 * @author glaucomunsberg
 */
public class Application {
    
    public Assembler assembler;
    public Configuration configuration;
    public Memory memory;
    public TableUsage tableUsage;
    public TableSymbol tableSymbol;
            
    public Application(){
        
        configuration   = Configuration.getInstance();
        assembler       = new Assembler();
        memory          = Memory.getInstance();
        tableUsage      = TableUsage.getInstance();
        tableSymbol     = TableSymbol.getInstance();
    }
  
    /**
     * Reinicia o sistema Moto 68k por inteiro
     */
    public void restart(){
        memory.resetMemory();
        
        configuration.resetSystem();
        
        
    }
    
    /**
     * Inicia o sistema Moto 68k de acordo com as
     *  funcionalidades ativadas na interface
     */
    public void start(){
        if(!"".equals(configuration.in.getText())){
            if (configuration.comboAssembler.isSelected()) {
                assembler.execute(configuration.in.getText());
            }
        }else{
        
            configuration.setLog("Set the file to open");
        }
    
    }
    
}
