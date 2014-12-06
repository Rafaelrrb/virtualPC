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
        texto[0]="MOVE.L    \\1,SAVET;       SAVE 1ST ARGUMENT";    
        
        
        
        Macro macr = new Macro();
        
        
        System.out.println(macr.processText(texto));
    }
    
}
