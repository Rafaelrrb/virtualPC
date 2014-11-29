package M68000;

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
    
    /**
     * Esta é a Classe Principal do Sistema e instancia a interface o Calingaert
     */
    public Principal(){
        
        FileMananger file = FileMananger.getInstance();
        file.openFile("/Users/glaucomunsberg/Projetos/virtualPC/M68000/example/code_simple_1");
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
