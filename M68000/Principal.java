package M68000;

import M68000.assembler.Assembler;
import M68000.assistance.FileMananger;
import M68000.Interface;
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
    private M68000.Interface interfaca;
    
    /**
     * Esta é a Classe Principal do Sistema e instancia a interface o Calingaert
     */
    public Principal(){
      interfaca = new Interface(new javax.swing.JFrame(), true);
      interfaca.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
      interfaca.setVisible(true);
    }
    ///Users/glaucomunsberg/Projetos/virtualPC/M68000/example/code_simple_2
    /**
     * Método main e não precisa de parâmetros
     * @param args
     */
    public static void main(String [] args)
    {
          Principal programa = new Principal();
    }
    
}
