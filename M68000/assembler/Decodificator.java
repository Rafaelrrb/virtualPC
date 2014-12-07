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
            logger.info("New Label: "+instruction.getLabel()+" at "+registers.getPC());
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
                ADD(instruction);
                break;
            case "ADDA":
                ADDA(instruction);
                break;
            case "ADDI":
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
            case "CMPA":
                CMPA(instruction);
                break;
            case "CMPI":
                CMPI(instruction);
                break;
            case "CMP2":
                CMP2(instruction);
                break;
            case "DIVS":
                DIVS(instruction);
                break;
            case "DIVU":
                DIVU(instruction);
                break;
            case "EXT":
                EXT(instruction);
                break;
            case "EXTB":
                EXTB(instruction);
                break;
            case "MULTS":
                MULTS(instruction);
                break;
            case "MULTU":
                MULTS(instruction);
                break;
            case "SUB":
                SUB(instruction);
                break;
            case "SUBA":
                SUBA(instruction);
                break;
            case "SUBI":
                SUBI(instruction);
                break;
            case "SUBQ":
                SUBQ(instruction);
                break;
            case "SUBX":
                SUBQ(instruction);
                break;
            case "AND":
                AND(instruction);
                break;
            case "ADDQ":
                ADD(instruction);
                break;
            case "ANDI":
                ANDI(instruction);
                break;
            case "ADDX":
                ADDX(instruction);
                break;
            case "EOR":
                EOR(instruction);
                break;
            case "EORI":
                EORI(instruction);
                break;
            case "OR":
                OR(instruction);
                break;
            case "ORI":
                ORI(instruction);
                break;
            case "BCC":
                BCC(instruction);
                break;
        }
    }
    
    
    private void ADD(Instruction instruction){
        if( isARegisterD(instruction.getOperator1())){
            
            if(isRegister(instruction.getOperator2())){
                logger.warning("Instrução ADD mal formada: "+instruction.toString());
            }else{
                
                objectCode.setNewLine(1, 'A');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1().substring(1, instruction.getOperator1().length())), 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator2()), 'R');
            }
            
        }else{
            if(isARegisterD(instruction.getOperator2())){
                objectCode.setNewLine(2, 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
            }else{
                if( isARegisterA(instruction.getOperator2())){
                    objectCode.setNewLine(3, 'A');
                    objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                    objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
                }else{
                    logger.warning("Instrução ADD mal formada: "+instruction.toString());
                }
            }
            
            
        }
    
    }
    
    private void ADDA(Instruction instruction){
        if( instruction.getOperator1().charAt(0) == 'D'){
            
            if(isRegister(instruction.getOperator2())){
                logger.warning("Instrução ADD mal formada: "+instruction.toString());
            }else{
                
                objectCode.setNewLine(4, 'A');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1().substring(1, instruction.getOperator1().length())), 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator2()), 'R');
            }
            
        }else{
            if( isARegisterD( instruction.getOperator2() ) ){
                objectCode.setNewLine(5, 'A');
                objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
            }else{
                if( isARegisterA( instruction.getOperator2() ) ){
                    objectCode.setNewLine(6, 'A');
                    objectCode.setNewLine(solveEA(instruction.getOperator1()), 'R');
                    objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2().substring(1, instruction.getOperator2().length())), 'A');
                }else{
                    logger.warning("Instrução ADD mal formada: "+instruction.toString());
                }
            }
            
            
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
    
    private void ADDQ(Instruction instruction){
        if( instruction.getOperator1().charAt(0) == '#' ){
            objectCode.setNewLine(7, 'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveEA(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução ADDI mal formada: "+instruction.toString());
        }
    }
    
    private void ADDX(Instruction instruction){
        if( isARegisterD( instruction.getOperator1() ) && isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(9, 'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        
        }else{
            logger.warning("Instrução ADDI mal formada: "+instruction.toString());
        }
        
    }
    
    private void CLR(Instruction instruction){
        objectCode.setNewLine(11, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    private void CMP(Instruction instruction){
        if( isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(12, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'A');
        }else{
        
            logger.warning("Instrução CMP mal formada: "+instruction.toString());
        }
        
    }
    
    private void CMPA(Instruction instruction){
        if( isARegisterA( instruction.getOperator2() ) ){
            objectCode.setNewLine(13, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'A');
        }else{
        
            logger.warning("Instrução CMPA mal formada: "+instruction.toString());
        }
        
    }
    
    private void CMPI(Instruction instruction){
        if( instruction.getOperator1().charAt(0) == '#'){
            objectCode.setNewLine(14, 'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
        
            logger.warning("Instrução CMPI mal formada: "+instruction.toString());
        }
        
    }
    
    private void CMP2(Instruction instruction){
        if( this.isRegister(instruction.getOperator2())){
            objectCode.setNewLine(16, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }else{
            logger.warning("Instrução CMP2 mal formada: "+instruction.toString());
        }
        
    }
    
    private void DIVS(Instruction instruction){
        if( isARegisterD( instruction.getOperator2()) ){
            objectCode.setNewLine(17, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }
    }
    
    private void DIVU(Instruction instruction){
        if( isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(20, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }
    }
    
    public void EXT(Instruction instruction){
        if( isARegisterD ( instruction.getOperator1() ) ){
            objectCode.setNewLine(23, 'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
        }else{
            logger.warning("Instrução EXT mal formada: "+instruction.toString());
        }
        
    }
    
    public void EXTB(Instruction instruction){
        if( isARegisterD( instruction.getOperator1() ) ){
            objectCode.setNewLine(24, 'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
        }else{
            logger.warning("Instrução EXTX mal formada: "+instruction.toString());
        }
    }
    
    public void MULTS(Instruction instruction){
        if( isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(25, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }else{
            logger.warning("Instrução MULTS mal formada: "+instruction.toString());
        }
    }
    
    public void MULTU(Instruction instruction){
        if( isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(28, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }else{
            logger.warning("Instrução MULTU mal formada: "+instruction.toString());
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

    public void SUB(Instruction instruction){
        if( isARegisterD( instruction.getOperator2() ) ){
            objectCode.setNewLine(33, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
        }else{
            if( isARegisterD( instruction.getOperator1() ) ){
            
                objectCode.setNewLine(34, 'A');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            
            }else{
            
                if ( isARegisterA( instruction.getOperator2() ) ) {
                    objectCode.setNewLine(35, 'A');
                    objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                    objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
                } else {
                    logger.warning("Instrução SUB mal formada: " + instruction.toString());
                }
                
            }
            
            
        }
    }
    
    public void SUBA(Instruction instruction){
        
        if(isARegisterD( instruction.getOperator2() )){
            
            objectCode.setNewLine(36, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
            
        }else{
            
            if(isARegisterD( instruction.getOperator1() )){
            
                objectCode.setNewLine(37, 'A');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            
            }else{
            
                if (isARegisterA( instruction.getOperator2() )) {
                    objectCode.setNewLine(38, 'A');
                    objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                    objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator2()), 'A');
                } else {
                    logger.warning("Instrução SUBA mal formada: " + instruction.toString());
                }
                
            }
            
        }
    }
    
    public void SUBI(Instruction instruction){
        
        if(instruction.getOperator1().charAt(0) == '#'){
            objectCode.setNewLine(39,'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução SUBI mal formada: " + instruction.toString());
        }
        
    }
    
    public void SUBQ(Instruction instruction){
        
        if(instruction.getOperator1().charAt(0) == '#'){
            objectCode.setNewLine(40,'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução SUBQ mal formada: " + instruction.toString());
        }
        
    }
    
    public void SUBX(Instruction instruction){
        
        if( isARegisterD( instruction.getOperator1() ) && isARegisterD( instruction.getOperator2() )){
            objectCode.setNewLine(41,'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução SUBX mal formada: " + instruction.toString());
        }
        
    }
    
    public void AND(Instruction instruction){
        
        if( isARegisterD( instruction.getOperator1() ) ){
            
            objectCode.setNewLine(44,'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            
        }else{
            
            if( isARegisterD(instruction.getOperator2() ) ){
                objectCode.setNewLine(43,'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
            
                
            }else{
                logger.warning("Instrução AND mal formada: " + instruction.toString());
            }
        }
        
    }
    
    public void ANDI(Instruction instruction){
        
        if(instruction.getOperator1().charAt(0) == '#'){
            objectCode.setNewLine(45, 'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução ANDI mal formada: " + instruction.toString());
        }
        
    }
    
    public void EOR(Instruction instruction){
    
        if(isARegisterD(instruction.getOperator1())){
        
            objectCode.setNewLine(46, 'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()),'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            
        }else{
            logger.warning("Instrução EOR mal formada: " + instruction.toString());
        }
    }
    
    public void EORI(Instruction instruction){
        
        if(instruction.getOperator1().charAt(0) == '#' ){
        
            objectCode.setNewLine(46, 'A');
            objectCode.setNewLine(this.getValueFromHashTag(instruction.getOperator1()),'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            
        }else{
            logger.warning("Instrução EORI mal formada: " + instruction.toString());
        }
    
    }
    
    public void NOT(Instruction instruction){
        objectCode.setNewLine(48, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    public void OR(Instruction instruction){
        
        if( isARegisterD( instruction.getOperator1() ) ){
            
            objectCode.setNewLine(49,'A');
            objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            
        }else{
            
            if( isARegisterD(instruction.getOperator2() ) ){
                objectCode.setNewLine(50,'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveRegistersByNameToInt(instruction.getOperator1()), 'A');
            
                
            }else{
                logger.warning("Instrução AND mal formada: " + instruction.toString());
            }
        }
        
    }
    
    public void ORI(Instruction instruction){
        
        if(instruction.getOperator1().charAt(0) == '#'){
            objectCode.setNewLine(51, 'A');
            objectCode.setNewLine(getValueFromHashTag(instruction.getOperator1()), 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução ANDI mal formada: " + instruction.toString());
        }
        
    }
    
    public void JUMP(Instruction instruction){
        objectCode.setNewLine(52, 'A');
        objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
    }
    
    public void BCC(Instruction instruction){
    
        if( isLabel(instruction.getOperator1())){
            
            objectCode.setNewLine(53, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            
        }else{
            logger.warning("Instrução BCC mal formada: " + instruction.toString());
        }
    }
    
    private void BRA(Instruction instruction){
        
        if( isLabel(instruction.getOperator1())){
            
            objectCode.setNewLine(54, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            
        }else{
            logger.warning("Instrução BRA mal formada: " + instruction.toString());
        }
        
    }
    
    private void MOVEC(Instruction instruction){
        
        if(isRegister(instruction.getOperator1()) && isRegister(instruction.getOperator2()) ){
            objectCode.setNewLine(55, 'A');
            objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
            objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
        }else{
            logger.warning("Instrução MOVEC mal formada: "+instruction.toString());
        }
    
    }
    
    private void MOVES(Instruction instruction){
        
        if( isRegister(instruction.getOperator1() ) ){
            
            if( isRegister(instruction.getOperator2() ) ){
                objectCode.setNewLine(57, 'A');
                objectCode.setNewLine(solveOperator(instruction.getOperator1()), 'R');
                objectCode.setNewLine(solveOperator(instruction.getOperator2()), 'R');
            }
            
        }else{
            
           if( isRegister( instruction.getOperator2() ) ){
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
        if(this.isRegister(anddress)){
            return solveRegistersByNameToInt(anddress.substring(1, anddress.length()));
        }else{
            return solveEA(anddress);
        }
    }
    
    private boolean isRegister(String string){
        return isARegisterD(string) || isARegisterA(string);
    }
    
    private boolean isARegisterD(String string){
        return string.substring(1, 2).matches("[0-9]") && string.charAt(0) == 'D' && string.length() == 2;
    }
    
    private boolean isARegisterA(String string){
        return string.substring(1, 2).matches("[0-9]") && string.charAt(0) == 'A' && string.length() == 2;
    }
    
    private boolean isLabel(String string){
        return !isRegister(string) && !string.substring(0,1).matches("[0-9]");
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
            logger.info("Label not yeat defined: "+symbol);
            tableSymbols.addSymbol(symbol, false, 0);
            tableUsage.insereUso(tableSymbols.getSymbol(symbol), registers.getPC());
        }
        return 0;
    }
    
    private int getValueFromHashTag(String operator){
        return Integer.parseInt(operator.substring(1, operator.length()));
    }  
}
