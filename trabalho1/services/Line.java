/*
 * Esta classe representa cada uma das linhas 
 *      carregadas pelo ManipulatorFile    
 */
package services;

import system.Memory;

/**
 *
 * @author glaucomunsberg
 */
public class Line {
    private String line;

    
    public Line(String line){
        this.line = line;
        String splitedLine[] = this.line.split("\\s+");
        Config.getInstance().setLog("num op: "+splitedLine.length);
        int operation = -1;
        try{
            Config.getInstance().setLog("Operation: "+splitedLine[0]);
            
            for(String splitedLine1 : splitedLine) {
                Memory.getInstance().setOnMemory(Short.parseShort(splitedLine1));
            }
            
        }catch(Exception e){
        
            Config.getInstance().setLog("Ooops! Error");
            e.printStackTrace();
        }
        
    }
}
