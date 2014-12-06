/*
 * Tabela de Uso, ou TableUsage é a tabela que ontem todos os
 *  usos do sistema Moto 68k
 */
package M68000.services;

import M68000.assistance.Anddress;
import M68000.assistance.Symbol;
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
    private JTable jTableAssemblerUsage;
    private JTable jTableXREF;
    
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
    
    public void insereUso(Symbol simbolo, Anddress end){
        lista.add(new Usage(simbolo,end));
        printTableUSage();
    }
    
    public void insereUso(Symbol simbolo, int endereco){
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
    
    public void setTableAssemblerUsage(JTable table){
        this.jTableAssemblerUsage = table;
    }
    
    public void setTableXREF(JTable table){
        this.jTableXREF = table;
    }
    
    public void printTableUSage(){
        DefaultTableModel model;
        if(jTableAssemblerUsage != null){
            model = (DefaultTableModel) jTableAssemblerUsage.getModel();
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            for (Usage i : lista) {
                if (!i.getSimbolo().isGlobal()) {
                    model.addRow(new Object[]{i.getSimbolo(), String.format("%d", i.getEndereco().getAnddress())});
                }

            }
            jTableAssemblerUsage = new JTable(model);
        
        }else{
            logger.warning("Não tem referência da TableUsage");
        }
        
        if(jTableXREF != null){
            model = (DefaultTableModel) jTableXREF.getModel();
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }

            for (Usage i : lista) {
                if (i.getSimbolo().isXREF()) {
                    model.addRow(new Object[]{i.getSimbolo(), String.format("%d", i.getEndereco().getAnddress()), "R"});
                }

            }
            jTableXREF = new JTable(model);
        }else{
            logger.warning("Não tem referência da XREF");
        }
        
    }
   
    public void printaUsos(FileOutputStream fos) throws IOException{
        String printa = "";
        for(Usage u : lista){
            printa = "".equals(printa)? u.getEndereco().toString(): printa+" "+u.getEndereco().toString();
        }
        fos.write(printa.getBytes());
    }
    
    public void resetTableUsage(){
        lista.clear();
        this.printTableUSage();
    }
    
}
