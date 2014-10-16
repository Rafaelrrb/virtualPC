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
public class Calingaert {
    
    private final Config config;
    private final Memory memory;
    private Catalog commands;
    private short accumulator;
    private boolean isStoped;
    private boolean isStaredComputed;
    private boolean isStreamMemoryWanted;
    private short pc;
    private short sp;
    private short ri;
    private short re;
    private short streamMemoryPositionWanted;
    
    
    public Calingaert(){
        config      = Config.getInstance();
        memory      = Memory.getInstance();
        commands    = Catalog.getInstance();
        accumulator = 0;
        sp          = 0;
        ri          = 0;
        re          = 0;
        pc          = 0;
        isStoped    = false;
        isStaredComputed    = false;
        isStreamMemoryWanted = true;
    }
    
    /**
     * Método que começa a execução do sistema
     *  ele é dispara com o 'start' na interface
     *  e executa de acordo com o modo de execução
     */
    public void start(){
        this.isStaredComputed=true;
        config.setLog(String.format("Mode selected: %d", config.getComboBoxModeSelected()));
        if(memory.getPosition() == 0){
            config.setLog("Ooops! Calingaert: Memory Empty");
            return;
        }
        switch(config.getComboBoxModeSelected()){
            case 0:
                while(!this.isStoped){

                    this.nextStep();
                
                }
                break;
            case 1:
                
                break;
            case 2:
                this.nextStep();
                break;
        
        }
        
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
        if(config.getComboBoxModeSelected() == 0){
            return;
        }
        this.isStaredComputed=true;
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
                short valueDivisor = memory.getOnMemory((short)(pc+1));
                accumulator = (short)(accumulator /valueDivisor);
                pc = (short) (pc+2);
                break;
            case 11:
                //STOP
                this.isStoped = true;
                break;
            case 12:
                //STREAM
                config.setOutPut("Digite o valor");
                isStreamMemoryWanted = true;
                this.streamMemoryPositionWanted = memory.getOnMemory((short)(pc+1));
                
                break;
            case 13:
                //COPY
                short positionTo = memory.getOnMemory((short)(pc+2));
                re =(short)  (pc+1);
                memory.setOnMemory(positionTo, memory.getOnMemory((short)(pc+1)));
                pc = (short) (pc+3);
                break;
            case 14:
                //MULT
                short valueMult = memory.getOnMemory((short)(pc+1));
                accumulator = (short)(accumulator /valueMult);
                pc = (short) (pc+2);
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
                config.setLog("Ooops! Calingaert: Command "+ri+" not defined!");
                
        }
        config.reloadDisplayLabels(pc, sp, accumulator, sp, re, ri);
    }
    
    /**
     * Encaminha para o catalago a nova linha
     *  para ser processado por ele
     * @param line 
     */
    public void setNewLine(String line){
       if(this.isStaredComputed){
           if(this.isStreamMemoryWanted){
           
               try{
                   memory.setOnMemory(streamMemoryPositionWanted, Short.parseShort(line));
                   isStreamMemoryWanted = false;
                   pc = (short) (pc+2);
               }catch(Exception e){
                   e.printStackTrace();
               }
           }
       }else{
           commands.insertLine(line);
       }
       
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
        this.isStaredComputed=false;
        this.isStoped   =false;
        this.streamMemoryPositionWanted = 0;
    }
}
