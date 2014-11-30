/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.services;

public class Instruction {
    private String label;
    private boolean hasLabel;
    
    private String operation;
    private int numberOfOperators;
    
    private String operator1;
    private String operator2;

    /*
     * Construtor
     */
    public Instruction(String str) {
        int caracterCounter;
        
        this.label = "";
        this.operation = "";
        
        if(str.contains(":")){
            hasLabel = true;
            caracterCounter = getLabel(str);
        }else{
            hasLabel = false;
            caracterCounter = 0;
        }
        
        caracterCounter = Instruction.this.getOperation(str,caracterCounter);
        
        if("END".equals(this.operation)){
            return;
        }
        
        this.numberOfOperators = numberOfOperators(str);
        
        if(this.numberOfOperators != 0){
            caracterCounter = Instruction.this.getOperator1(str,caracterCounter);
            if(this.numberOfOperators == 2){
                Instruction.this.getOperator2(str,caracterCounter);
            }
        }
        
        
    }
    
    private int getLabel(String str){
        int i;
        char c;
        i = 0;
        this.label = "";
               
        c = str.charAt(i);
        if(c == ' ' || c == '\t'){
            while(c == ' ' || c == '\t'){
                c = str.charAt(++i);
            }
        }
        while(c != ':'){
            if(c != ' '){
                this.label = this.label + c;
            }
            c = str.charAt(++i);
        }
        i++;
        return i;
        
    }
    
    private int getOperation(String str, int i){
        char c;
        //resposta = "";
        this.operation = "";
        
        c = str.charAt(i);
        if(c == ' ' || c == '\t'){
            while(c == ' ' || c == '\t'){
                i++;
                c = str.charAt(i);
            }
        }
        
        while(c != ' ' &&  c!= '\t' && i < str.length()){
            this.operation = this.operation + c;
            i++;
            if(i == str.length()){
                break;
            }
            c = str.charAt(i);
        }
        
        return i;
    }
    
    private int numberOfOperators(String str){
        if(str.contains(",")){
            return 2;
        }else{
            if("STOP".equals(this.operation) || "RTS".equals(this.operation)){
                return 0;
            }else{
                return 1;
            }
        }
               
    }
    
    private int getOperator1(String str, int i){
        char c;

        this.operator1 = "";
        
        c = str.charAt(i);
        if (c == ' ' || c == '\t'){
            while(c == ' ' || c == '\t'){
                i++;
                c = str.charAt(i);
            }
        }
        while(c != ' ' && c != ',' && i < str.length() ){
            this.operator1 = this.operator1 + c;
            i++;
            if(i == str.length()){
                break;
            }
            c = str.charAt(i);
        }
        
        return i;
    }
    
    private void getOperator2(String str, int i){
        char c;
        this.operator2 = "";
        
        c = str.charAt(i);
        if (c == ' ' || c == ','){
            while(c == ' ' || c == ','){
                i++;
                c = str.charAt(i);
            }
        }
        while(c != ' ' && c != ',' && i < str.length() ){
            this.operator2 = this.operator2 + c;
            i++;
            if(i == str.length()){
                break;
            }
            c = str.charAt(i);
        }
        
        //return;
    }
    
    
    @Override
    public String toString(){
        String resposta;
        
        resposta = this.operation;
        
        if(this.numberOfOperators == 0){
            return resposta;
        }else{
            if(this.numberOfOperators == 1){
                resposta = resposta + " " + this.operator1;
            }else{
                resposta = resposta + " " + this.operator1 + ',' + this.operator2;
            }
        }
        
        return resposta;
    }

    public boolean hasLabel() {
        return hasLabel;
    }

    public String getLabel() {
        return label;
    }

    public int getNumberOfOperators() {
        return numberOfOperators;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperator1() {
        return operator1;
    }

    public String getOperator2() {
        return operator2;
    }
  
}

