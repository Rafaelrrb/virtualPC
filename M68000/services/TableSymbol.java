/*
 * TableSymbol é a tabela com simbolos
 *  que até então foram usados pelo sistema Moto 68k.
 */
package M68000.services;
import M68000.assistance.Anddress;
import M68000.assistance.Symbol;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author glaucomunsberg
 */
public class TableSymbol {
    private final static Logger logger = Logger.getLogger(TableSymbol.class.getName());
    private static volatile TableSymbol instance = null;
    private ArrayList<Symbol> tabela;
    private TableUsage tableUsage;
    private Registers registers;
    private JTable jTableSymbol;
    private JTable jTableXDEF;

    private TableSymbol() {
        this.tabela = new ArrayList();
        logger.info("Table Symbol Loaded");
        tableUsage = TableUsage.getInstance();
        registers = Registers.getInstance();
    }
    
    /**
     * Retorna a única instância desta classe
     * @return 
     */
    public static TableSymbol getInstance() {
        if (instance == null) {
            synchronized (Memory.class) {
                if (instance == null) {
                    instance = new TableSymbol();
                }
            }
        }
        return instance;
    }
    
    public void resetTableSymbol(){
    
        this.tabela.clear();
        this.tableUsage.resetTableUsage();     
    }
    
    public void defineAnddress(String identificador, int endereco,boolean isDefined){
        for(Symbol i : tabela){
            if(identificador.equals(i.getSimbolo())){
                i.setEndereco(endereco);
                i.setIsDefined(isDefined);
                return;
            }
        }
        this.addSymbol(identificador,isDefined,endereco);
        printTableSymbol();
    }
   
    
    public void addSymbol(String identificador, boolean XDEF, boolean XREF ){
       tabela.add(new Symbol(identificador,XDEF,XREF));
    }
    
    public void addSymbol(String identificador,boolean defined,int anddress){
        Symbol simbolo;
        simbolo = new Symbol(identificador,defined, anddress);
        tabela.add(simbolo);
        printTableSymbol();
    }
       
    public boolean hasSymbol(String identificador){
        for(Symbol s : tabela){
           if(s.getSimbolo().equals(identificador)){
               return true;
           }
        }
                
        return false;
    }
    
    public boolean simboloDefinido(String identificador){
        for(Symbol s : tabela){
            if(s.getSimbolo().equals(identificador)){
               if(s.isDefined()){
                   return true;
               }else{
                   return false;
               }
           }
        }
        
        return false;
    }
    
    public Symbol getSymbol(String identificador){
        for (Symbol s : tabela){
            if(s.getSimbolo().equals(identificador)){
                return s;
            }
        }
        return null;
    }
    
    public int getAndress(String identificador){
        for (Symbol s : tabela){
            if(s.getSimbolo().equals(identificador)){
                return s.getEndereco();
            }
        }
        
        return 0;
    }
    
    public ArrayList<Symbol> getTabela() {
        return tabela;
    }
    
    public void setTableSymbol(JTable table){
        this.jTableSymbol = table;
    }
    
    public void setTableXDEF(JTable table){
        this.jTableXDEF = table;
    }
    
    public void printTableSymbol(){
        DefaultTableModel model = (DefaultTableModel) jTableSymbol.getModel();
        
        model = (DefaultTableModel) jTableSymbol.getModel();
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        for(Symbol i:tabela){
            if(!i.isGlobal()){
                model.addRow(new Object[]{i.getSimbolo(),String.format("%d", i.getEndereco())});
            }
        }
        jTableSymbol = new JTable(model);
        
        
        model = (DefaultTableModel) jTableXDEF.getModel();
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        for(Symbol i:tabela){
            if(i.isXDEF()){
                model.addRow(new Object[]{i.getSimbolo(),String.format("%d", i.getEndereco()),"R"});
            }
        }
        
        jTableXDEF = new JTable(model);
        
        tableUsage.printTableUSage();
        
    }
    
    public void printConsoleTableSymbol(){
        System.out.println("TableSymbol");
        for(Symbol i: tabela){
            System.out.println(i.toString());
        }
    }

}
