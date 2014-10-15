/*
 * Esta classe representa a memória de 1K e está estruturada
 * através de uma lista
 */
package system;

import java.util.LinkedList;

/**
 *
 * @author glaucomunsberg
 */
public class Memory {
    private static volatile Memory instance = null;
    private short position;
    private short memoryRange[];
    
    private Memory() {
        position = 0;
        memoryRange = new short[64];
    }
    
    /**
     * Retorna a instância única desta classe
     * @return 
     */
    public static Memory getInstance() {
        if (instance == null) {
            synchronized (SymbolTable.class) {
                if (instance == null) {
                    instance = new Memory();
                }
            }
        }
        return instance;
    }
    
    /**
     * Método que reseta a memória e todos os seus valores
     */
    public void resetMemory(){
    
        memoryRange = new short[64];
        position    = 0;
    }
    
    /**
     * Insere um novo valor na memória a partir da última inserção
     * @param value 
     */
    public void setOnMemory(Short value){
        memoryRange[position]=value;
        position++;
    }
    
    /**
     * Retorna a posição da última inserção
     * @return 
     */
    public short getPosition(){
        return position;
    }
    
    /**
     * Retorna o conteúdo da memória naquela posição
     * @param position
     * @return 
     */
    public short getOnMemory(Short position){
        return memoryRange[position];
    }
    
    /**
     * Insere naquela posição de memória o valore passado
     * @param memoryPosition
     * @param value 
     */
    public void setOnMemory(Short memoryPosition, Short value){
        memoryRange[memoryPosition] = value;
    }
}
