/*
 * Classe que executa o sistema
 */

/**
 *
 * @author glaucomunsberg
 */

public class Principal {
    
    private static GuiView app;
    
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
    
    public static void main(String [] args)
    {
          Principal programa = new Principal();
    }
    
}
