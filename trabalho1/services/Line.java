/*
 * Esta classe representa cada um das linhas
 *  digitadas no console pelo usuário
 */
package services;

import system.Memory;

/**
 *
 * @author glaucomunsberg
 */
public class Line {
    public String  line;
    public short   line1;
    public short   line2;
    public short   line3;
    public short   numOfLines;
    private static final Config config = Config.getInstance();
    private static final Memory memory = Memory.getInstance();
    
    /**
     * Método que recebe a linha e processa ela
     *  para extrair as informações de operadores
     * @param line 
     */
    public Line(String line){
        this.line = line;
        String splitedLine[] = this.line.split("\\s+");
        Config.getInstance().setLog("Line: Num of arguments "+splitedLine.length);
        int operation = -1;
        try{
            switch(splitedLine.length){
                case 1:
                    line1 = Short.parseShort(splitedLine[0]);
                    memory.setOnMemory(line1);
                    numOfLines = 1;
                    break;
                case 2:
                    line1 = Short.parseShort(splitedLine[0]);
                    line2 = Short.parseShort(splitedLine[1]);
                    memory.setOnMemory(line1);
                    memory.setOnMemory(line2);
                    numOfLines = 2;
                    break;
                case 3:
                    line1 = Short.parseShort(splitedLine[0]);
                    line2 = Short.parseShort(splitedLine[1]);
                    line3 = Short.parseShort(splitedLine[2]);
                    memory.setOnMemory(line1);
                    memory.setOnMemory(line2);
                    memory.setOnMemory(line3);
                    numOfLines = 2;
                    break;
                default:
                    config.setLog("Oops! Line: Num of artgments are wrong "+splitedLine.length);
            }
            config.reloadDisplayRecordAddress();
            
        }catch(Exception e){
            Config.getInstance().setLog("Ooops! Line: Error");
            e.printStackTrace();
        }
        
    }
}
