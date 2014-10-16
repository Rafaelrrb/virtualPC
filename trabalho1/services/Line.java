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
    private short   column1;
    private short   column2;
    private short   column3;
    private short   numOfColumn;
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
                    column1 = Short.parseShort(splitedLine[0]);
                    memory.setOnMemory(column1);
                    numOfColumn = 1;
                    config.setOutPut(line);
                    break;
                case 2:
                    column1 = Short.parseShort(splitedLine[0]);
                    column2 = Short.parseShort(splitedLine[1]);
                    memory.setOnMemory(column1);
                    memory.setOnMemory(column2);
                    numOfColumn = 2;
                    config.setOutPut(line);
                    break;
                case 3:
                    column1 = Short.parseShort(splitedLine[0]);
                    column2 = Short.parseShort(splitedLine[1]);
                    column3 = Short.parseShort(splitedLine[2]);
                    memory.setOnMemory(column1);
                    memory.setOnMemory(column2);
                    memory.setOnMemory(column3);
                    numOfColumn = 2;
                    config.setOutPut(line);
                    break;
                default:
                    config.setLog("Oops! Line: Num of arguments are wrong "+splitedLine.length);
            }
            config.reloadDisplayRecordAddress();
            
        }catch(Exception e){
            Config.getInstance().setLog("Ooops! Line: Error");
            e.printStackTrace();
        }
        
    }
}
