/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.assistance.FileMananger;
import M68000.assistance.Usage;
import M68000.services.Memory;
import M68000.services.TableSymbol;
import M68000.services.TableUsage;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Assembler {
    
    private static final Logger logger = Logger.getLogger(Assembler.class.getName());
    private TableUsage tabletUsage;
    private TableSymbol tableSymbol;
    private Usage usage;
    private Memory memory;
    private FileMananger file;
    private Decodificator decodificator;
    
    private StatusAssembler status;
    
    public Assembler(){
        memory = Memory.getInstance();
        tabletUsage = TableUsage.getInstance();
        tableSymbol = TableSymbol.getInstance();
        file = FileMananger.getInstance();
        status = StatusAssembler.GLOBAL;
        decodificator = Decodificator.getInstance();
    }
    
    
    public void execute(String path){
        String[] lines = new String[0];
        if(file.openFile(path)){
            lines = file.getLines();
        }else{
            logger.severe("Assembler can't run");
            return;
        }
        
        /**
         * Lê cada uma das linhas e então encaminha a execução
         */
        for (String line : lines) {
            
            switch(status){
                case BEGIN:
                    logger.info("BEGIN command");
                    
                    if(line.contains("END")){
                        status = status.END;
                        break;
                    }
                    decodificator.processInstruction(line);
                    break;
                case END:
                    logger.info("Not command");
                    break;
                case GLOBAL:
                    logger.info("GLOBAL command");
                    if(line.contains("BEGIN")){
                        status = status.BEGIN;
                    }
                    break;
                default:
                    logger.severe("Not processed");
            }  
            
            
        }
        //Alocador.alocaMemoria();
        //Alocador.resolveSimbolos();
       
    }
    
}
