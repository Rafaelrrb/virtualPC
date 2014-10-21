/*
 * Classe que executa o sistema
 */

/**
 *
 * @author glaucomunsberg
 */

public class Principal {
    
    private static GuiView app;
    
    /**
     * Esta é a Classe Principal do Sistema e instancia a interface o Calingaert
     */
    public Principal(){
        
        app = new GuiView(new javax.swing.JFrame(), true);
        app.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
        app.setVisible(true);
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
