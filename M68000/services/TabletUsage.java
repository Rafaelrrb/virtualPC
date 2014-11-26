/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.services;

import M68000.assistance.Usage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Ruhan
 */
public class TabletUsage {
    private final static Logger logger = Logger.getLogger(TabletUsage.class.getName());
    private final ArrayList<Usage> lista;
        
    public TabletUsage() {
        lista = new ArrayList();
    }
    
    public void insereUso(Usage uso){
        lista.add(uso);
    }
    
    public void insereUso(String simbolo, Anddress end){
        lista.add(new Usage(simbolo,end));
    }
    
    public void insereUso(String simbolo, int endereco){
        lista.add(new Usage(simbolo,new Anddress(endereco)));
    }
    
    public ArrayList<Anddress> returnaUsos(String simbolo){
        
        ArrayList<Anddress> enderecos = new ArrayList();
        
        for (Usage u : lista){
            if(u.getSimbolo().equals(simbolo)){
                enderecos.add(u.getEndereco());
            }
        }
        
        return enderecos;
    }

    public ArrayList<Usage> getLista() {
        return lista;
    }
    
   
    public void printaUsos(FileOutputStream fos) throws IOException{
        String printa = "";
        for(Usage u : lista){
            printa = "".equals(printa)? u.getEndereco().toString(): printa+" "+u.getEndereco().toString();
        }
        fos.write(printa.getBytes());
    }
    
}
