/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;


/**
 *
 * @author Ruhan
 */
public class Memory {
    private static volatile Memory instance = null;
    private static Logger logger;
    private char[][] memory;
    private Registers registers;
    
    /**
     * Construtor privado que seta como
     *  0 a posição inicial e memória do tamanho de 1K
     */
    private Memory() {
        registers = Registers.getInstance();
        memory = new char[1024][16];
        registers = Registers.getInstance();
        logger = Logger.getLogger(Memory.class.getName()); 
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
           
    public char[][] getWord(int endereco){
        char[][] resposta = new char[2][8];
        
        for(int i = 0; i < 2; i++){
            System.arraycopy(memory[endereco + i], 0, resposta[i], 0, 8);
        }
        
        return resposta;
    }
 
    /**
     * Cada byte inserido na memória, o program counter é incrementado
     * 
     * @param valor 
     */
    public void insereByteMemoria(char[] valor){
        System.arraycopy(valor, 0, memory[registers.pc], 0, 8);
        registers.pc++;
    }
    
    /**
     * Caso o byte inserido na memória tenha sido especificado o local, pc não é alterado
     * 
     * @param valor
     * @param local 
     */
    public void insereByteMemoria(char[] valor, int local){
        System.arraycopy(valor, 0, memory[local], 0, 8);
    }
  
    /**
     * Insere um byte onde está o program counter apontando, e incrementa o mesmo em 4
     * 
     * @param valor 
     */
    public void insertWordMemory(char[][] valor){
        for(int i = 0; i < 2 ; i++){
            System.arraycopy(valor[i], 0, memory[registers.pc + i], 0, 8);
        }
        registers.pc = registers.pc + 4;
    }
    
    /**
     * Insere uma palavra na memória
     * 
     * @param valor 
     */
    public void insertWordMemory(char[] valor){
        for(int i = 0; i < 2; i++){
            for(int j = 0;j < 4; j ++){
                memory[registers.pc + i][j] = valor[8*i + j]; 
            }
        }
        
        registers.pc = registers.pc + 4;
    }
    
    public void insertWordMemory(char[] valor, int local){
        for(int i = 0; i < 2; i++){
            for(int j = 0;j < 4; j ++){
                memory[local + i][j] = valor[8*i + j]; 
            }
        }
    }
    
    public void insertWordMemory(char[][] valor, int local){
        for(int i = 0; i < 2 ; i++){
            System.arraycopy(valor[i], 0, memory[local + i], 0, 8);
        }
    }
    
    /**
     * Printa todo conteúdo da memória desde a posição
     *  zero até a posição indicada pelo PC
     */
    public void printMemory(){
        int i;
        
        for(i = 0; i < registers.pc; i++){
            System.out.print(i+": ");
            for(int j = 0; j < 16; j++){
                System.out.print(memory[i][j]);
            }
            System.out.print('\n');
        }
    }
    
    public void resetMemory(){
    
    
    }
    
    public int getPosition(){
        return registers.pc;
    }
    
    /**
     *  Printa toda a memória até o contador em um arquivo passado
     * @param file
     * @throws IOException 
     */
    public void printMemoryOnFile(FileOutputStream file) throws IOException{
        int i;
        boolean par = false;
        
        for(i = 0; i < registers.pc; i++){
            
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
    
}
