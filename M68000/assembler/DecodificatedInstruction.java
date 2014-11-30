/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assembler;

import M68000.services.Instruction;
import M68000.services.Memory;
import M68000.services.Registers;
import M68000.services.TableSymbol;
import M68000.services.TableUsage;

/**
 *
 * @author RAdC
 */
public class DecodificatedInstruction {
    
    private static TableSymbol simbolos     = TableSymbol.getInstance();
    private static Memory memoria           = Memory.getInstance();
    private static TableUsage usos          = TableUsage.getInstance();
    private static Registers  registers     = Registers.getInstance();
    
    private int bits;
    String byte_1;
    String byte_2;
    //teste
    String wordImediato;
    
    
    public DecodificatedInstruction(Instruction inst) {
        
        if(inst.getOperation().contains("ASR")){
            int operando1, operando2;
            
            if(inst.getNumberOfOperators() == 1){
                ASR_ea(inst);
            }else{
                operando1 = tipoOperando(inst.getOperator1());
                operando2 = tipoOperando(inst.getOperator2());
                if(operando1 == 0 && operando2 == 0){
                    ASR_Dx_Dy(inst);
                }else{
                    ASR_Dy(inst);
                }
            }
            return;
        }
        if(inst.getOperation().contains("ASL")){
            int operando1, operando2;
            
            if(inst.getNumberOfOperators() == 1){
                ASL_ea(inst);
            }else{
                operando1 = tipoOperando(inst.getOperator1());
                operando2 = tipoOperando(inst.getOperator2());
                if(operando1 == 0 && operando2 == 0){
                    ASL_Dx_Dy(inst);
                }else{
                    ASL_Dy(inst);
                }
            }
            return;
        }
        if(inst.getOperation().contains("LSR")){
            int operando1, operando2;
            
            if(inst.getNumberOfOperators() == 1){
                LSR_ea(inst);
            }else{
                operando1 = tipoOperando(inst.getOperator1());
                operando2 = tipoOperando(inst.getOperator2());
                if(operando1 == 0 && operando2 == 0){
                    LSR_Dx_Dy(inst);
                }else{
                    LSR_Dy(inst);
                }
            }
            return;
        }
        if(inst.getOperation().contains("LSL")){
            int operando1, operando2;
            
            if(inst.getNumberOfOperators() == 1){
                LSL_ea(inst);
            }else{
                operando1 = tipoOperando(inst.getOperator1());
                operando2 = tipoOperando(inst.getOperator2());
                if(operando1 == 0 && operando2 == 0){
                    LSL_Dx_Dy(inst);
                }else{
                    LSL_Dy(inst);
                }
            }
            return;
        }
        
        if(inst.getOperation().contains("ADD")){     
            R(inst);
            return;
        }
        
        if(inst.getOperation().contains("AND")){
            R(inst);
            return;
        }
                
        if(inst.getOperation().contains("CMP")){
            R(inst);
            return;
        }
        if(inst.getOperation().contains("OR") && !inst.getOperation().contains("ORG")){
            R(inst);
            return;
        }
        
        if(inst.getOperation().contains("SUB")){
            R(inst);
            return;
        }
        
        if(inst.getOperation().contains("MUL") || inst.getOperation().contains("DIV")){
            Mul_Div(inst);
            return;
        }
        
        if(inst.getOperation().contains("CLR")){
            CLR(inst);
            return;
        }
        
        if(inst.getOperation().contains("RTS")){
            RTS();
            return;
        }
        
        if(inst.getOperation().contains("STOP")){
            STOP();
            return;
        }
        
        if(inst.getOperation().contains("MOVE")){
            Move(inst);
            return;
        }
        
        if(inst.getOperation().contains("BRA") || inst.getOperation().contains("BEQ") || inst.getOperation().contains("BSR") || inst.getOperation().contains("BNE")){
            branch(inst);
            return;
        }
        
        if(inst.getOperation().contains("ORG")){
            
        
        }
    }
    
 
    /*
     * CONJUNTO DE INSTRUÇÕES DE DESLOCAMENTO
     * EXISTEM 4 TIPOS DE INSTRUÇÕES, SENDO QUE AS MESMAS
     *  EM 3 SUBGRUPOS CADA
     * 
     * ASR, ASL, LSR, LSL
     */ 
    
    private void ASR_Dx_Dy (Instruction inst){
        this.byte_1 = "11100000";
        this.byte_2 = "00";
        
        this.byte_2 = this.byte_2 + intToBin(inst.getOperator1().charAt(1)) + intToBin(inst.getOperator2().charAt(1));
    }
   
    private void ASR_Dy (Instruction inst){
        this.byte_1 = "11100000";
        this.byte_2 = "10";
        
        this.byte_2 = this.byte_2 + "000" +intToBin(inst.getOperator2().charAt(1));
        
        this.wordImediato = imediatoToString(inst.getOperator1());
    }
    
    private void ASR_ea (Instruction inst){
        int tipo;
        
        this.byte_1 = "11100000";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        this.byte_2 = "01";
        
        tipo = tipoOperando(inst.getOperator1());
        
        if(tipo == 0){ //DN
            this.byte_2 = this.byte_2 + "000" + intToBin(inst.getOperator1().charAt(1));
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            return;
        }
        if (tipo == 2){ //(AN)
          this.byte_2 = this.byte_2 + "010" + intToBin(inst.getOperator1().charAt(2));
          memoria.insereByteMemoria(this.byte_2.toCharArray());
          return;
        }
        if (tipo == 4){ //(END)
            this.byte_2 = this.byte_2 + "010" + "100";
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            resolveSimbolo(inst.getOperator1());

        }
    }
    
    private void ASL_Dx_Dy (Instruction inst){
        this.byte_1 = "11100001";
        this.byte_2 = "00";
        
        this.byte_2 = this.byte_2 + intToBin(inst.getOperator1().charAt(1)) + intToBin(inst.getOperator2().charAt(1));
    }
    
    private void ASL_Dy (Instruction inst){
        this.byte_1 = "11100001";
        this.byte_2 = "10";
        
        this.byte_2 = this.byte_2 + "000" +intToBin(inst.getOperator2().charAt(1));
        
        this.wordImediato = imediatoToString(inst.getOperator1());
    }
    
    private void ASL_ea (Instruction inst){
        int tipo;
        
        this.byte_1 = "11100001";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        this.byte_2 = "01";
        
        tipo = tipoOperando(inst.getOperator1());
        
        if(tipo == 0){ //DN
            this.byte_2 = this.byte_2 + "000" + intToBin(inst.getOperator1().charAt(1));
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            return;
        }
        if (tipo == 2){ //(AN)
          this.byte_2 = this.byte_2 + "010" + intToBin(inst.getOperator1().charAt(2));
          memoria.insereByteMemoria(this.byte_2.toCharArray());
          return;
        }
        if (tipo == 4){ //(END)
            
            this.byte_2 = this.byte_2 + "010" + "100";
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            resolveSimbolo(inst.getOperator1());

        }
    }
    
    private void LSR_Dx_Dy (Instruction inst){
        this.byte_1 = "11100010";
        this.byte_2 = "00";
        
        this.byte_2 = this.byte_2 + intToBin(inst.getOperator1().charAt(1)) + intToBin(inst.getOperator2().charAt(1));
    }
    
    private void LSR_Dy (Instruction inst){
        this.byte_1 = "11100010";
        this.byte_2 = "10";
        
        this.byte_2 = this.byte_2 + "000" +intToBin(inst.getOperator2().charAt(1));
        
        this.wordImediato = imediatoToString(inst.getOperator1());
    }
    
    private void LSR_ea (Instruction inst){
        int tipo;
        
        this.byte_1 = "11100010";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        this.byte_2 = "01";
        
        tipo = tipoOperando(inst.getOperator1());
        
        if(tipo == 0){ //DN
            this.byte_2 = this.byte_2 + "000" + intToBin(inst.getOperator1().charAt(1));
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            return;
        }
        if (tipo == 2){ //(AN)
          this.byte_2 = this.byte_2 + "010" + intToBin(inst.getOperator1().charAt(2));
          memoria.insereByteMemoria(this.byte_2.toCharArray());
          return;
        }
        if (tipo == 4){ //(END)
            
            this.byte_2 = this.byte_2 + "010" + "100";
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            resolveSimbolo(inst.getOperator1());
 
        }
    }    
    
   private void LSL_Dx_Dy (Instruction inst){
        this.byte_1 = "11100011";
        this.byte_2 = "00";
        
        this.byte_2 = this.byte_2 + intToBin(inst.getOperator1().charAt(1)) + intToBin(inst.getOperator2().charAt(1));
    }
   
   private void LSL_Dy (Instruction inst){
        this.byte_1 = "11100011";
        this.byte_2 = "10";
        
        this.byte_2 = this.byte_2 + "000" +intToBin(inst.getOperator2().charAt(1));
        
        this.wordImediato = imediatoToString(inst.getOperator1());
    }
   
   private void LSL_ea (Instruction inst){
        int tipo;
        
        this.byte_1 = "11100011";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        this.byte_2 = "01";
        
        tipo = tipoOperando(inst.getOperator1());
        
        if(tipo == 0){ //DN
            this.byte_2 = this.byte_2 + "000" + intToBin(inst.getOperator1().charAt(1));
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            return;
        }
        if (tipo == 2){ //(AN)
          this.byte_2 = this.byte_2 + "010" + intToBin(inst.getOperator1().charAt(2));
          memoria.insereByteMemoria(this.byte_2.toCharArray());
          return;
        }
        if (tipo == 4){ //(END)
            
            this.byte_2 = this.byte_2 + "010" + "100";
            memoria.insereByteMemoria(this.byte_2.toCharArray());
            resolveSimbolo(inst.getOperator1());
        }
    }
    
   
   /*
    * CONJUNTO DE INSTRUÇÕES TRIVIAIS
    *   RTS, STOP
    */
   
   private void R (Instruction inst){
       char D0;
       int operando;
       char operando_n;
       boolean label = false;
       boolean imm = false;
       boolean equ = false;
       String M = "";
       String Xn = "";       
       this.byte_1 = tipo_R(inst.getOperation());
       
       if(tipoOperando(inst.getOperator2()) == 0){ // R x,D (D armazena)
           D0 = '0';
           this.byte_1 = this.byte_1 + intToBin(inst.getOperator2().charAt(1)) + D0;
           memoria.insereByteMemoria(this.byte_1.toCharArray());
                      
           operando = tipoOperando(inst.getOperator1());
           
           
           /*
            * Aqui configura Xn e Dn
            * Descobre se é imediato, equivalencia ou sei lá o que
            */
           
           if(operando == 0){
               M = "000";
               operando_n = inst.getOperator1().charAt(1);
               Xn = intToBin(operando_n);
           }else{
               if(operando == 1){
                    M = "001";
                    operando_n = inst.getOperator1().charAt(1);
                    Xn = intToBin(operando_n);
               }else{
                   if(operando == 2){
                        M = "010";
                        operando_n = inst.getOperator1().charAt(2);
                        Xn = intToBin(operando_n);   
                   }else{
                       if(operando == 3){
                            M = "111";
                            Xn = "100";
                            imm = true;
                       }else{
                           if(operando == 4){
                                M = "100";
                                Xn = "100";
                                label = true;
                           }else{
                               if(operando == 5){
                                   M = "111";
                                   Xn = "100";
                                   equ = true;
                               }else{
                                   System.out.println("Erro em M (operando inexistente)");
                               }
                               
                           }
                       }
                   }
               }
           }
           
           this.byte_2 = "01" + M + Xn;
           memoria.insereByteMemoria(this.byte_2.toCharArray());
           
           /*
            * Aqui se tem que adicionar mais porcaria na memória
            * ele vai lá e adiciona e pronto
            * 
            * Dá erro? Vai saber, nem testei!
            */
           
           if(label){
               resolveSimbolo(inst.getOperator1());
           }
           if(equ){
               resolveEquivalencia(inst.getOperator1());
           }
           if(imm){
               resolveImediato(inst.getOperator1());
           }
           
       }else{ // R D,x (x armazena)
           if(tipoOperando(inst.getOperator1()) == 0){
                D0 = '1';
               
                if("CMP".equals(inst.getOperation())){
                    System.out.println("CMP mal formatado!");
                }
                
                this.byte_1 = this.byte_1 + intToBin(inst.getOperator1().charAt(1)) + D0;
                memoria.insereByteMemoria(this.byte_1.toCharArray());
               
                operando = tipoOperando(inst.getOperator2());
           
                if(operando == 0){
                    M = "000";
                    operando_n = inst.getOperator2().charAt(1);
                    Xn = intToBin(operando_n);
                }else{
                    if(operando == 1){
                            M = "001";
                            operando_n = inst.getOperator2().charAt(1);
                            Xn = intToBin(operando_n);
                    }else{
                        if(operando == 2){
                                M = "010";
                                operando_n = inst.getOperator2().charAt(2);
                                Xn = intToBin(operando_n);   
                        }else{
                            if(operando == 3){
                                    M = "111";
                                    Xn = "100";
                                    System.out.print("Erro em R: #imm não pode receber valor");
                            }else{
                                if(operando == 4){
                                        M = "100";
                                        Xn = "100";
                                        label = true;
                                }else{
                                    if(operando == 5){
                                        M = "111";
                                        Xn = "100";
                                        equ = true;
                                    }else{
                                        System.out.println("Erro em M");
                                    }
                                    
                                }
                            }
                        }
                    }
                }
               
                this.byte_2 = "01" + M + Xn;
                memoria.insereByteMemoria(this.byte_2.toCharArray());
                if(label){
                    resolveSimbolo(inst.getOperator2());
                }
                if(equ){
                    resolveEquivalencia(inst.getOperator2());
                }
                if(imm){
                    resolveImediato(inst.getOperator2());
                }
               
           }else{
               System.out.println("Erro R (Não usa D)\n");
           }
       }
   }
   
   private void branch(Instruction inst){
       this.byte_1 = "0110";
       
       if("BRA".equals(inst.getOperation())){
           this.byte_1 = this.byte_1 + "0000";
       }else{
           if("BSR".equals(inst.getOperation())){
               this.byte_1 = this.byte_1 + "0001";
           }else{
               if("BNE".equals(inst.getOperation())){
                   this.byte_1 = this.byte_1 + "0110";
               }else{
                   if("BEQ".equals(inst.getOperation())){
                       this.byte_1 = this.byte_1 + "0111";
                   }else{
                       System.out.println("Erro em Branch");
                   }
               }
           }
       }
       
       memoria.insereByteMemoria(this.byte_1.toCharArray());
       memoria.insereByteMemoria("00000000".toCharArray());
       
       resolveSimbolo(inst.getOperator1());
   }
   
   private void CLR (Instruction inst){
       int operando;
       String M,Xn;
       char operando_n;
       
       M = "";
       Xn = "";
       
       this.byte_1 = "01000010";
       memoria.insereByteMemoria(this.byte_1.toCharArray());
       
       operando = tipoOperando(inst.getOperator1());
       
       if(operando == 0){
            M = "000";
            operando_n = inst.getOperator1().charAt(1);
            Xn = intToBin(operando_n);
       }else{
           if(operando == 2){
                M = "010";
                operando_n = inst.getOperator2().charAt(2);
                Xn = intToBin(operando_n);
           }else{
               if(operando == 4){
                   M = "100";
                   Xn = "100";
               }else{
                   System.out.println("Erro em CLR, tipo inválido!");
               }
           }
       }
       
       this.byte_2 = "01" + M + Xn;
       memoria.insereByteMemoria(this.byte_2.toCharArray());
       
       if(operando == 4){
           resolveSimbolo(inst.getOperator1());
       }
       
   }
   
    private void RTS (){
        this.byte_1 = "01001110";
        this.byte_2 = "01110101";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        memoria.insereByteMemoria(this.byte_2.toCharArray());
    }

    
    private void STOP (){
        this.byte_1 = "01001110";
        this.byte_2 = "01110010";
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        memoria.insereByteMemoria(this.byte_2.toCharArray());
    }
    
    private static String intToBin (char entrada){
        if(entrada == '0'){
            return "000";
        }
        if(entrada == '1'){
            return "001";
        }
        if(entrada == '2'){
            return "010";
        }
        if(entrada == '3'){
            return "011";
        }
        if(entrada == '4'){
            return "100";
        }
        if(entrada == '5'){
            return "101";
        }
        if(entrada == '6'){
            return "110";
        }
        if(entrada == '7'){
            return "111";
        }
        
        return "false";
    }
    
    private void Mul_Div (Instruction inst){
        int operando;
        String Dx;
        char S_U;
        boolean equ = false;
        boolean imm = false;
        boolean label = false;
        String M, Xn;
        char operando_n;
        
        M="";
        Xn="";
        
        if(inst.getOperation().contains("MUL")){
            this.byte_1 = "1000";
        }else{
            this.byte_1 = "1100";
        }
        
        operando = tipoOperando(inst.getOperator2());
        
        if(operando != 0){
            System.out.println("MUL_DIV Error!: Resultado não vai para Dx");
            System.out.println(inst.getOperation() + " "+ inst.getOperator1() + " " + inst.getOperator2());
        }
        
        Dx = intToBin(inst.getOperator2().charAt(1));
        
        if (inst.getOperation().charAt(3) == 'S'){
            S_U = '1';
        }else{
            S_U = '0';
        }
     
        this.byte_1 = this.byte_1 + Dx + S_U;
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        
            
        if(operando == 0){
            M = "000";
            operando_n = inst.getOperator1().charAt(1);
               Xn = intToBin(operando_n);
        }else{
            if(operando == 1){
                System.out.println("MUL_DIV Error!: Tá usando Ax Mano! Não pode!");
                System.out.println(inst.getOperation() + " "+ inst.getOperator1() + " " + inst.getOperator2());
                M = "001";
                operando_n = inst.getOperator1().charAt(1);
                Xn = intToBin(operando_n);
            }else{
                if(operando == 2){
                    M = "010";
                    operando_n = inst.getOperator1().charAt(2);
                    Xn = intToBin(operando_n);   
                }else{
                    if(operando == 3){
                        M = "111";
                        Xn = "100";
                        imm = true;
                    }else{
                        if(operando == 4){
                            M = "100";
                            Xn = "100";
                            label = true;
                        }else{
                            if(operando == 5){
                                M = "111";
                                Xn = "100";
                                equ = true;
                            }else{
                                System.out.println("Erro em M (operando inexistente)");
                            }

                        }
                    }
                }
            }
        }
        
        if(label){
            resolveSimbolo(inst.getOperator1());
        }
        if(equ){
            resolveEquivalencia(inst.getOperator1());
        }
        if(imm){
            resolveImediato(inst.getOperator1());
        }
        
        this.byte_2 = "11" + M + Xn;
        memoria.insereByteMemoria(this.byte_2.toCharArray());
    }
    
    private void Move (Instruction inst){
        this.byte_1 = "0001";
        int operando1,operando2;
        char operando_n;
       
        String M1,Xn1,M2,Xn2;
        boolean equ = false, label1 = false, label2 = false,imm = false;
          
        M1 = "";
        Xn1 = "";
        M2 = "";
        Xn2 = "";
        
        operando1 = tipoOperando(inst.getOperator1());
        operando2 = tipoOperando(inst.getOperator2());
        
        if(operando1 == 0){
            M1 = "000";
            operando_n = inst.getOperator1().charAt(1);
               Xn1 = intToBin(operando_n);
        }else{
            if(operando1 == 1){
                M1 = "001";
                operando_n = inst.getOperator1().charAt(1);
                Xn1 = intToBin(operando_n);
            }else{
                if(operando1 == 2){
                    M1 = "010";
                    operando_n = inst.getOperator1().charAt(2);
                    Xn1 = intToBin(operando_n);   
                }else{
                    if(operando1 == 3){
                        M1 = "111";
                        Xn1 = "100";
                        imm = true;
                    }else{
                        if(operando1 == 4){
                            M1 = "100";
                            Xn1 = "100";
                            label1 = true;
                        }else{
                            if(operando1 == 5){
                                M1 = "111";
                                Xn1 = "100";
                                equ = true;
                            }else{
                                System.out.println("Erro em M (operando inexistente)");
                            }

                        }
                    }
                }
            }
        }
        
        this.byte_1 = this.byte_1 + Xn1 + M1.charAt(0);
                
        
                
        this.byte_2 = "";
        this.byte_2 = this.byte_2 + M1.charAt(1) + M1.charAt(2);
        
        if(operando2 == 0){
            M2 = "000";
            operando_n = inst.getOperator2().charAt(1);
            Xn2 = intToBin(operando_n);
        }else{
            if(operando2 == 1){
                M2 = "001";
                operando_n = inst.getOperator2().charAt(1);
                Xn2 = intToBin(operando_n);
                System.out.println("Erro: An não pode receber valor!");
            }else{
                if(operando2 == 2){
                    M2 = "010";
                    operando_n = inst.getOperator2().charAt(2);
                    Xn2 = intToBin(operando_n);   
                }else{
                    if(operando2 == 3){
                        M2 = "111";
                        Xn2 = "100";
                        imm = true;
                        System.out.println("Erro: imediato não pode receber valor!");
                    }else{
                        if(operando2 == 4){
                            M2 = "100";
                            Xn2 = "100";
                            label2 = true;
                        }else{
                            if(operando2 == 5){
                                M2 = "111";
                                Xn2 = "100";
                                equ = true;
                                System.out.println("Erro: imediato (EQU) não pode receber valor!");
                            }else{
                                System.out.println("Erro em M (operando inexistente)");
                            }

                        }
                    }
                }
            }
        }// fim if e else
        
        this.byte_2 = this.byte_2 + M2 + Xn2;
                
        memoria.insereByteMemoria(this.byte_1.toCharArray());
        memoria.insereByteMemoria(this.byte_2.toCharArray());
                
        if(label1){
            resolveSimbolo(inst.getOperator1());
        }
        if(equ){
            resolveEquivalencia(inst.getOperator1());
        }
        if(imm){
            resolveImediato(inst.getOperator1());
        }
        
        if(label2){
            resolveSimbolo(inst.getOperator2());
        }
        
    }
    
    /*
     * Entrada: #4
     * Saida: 000000000000000...100
     */
    private static String imediatoToString(String imediato){
        int entradaInt;
        String string_intermediaria = "";
        String resposta = "";
        
        Integer.getInteger(imediato);
        for(int i = 1; i < imediato.length();i++){
            string_intermediaria = string_intermediaria + imediato.charAt(i);
        }
        
        entradaInt = Integer.parseInt(string_intermediaria);

        string_intermediaria = Integer.toBinaryString(entradaInt);

        for (int i = 0 ; i < (32 - string_intermediaria.length()); i++){
                resposta =  resposta + '0';            
            }        
            for (int i = 0, j = 32-string_intermediaria.length() ; i < string_intermediaria.length() ; i++ , j++){
                resposta = resposta + string_intermediaria.charAt(i);
            }
        
        return resposta;
    }
    /*
     * 0 : D
     * 1 : A
     * 2 : (A)
     * 3 : #
     * 4 : 32 bits
     * 5 : EQU
     */
    
    private static int tipoOperando(String entrada){
        if(entrada.charAt(0) == '#'){
            return 3;
        }else{
            if(entrada.length() == 2){
                if(entrada.charAt(0) == 'D'){
                    return 0;                   
                }
                if(entrada.charAt(0) == 'A'){
                    return 1;
                }
            }
        }
        //(A5)
        if(entrada.length() == 4){
            if(entrada.charAt(0) == '(' && entrada.charAt(1) == 'A' && entrada.charAt(3) == ')'){
                return 2;
            }
        }
        
        if(simbolos.contemEQU(entrada)){
            return 5;
        }
        
        return 4;
    }
    
    private static String tipo_R (String instrucao) {
        if("ADD".equals(instrucao))        
            return "1101";
        
        if("AND".equals(instrucao))
            return "1100";
        
        if("CMP".equals(instrucao))
            return "1011";
        
        if("OR".equals(instrucao))
            return "1000";
        
        if("SUB".equals(instrucao))
            return "1001";
                
        System.out.println("Erro encontrado em tipo R");
        return "";
        
    }
    
    private static void resolveSimbolo (String identificador){
        if(simbolos.contemSimbolo(identificador)){
            if(simbolos.simboloDefinido(identificador)){
                usos.insereUso(identificador, registers.getPC());
                memoria.insertWordMemory(simbolos.getAndress(identificador).getAnddressWord());
            }else{
                usos.insereUso(identificador, registers.getPC());
                memoria.insertWordMemory("00000000000000000000000000000000".toCharArray());
            }
        }else{
            simbolos.adicionaSimbolo(identificador);
            usos.insereUso(identificador, registers.getPC());
            memoria.insertWordMemory("00000000000000000000000000000000".toCharArray());
        }
    }
    
    private static void resolveEquivalencia (String identificador){
        char[] valor;
        
        valor = simbolos.getWordEQU(identificador);
        
        memoria.insertWordMemory(valor);
    }
    
    private static void resolveImediato (String imediato){
        String valor;
        valor = imediatoToString(imediato);
        memoria.insertWordMemory(valor.toCharArray());
    }
}
