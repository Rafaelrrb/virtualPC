package M68000;

import M68000.assembler.Assembler;
import M68000.assistance.FileMananger;

/*
 * Classe que executa o sistema
 */

/**
 *
 * @author glaucomunsberg
 */

public class Principal {
    
    //private static GuiView app;
    private Assembler assembler;
    
    /**
     * Esta é a Classe Principal do Sistema e instancia a interface o Calingaert
     */
    public Principal(){
       
      assembler = new Assembler();
      assembler.execute("/Users/glaucomunsberg/Projetos/virtualPC/M68000/example/code_simple_2");
    }
    
    /**
     * Método main e não precisa de parâmetros
     * @param args
     */
    public static void main(String [] args)
    {
          Principal programa = new Principal();
    }
    
}
