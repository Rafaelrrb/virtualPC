package M68000;
/*
 * Classe que executa o sistema Moto 68k
 */

/**
 *
 * @author glaucomunsberg
 */

public class Principal {
    
    private final Interface interfaca;
    
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
    //  /Users/glaucomunsberg/Projetos/virtualPC/M68000/example/code_simple_2
    /**
     * Método main e não precisa de parâmetros
     * @param args
     */
    public static void main(String [] args)
    {
          Principal programa = new Principal();
    }
    
}
