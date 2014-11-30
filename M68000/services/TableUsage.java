/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.services;

import M68000.assistance.Anddress;
import M68000.assistance.Usage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruhan
 */
public class TableUsage {
    private final static Logger logger = Logger.getLogger(TableUsage.class.getName());
    private final ArrayList<Usage> lista;
    private static volatile TableUsage instance = null;
    private JTable jTableUsage;
    
    
    private TableUsage() {
        lista = new ArrayList();
        logger.info("Table Usage Loaded");
    }
    
    /**
     * Retorna a única instância desta classe
     * @return 
     */
    public static TableUsage getInstance() {
        if (instance == null) {
            synchronized (TableUsage.class) {
                if (instance == null) {
                    instance = new TableUsage();
                }
            }
        }
        return instance;
    }
    
    public void insereUso(Usage uso){
        lista.add(uso);
        printTableUSage();
    }
    
    public void insereUso(String simbolo, Anddress end){
        lista.add(new Usage(simbolo,end));
        printTableUSage();
    }
    
    public void insereUso(String simbolo, int endereco){
        lista.add(new Usage(simbolo,new Anddress(endereco)));
        printTableUSage();
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
    
    public void setTableUsage(JTable table){
        this.jTableUsage = table;
    }
    
    public void printTableUSage(){
        DefaultTableModel model = (DefaultTableModel) jTableUsage.getModel();
        for(int a=0; a < model.getRowCount(); a++){
            model.removeRow(a);
        }
        for(Usage i:lista){
            model.addRow(new Object[]{i.getSimbolo(),String.format("%d", i.getEndereco().getAnddress())});
        }
    }
   
    public void printaUsos(FileOutputStream fos) throws IOException{
        String printa = "";
        for(Usage u : lista){
            printa = "".equals(printa)? u.getEndereco().toString(): printa+" "+u.getEndereco().toString();
        }
        fos.write(printa.getBytes());
    }
    
}
