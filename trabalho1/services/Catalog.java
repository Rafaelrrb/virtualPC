/*
 * Esta classe é o catalogo de todos os comandos inseridos
 *  através do input do sistema
 */
package services;

import java.util.LinkedList;

/**
 *
 * @author glaucomunsberg
 */
public class Catalog {
   private static volatile Catalog instance = null;
   LinkedList<Line> lines;
   Line line;
   
   /**
    * Construtor privado
    */
   private Catalog(){
       lines = new LinkedList<Line>();
   }
   
   /**
    * Retorna a única instância desta classe
    * @return 
    */
   public static Catalog getInstance() {
        if (instance == null) {
            synchronized (Catalog.class) {
                if (instance == null) {
                    instance = new Catalog();
                }
            }
        }
        return instance;
    }
   
   /**
    * Comando pelo qual o sistema recebe uma linha 
    *   e encaminha ao mesmo tempo para o catalogo
    *   dos comandos quando para a memória
    * @param lineString 
    */
   public void insertLine(String lineString){
       this.line = new Line(lineString);
       lines.add(this.line);
   }
   
   /**
    * Limpa todo o Catalago
    */
   public void resetCommand(){
       lines.clear();
   }
}
