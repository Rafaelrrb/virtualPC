package M68000;

import M68000.loader.Loader;
import M68000.macro.Macro;

/*
 * Classe que executa o sistema Moto 68k
 */

/**
 *
 * @author glaucomunsberg
 */

public class PrincipalTesteMacro {
    
   
    
    /**
     * Esta é a Classe Principal do Sistema e instancia a interface o Calingaert
     */
    public PrincipalTesteMacro(){
    
    
    
    
    }
     
    //  /Users/glaucomunsberg/Projetos/virtualPC/M68000/example/code_simple_2
    /**
     * Método main e não precisa de parâmetros
     * @param args
     */
    public static void main(String [] args)
    {
        
        String texto[] = new String[10];
        
        texto[0]="SAV2    MACRO";
        texto[1]="MOVE.L    \\1,SAVET;       SAVE 1ST ARGUMENT";    
        texto[2]="MOVE.L    \\2,SAVET+4;     SAVE 2ND ARGUMENT";
        texto[3]="IFEQ      '\\3','';        IS THERE A 3RD ARGUMENT?";
        texto[4]="FAIL      1000;           DID ASSEMBLER GO THRU HERE?";
        texto[5]="FAIL      1000;           DID ASSEMBLER GO THRU HERE?";
        texto[6]="MEXIT                    NO, EXIT FROM MACRO";
        texto[7]="ENDC";
        texto[8]="MOVE.L    \\3,SAVET+8;     SAVE 3RD ARGUMENT";
        texto[9]="ENDM";
        
        
        
        
        
        Macro macr = new Macro();
        
        
        System.out.println(macr.processText(texto));
    }
    
}
