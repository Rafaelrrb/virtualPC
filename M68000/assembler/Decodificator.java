/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.services.Memory;
import M68000.services.Registers;
import M68000.services.TableSymbol;
import M68000.services.TableUsage;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Decodificator {
    private static volatile Decodificator instance = null;
    private final static Logger logger = Logger.getLogger(Decodificator.class.getName());
    private TableSymbol tableSymbols;
    private TableUsage  tableUsage;
    private Memory memory;
    private Registers registers;
    private ObjectCode objectCode;
    
    private Decodificator(){
        logger.info("Decodificator Loaded");
        tableSymbols = TableSymbol.getInstance();
        memory = Memory.getInstance();
        tableSymbols.resetTableSymbol();
        tableUsage = TableUsage.getInstance();
        registers = Registers.getInstance();
        objectCode = new ObjectCode();
    }
    
    public static Decodificator getInstance() {
        if (instance == null) {
            synchronized (Decodificator.class) {
                if (instance == null) {
                    instance = new Decodificator();
                }
            }
        }
        return instance;
    }
    
    
    public void processInstruction(String line){
        Instruction instruction = new Instruction(line);
        
        logger.info(instruction.toString());
        
        if(instruction.hasLabel()){
            tableSymbols.defineAnddress(instruction.getLabel(), registers.getPC(),true);
            System.out.println("nova label: "+instruction.getLabel()+" at "+registers.getPC());
        }
        
        switch(instruction.getOperation()){
            case "XDEF":
                processGlobalInstruction(instruction,"XDEF");
                break;
            case "XREF":
                processGlobalInstruction(instruction,"XREF");
                break;
            default:
                processInstruction(instruction);
                break;
        }
        
    }
    
    /**
     * Método pelo qual faz a inserção das instruções globais XDEF e XREF nas
     *  tabela utilizaro pelo Assembler
     * @param instruction
     * @param type {"XDEF","XREF"}
     */
    private void processGlobalInstruction(Instruction instruction,String type){
        int start = 0;
        
        if( type.equals("XDEF") ){
           start = instruction.getStringOrigin().indexOf("XDEF");
        }else{
           start = instruction.getStringOrigin().indexOf("XREF");
        }
        
        String labelsGroup = instruction.getStringOrigin().substring(start+5,instruction.getStringOrigin().length());
        int startAt = 0;
        
        /**
         * Processa as labels
         */
        for(int a=0; a < labelsGroup.length(); a++){
            if(labelsGroup.charAt(a) == ','){
                
               tableSymbols.addSymbol(labelsGroup.substring(startAt, a),type.equals("XDEF"), type.equals("XREF"));
               
               startAt = a+1;
            }else{
                if(labelsGroup.charAt(a) == '\t' || labelsGroup.charAt(a) == ' '){
                    startAt = a+1;
                }
            }
        }
        /**
         * última Label
         */
        tableSymbols.addSymbol(labelsGroup.substring(startAt, labelsGroup.length()), type.equals("XDEF"), type.equals("XREF"));
        tableSymbols.printTableSymbol();
    }
    private void processInstruction(Instruction instruction){
        switch(instruction.getOperation()){
            case "ADD":
            case "ADDA":
                ADD(instruction);
                break;
            case "ADDI":
            case "ADDQ":
                ADDI(instruction);
                break;
            case "STOP":
                STOP(instruction);
                break;
            case "NEG":
                NEGX(instruction);
                break;
            case "NEGX":
                NEG(instruction);
                break;
            case "NOT":
                NOT(instruction);
                break;
            case "CLR":
                CLR(instruction);
                break;
            case "JUMP":
                JUMP(instruction);
                break;
            case "BRA":
                BRA(instruction);
                break;
            case "MOVES":
                MOVES(instruction);
                break;
            case "MOVEC":
                MOVEC(instruction);
                break;
            case "CMP":
                CMP(instruction);
                break;
                
        }
    }
    
    private void ADDI(Instruction instruction){
        if( instruction.getOperator1().charAt(0) == '#' ){
            objectCode.setNewLine(7, 'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveEA(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução ADDI mal formada: "+instruction.toString());
        }
    }
    
    private void ADD(Instruction instruction){
        if( instruction.getOperator1().charAt(0) == 'D'){
            
            if(isRegister(instruction.getOperator2())){
                logger.warning("Instrução ADD mal formada: "+instruction.toString());
            }else{
                
                objectCode.setNewLine(1, 'A');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1().substring(1, instruction.getOperator1().length())), 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator2()), 'R');
            }
            
        }else{
            if(instruction.getOperator2().charAt(0)=='D'){
                objectCode.setNewLine(2, 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
            }else{
                if(instruction.getOperator2().charAt(0)=='A'){
                    objectCode.setNewLine(3, 'A');
                    objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                    objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
                }else{
                    logger.warning("Instrução ADD mal formada: "+instruction.toString());
                }
            }
            
            
        }
    
    }
   
    private void CLR(Instruction instruction){
        objectCode.setNewLine(11, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    private void CMP(Instruction instruction){
        if( this.isRegister(instruction.getOperator2())){
            objectCode.setNewLine(12, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
        
            logger.warning("Instrução MOVEC mal formada: "+instruction.toString());
        }
        
    }
    
    public void NEG(Instruction instruction){
        objectCode.setNewLine(31, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    public void NEGX(Instruction instruction){
        objectCode.setNewLine(32, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    public void NOT(Instruction instruction){
        objectCode.setNewLine(48, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    public void JUMP(Instruction instruction){
        objectCode.setNewLine(52, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    private void BRA(Instruction instruction){
        objectCode.setNewLine(54, 'A');
        objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
    }
    
    private void MOVEC(Instruction instruction){
        
        if(isRn(instruction.getOperator1()) && isRn(instruction.getOperator2()) ){
            objectCode.setNewLine(55, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução MOVEC mal formada: "+instruction.toString());
        }
    
    }
    
    private void MOVES(Instruction instruction){
        
        if( isRn(instruction.getOperator1() ) ){
            
            if( isRn(instruction.getOperator2() ) ){
                objectCode.setNewLine(57, 'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            }
            
        }else{
            
           if( isRn( instruction.getOperator2() ) ){
               objectCode.setNewLine(58, 'A');
               objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
               objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
           }else{
               logger.warning("Instrução MOVES mal formada: "+instruction.toString());
           }
             
        }
    }
    
    private void STOP(Instruction instruction){
        objectCode.setNewLine(59, 'A');
        objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
    }
    
    
    private int solveEA(String Instruction){
        if(Instruction.substring(0, 1).matches("[0-9]")){
            return Integer.parseInt(Instruction);
        }
        return solveLabel(Instruction);
    }
            
    private int solveOperator(String anddress){
        if( anddress.charAt(0) == 'D' || anddress.charAt(0) == 'A' ){
            return solveRegistersByNameToInt(anddress.substring(1, anddress.length()));
        }else{
            return solveEA(anddress);
        }
    }
    
    private boolean isRn(String string){
        return isRegister(string) || isNumber(string) ;
    }
    
    private boolean isNumber(String string){
        return string.substring(0, 1).matches("[0-9]");
    }
    private boolean isRegister(String string){
        return string.charAt(0) == 'A' || string.charAt(0)=='D';
    }
    
    private int solveRegistersByNameToInt(String string){
        return Integer.parseInt(string);
    }
    
    private int solveLabel(String symbol){
        if(tableSymbols.hasSymbol(symbol)){
            if(tableSymbols.simboloDefinido(symbol)){
                tableUsage.insereUso(tableSymbols.getSymbol(symbol), registers.getPC());
            }
            return tableSymbols.getSymbol(symbol).getEndereco();
        }else{
            logger.info("Label not yeat defined");
            tableSymbols.addSymbol(symbol, false, 0);
            tableUsage.insereUso(tableSymbols.getSymbol(symbol), registers.getPC());
        }
        return 0;
    }
    
    private int getValueFromHashTag(String operator){
        System.out.println("operator: "+operator.substring(1, operator.length()));
        return Integer.parseInt(operator.substring(1, operator.length()));
    }
    
    private int getIntegerFromString(String operator){
        return Integer.parseInt(operator);
    }
}
