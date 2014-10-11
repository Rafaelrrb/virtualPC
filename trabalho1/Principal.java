
import gui.View;
import java.awt.Frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author glaucomunsberg
 */
public class Principal extends Frame {
    private static View app;
    
    public Principal(){
        app = new View(this, true);
    }
    
    public static void main(String [] args)
    {
          Principal programa = new Principal();
    }
    
}
