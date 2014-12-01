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

    private TableSymbol() {
        this.tabela = new ArrayList();
        logger.info("Table Symbol Loaded");
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
    
    public void defineAnddress(String identificador, int endereco){
        for(Symbol i : tabela){
            if(identificador.equals(i.getSimbolo())){
                i.setEndereco(endereco);
                return;
            }
        }
        this.addSymbol(identificador, endereco);
        printTableSymbol();
    }
    
    public void setAsGlobal(String identificador){
        for(Symbol i : tabela){
            if(identificador.equals(i.getSimbolo())){
                i.setGlobal();
                return;
            }
        }
    }
    
    public void addSymbol(String identificador){
        Symbol simbolo;
        simbolo = new Symbol(identificador);
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void addSymbol(String identificador, int endereco){
        Symbol simbolo;
        simbolo = new Symbol(identificador);
        simbolo.setEndereco(endereco);
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void addEquivalence(String identificador, int endereco){
        Symbol simbolo;
        simbolo = new Symbol(identificador,1);
        simbolo.setEndereco(endereco);
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void addConstant(String identificador, int valor){
        Symbol simbolo;
        simbolo = new Symbol(identificador,2,Integer.toString(valor));
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void addSpace(String identificador){
        Symbol simbolo;
        simbolo = new Symbol(identificador,3);
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void addSpace(String identificador, int endereco){
        Symbol simbolo;
        simbolo = new Symbol(identificador,3);
        simbolo.setEndereco(endereco);
        tabela.add(simbolo);
        printTableSymbol();
    }
    
    public void printAllOnConsole(){
        for(Symbol i : tabela){
            System.out.println(i);
        }
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
               if(s.isDefinido()){
                   return true;
               }else{
                   return false;
               }
           }
        }
        
        return false;
    }
    
    public Anddress getAndress(String identificador){
        for (Symbol s : tabela){
            if(s.getSimbolo().equals(identificador)){
                return s.getEndereco();
            }
        }
        
        return null;
    }
    
    public boolean contemEQU(String identificador){
        for(Symbol s : tabela){
           if(s.getSimbolo().equals(identificador)){
               if(s.getTipo() == 1){
                   return true;
               }else{
                   return false;
               }
           }
        }
                
        return false;
    }
    
    public char[] getWordEQU(String identificador){
        for(Symbol s : tabela){
           if(s.getSimbolo().equals(identificador)){
               if(s.getTipo() == 1){
                   return s.getEndereco().getAnddressWord();
               }else{
                   logger.warning("Retornando Null em getWordEQU -1");
                   
                   return null;
               }
           }
        }
        logger.warning("Retornando Null em getWordEQU -2");
        return null;
    }

    public ArrayList<Symbol> getTabela() {
        return tabela;
    }
    
    public void printaGlobais(FileOutputStream fos) throws IOException{
        String printa;
        ArrayList<Anddress> end;
        for (Symbol s : tabela){
            //printa = "";
            if(s.isGlobal()){
                printa = "\n" + s.getSimbolo();
                printa = printa + " " + s.getEndereco();

                fos.write(printa.getBytes());
            }
        }
    }
    
    public void setTableSymbol(JTable table){
        this.jTableSymbol = table;
    }
    
    public void printTableSymbol(){
        DefaultTableModel model = (DefaultTableModel) jTableSymbol.getModel();
        for(int a=0; a < model.getRowCount(); a++){
            model.removeRow(a);
        }
        for(Symbol i:tabela){
            model.addRow(new Object[]{i.getSimbolo()});
        }
    }
    
    public void printSymbolsDefinededs(FileOutputStream fos) throws IOException{
        String printa;
        ArrayList<Anddress> end;
        for (Symbol s : tabela){
            //printa = "";
            if(!s.isDefinido()){
                printa = "\n" + s.getSimbolo();
                end = tableUsage.returnaUsos(s.getSimbolo());
                for(Anddress u : end){
                    printa = printa + " " + u.toString();
                }
                fos.write(printa.getBytes());
            }
        }
    }
       
    
}
