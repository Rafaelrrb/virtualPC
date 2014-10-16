/*
 * Assembler é a classe que executará de fato
 *      o simulador
 */
package system;

import services.Catalog;
import services.Config;

/**
 *
 * @author glaucomunsberg
 */
public class Assembler {
    
    private final Config config;
    private final Memory memory;
    private Catalog commands;
    private short accumulator;
    private boolean isStoped;
    private short pc;
    private short sp;
    private short ri;
    private short re;
    
    public Assembler(){
        config      = Config.getInstance();
        memory      = Memory.getInstance();
        commands    = Catalog.getInstance();
        accumulator = 0;
        sp          = 0;
        ri          = 0;
        re          = 0;
        pc          = 0;
    }
    
    /**
     * Método que começa a execução do sistema
     *  ele é dispara com o 'start' na interface
     *  e executa de acordo com o modo de execução
     */
    public void start(){
    
    }
    
    /**
     * Método para resetar todos os valores
     *  do config e do assembler
     */
    public void reset(){
        config.resetSystem();
        this.resetAssembler();
    }
    
    /**
     * Pega o PC e executa a operação naquela
     *  posição
     */
    public void nextStep(){
        ri = memory.getOnMemory(pc);
        switch(memory.getOnMemory(pc)){
            
            case 0:
                //BR
                pc = memory.getOnMemory((short)(pc+1));
                break;
            case 1:
                //BRPOS
                if(accumulator > 0){
                    pc = memory.getOnMemory((short)(pc+1));
                }else{
                    pc = (short) (pc+2);
                }
                break;
            case 2:
                //ADD
                accumulator =(short) (accumulator + memory.getOnMemory((short)(pc+1)));
                pc = (short) (pc+2);
                break;
            case 3:
                //LOAD
                accumulator = memory.getOnMemory((short)(pc+1));
                pc = (short)(pc+2) ;
                break;
            case 4:
                //BRZERO
                if(accumulator == 0){
                    pc = memory.getOnMemory((short)(pc+1));
                }else{
                    pc = (short) (pc+2);
                }
                break;
            case 5:
                //BRNEG
                if(accumulator < 0){
                    pc = memory.getOnMemory((short)(pc+1));
                }else{
                    pc = (short) (pc+2);
                }
                break;
            case 6:
                //SUB
                accumulator =(short) (accumulator - memory.getOnMemory((short)(pc+1)));
                pc = (short) (pc+2);
                break;
            case 7:
                //STORE
                short position = memory.getOnMemory((short)(pc+1));
                memory.setOnMemory(position, accumulator);
                pc = (short) (pc+2);
                re = (short) (pc+1);
                break;
            case 8:
                //OUT PUT
                config.setOutPut(String.format("%d", memory.getOnMemory((short)(pc+1))));
                pc = (short) (pc+2);
                break;
            case 10:
                //DIVISOR
                break;
            case 11:
                //STOP
                
                break;
            case 12:
                //STREAM
                config.setOutPut("Digite o valor");
                config.in.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        short positon = memory.getOnMemory((short)(pc+1));
                        memory.setOnMemory(positon, Short.parseShort(config.in.getText()));
                        pc = (short) (pc+2);
                    }
                });
            case 13:
                //COPY
                short value = memory.getOnMemory((short)(pc+2));
                re =(short)  (pc+1);
                memory.setOnMemory((short)(pc+1), value);
                pc = (short) (pc+3);
                break;
            case 14:
                //MULT
                break;
            case 15:
                //CALL
                sp = pc;
                pc = memory.getOnMemory((short)(pc+1));
                break;
            case 16:
                pc = sp;
                break;
            default:
                config.setLog("Ooops! Assembler: Command not defined!");
                
        }
        config.reloadDisplayLabels(pc, sp, accumulator, sp, re, ri);
    }
    
    /**
     * Encaminha para o catalago a nova linha
     *  para ser processado por ele
     * @param line 
     */
    public void setNewLine(String line){
       commands.insertLine(line);
    }
    
    /**
     * reseta o accumulador, sp, ri, re,pc  para zero 
     *  e os seus respectivos na interface.
     * 
     */
    public void resetAssembler(){
        accumulator = 0;
        sp = 0;
        ri = 0;
        re = 0;
        pc = 0;
        config.reloadDisplayLabels(pc, sp, accumulator, sp, re, ri);
    }
}
