/*
 * Esta classe representa a memória de 1K e está estruturada
 * através de uma lista
 */
package system;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;



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
        for(int a=0; a < 64; a++){
            memoryRange[a]= 0;
        }
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
    
    /**
     * Método pelo qual se insere a referência
     *  para a tabela de memória da interface  
     *  bem como se organiza o layout dela
     * @param table 
     */
    public void setTableMemory(JTable table){
        this.jtableMemory = table;
        
        /**
         * Organizando o layout
         */
        TableColumnModel tcm = jtableMemory.getColumnModel();
        tcm.getColumn(0).setMaxWidth(55);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jtableMemory.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jtableMemory.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tcm.getColumn(1).setPreferredWidth(200);
        
    }
    
    /**
     * Método que insere modifica o valor exibido na tabela
     *  da interface
     * @param position
     * @param value 
     */
    public void setValueOnTableMemory(){    
        for(int a = 0; a < memoryRange.length;a++){
            jtableMemory.setValueAt(memoryRange[a], a, 1);
        }
    }
    
    
    /**
     * Método que reseta a memória e todos os seus valores
     */
    public void resetMemory(){
        position = 0;
        memoryRange = new short[64];
        for(int a=0; a < 64; a++){
            memoryRange[a]= 0;
            this.jtableMemory.setValueAt(null, a, 1);
        }
    }
    
    /**
     * Insere um novo valor na memória a partir da última inserção
     * @param value 
     */
    public void setOnMemory(Short value){
        
        memoryRange[position]=value;
        position++;
        setValueOnTableMemory();
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
     * @param posit
     * @return 
     */
    public short getOnMemory(short posit){
        
        return memoryRange[posit];
    }
    
    /**
     * Insere naquela posição de memória o valore passado
     * @param memoryPosition
     * @param value 
     */
    public void setOnMemory(Short memoryPosition, Short value){
        
        //jtableMemory.setValueAt(value, memoryPosition, 1);
        memoryRange[memoryPosition] = value;
        setValueOnTableMemory();
        
    }
}
