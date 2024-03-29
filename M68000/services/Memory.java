/*
 * Esta classe, Memory, representa a memória do sistema Moto 68k
 *  então através dela é possível inserir, editar ou até mesmo ser usada
 *  pela MV para executar seu conteúdo
 */
package M68000.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
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
    private static final Logger logger = Logger.getLogger(Memory.class.getName());
    private char[][] memory;
    private Registers registers;
    private JTable jtableMemory;
    
    /**
     * Construtor privado que seta como
     *  0 a posição inicial e memória do tamanho de 1K
     */
    private Memory() {
        
        registers = Registers.getInstance();
        resetMemory();
        logger.info("Memory Loaded");
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
     * retorna a palavra o endereco
     * @param endereco
     * @return 
     */
    public char[] getWord(int endereco){
        char[] resposta = new char[16];
        
        System.arraycopy(memory[endereco], 0, resposta, 0, 16);
        
        return resposta;
    }
    
 
    /**
     * Cada byte inserido na memória, o program counter é incrementado
     * @param valor 
     */
    public void insereByteMemoria(char[] valor){
        System.arraycopy(valor, 0, memory[registers.getPC()], 0, 16);
        registers.addToPC(1);
        this.setValueOnTableMemory();
    }
    
    /**
     * Caso o byte inserido na memória tenha sido especificado o local, pc não é alterado
     * @param valor
     * @param local 
     */
    public void insereByteMemoria(char[] valor, int local){
        System.arraycopy(valor, 0, memory[local], 0, 16);
    }
  
    /**
     * Insere um byte onde está o program counter apontando, e incrementa o mesmo em 4
     * @param valor 
     */
    public void insertWordMemory(char[][] valor){
        for(int i = 0; i < 2 ; i++){
            System.arraycopy(valor[i], 0, memory[registers.getPC() + i], 0, 8);
        }
        registers.addToPC(4);
    }
    
    /**
     * Insere uma palavra na memória
     * @param valor 
     */
    public void insertWordMemory(char[] valor){
        for(int i = 0; i < 2; i++){
            for(int j = 0;j < 8; j ++){
                memory[registers.getPC() + i][j] = valor[8*i + j]; 
            }
        }
        registers.addToPC(4);
    }
        
    /**
     * Insere uma palavra em um local específico
     * @param valor
     * @param local 
     */
    public void insertWordMemory(char[][] valor, int local){
        for(int i = 0; i < 2 ; i++){
            System.arraycopy(valor[i], 0, memory[local + i], 0, 8);
        }
    }
    
    /**
     * Printa todo conteúdo da memória desde a posição
     *  zero até a posição indicada pelo PC
     */
    public void printMemoryOnConsole(){
        int i;
        
        for(i = 0; i < registers.getPC(); i++){
            System.out.print(i+": ");
            for(int j = 0; j < 16; j++){
                System.out.print(memory[i][j]);
            }
            System.out.print('\n');
        }
    }
    
    public void resetMemory(){
        memory = new char[1024][16];
        registers.resetRegisters();
    }
   
    /**
     *  Printa toda a memória até o contador em um arquivo passado
     * @param file
     * @throws IOException 
     */
    public void printMemoryOnFile(FileOutputStream file) throws IOException{
        int i;
        boolean par = false;
        
        for(i = 0; i < registers.getPC(); i++){
            
            for(int j = 0; j < 8; j++){
                file.write(memory[i][j]);
            }
            if(par){
                file.write('\n');
                par = false;
            }else{
                par = true;
            }
        }
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
    
    public String memoryToString(int position){
        String value = "";
        for(int a=0; a < 16; a++){
            value+=memory[position][a];
        }
        return  value;
    }
    
    /**
     * Método que insere modifica o valor exibido na tabela
     *  da interface 
     */
    public void setValueOnTableMemory(){    
        for(int a = 0; a < 128;a++){
            jtableMemory.setValueAt(memoryToString(a), a, 1);
        }
    }
    public void fullMemory(){
        insertWordMemory("00000000000000000".toCharArray());
        insertWordMemory("00000000000000000".toCharArray());
        insertWordMemory("00000000000000000".toCharArray());
        insertWordMemory("00000000000000000".toCharArray());
    }
}
