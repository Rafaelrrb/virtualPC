/*
 * Esta classe representa a memória de 1K e está estruturada
 * através de uma lista
 */
package system;

import javax.swing.JTable;



/**
 *
 * @author glaucomunsberg
 */
public class Memory {
    private static volatile Memory instance = null;
    private JTable jtableMemory;
    private short position;
    private short memoryRange[];
    
    /**
     * Construtor privado que seta como
     *  0 a posição inicial e memória do tamanho de 1K
     */
    private Memory() {
        position = 0;
        memoryRange = new short[64];
    }
    
    /**
     * Retorna a única instância desta classe
     * @return 
     */
    public static Memory getInstance() {
        if (instance == null) {
            synchronized (Memory.class) {
                if (instance == null) {
                    instance = new Memory();
                }
            }
        }
        return instance;
    }
    
    public void setTableMemory(JTable table){
        this.jtableMemory = table;
    }
    
    public void setValueOnTableMemory(short position,short value){    
        this.jtableMemory.setValueAt(value, position, 1);
    }
    
    
    /**
     * Método que reseta a memória e todos os seus valores
     */
    public void resetMemory(){
    
        memoryRange = new short[64];
        for(int a=0; a < 64; a++){
            this.jtableMemory.setValueAt(null, a, 1);
        }
        position    = 0;
    }
    
    /**
     * Insere um novo valor na memória a partir da última inserção
     * @param value 
     */
    public void setOnMemory(Short value){
        jtableMemory.setValueAt(value, position, 1);
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
    public short getOnMemory(short position){
        return memoryRange[position];
    }
    
    /**
     * Insere naquela posição de memória o valore passado
     * @param memoryPosition
     * @param value 
     */
    public void setOnMemory(Short memoryPosition, Short value){
        jtableMemory.setValueAt(value, memoryPosition, 1);
        memoryRange[memoryPosition] = value;
        
    }
}
