/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assistance;

import java.util.logging.Logger;

/**
 *
 * @author Ruhan
 */
public class Anddress {
    
    private int anddress;
    private char[] anddressWord;
    
    private final static Logger logger = Logger.getLogger(Anddress.class.getName());
        
    public Anddress(int endereco) {
             
        anddressWord = new char[32];
        this.anddress = endereco;
        setAndressWord();
        
    }
        
     
    
   public void printWord(){
       System.out.println(anddressWord);
   }

    public int getAnddress() {
        return anddress;
    }

    public char[] getAnddressWord() {
        return anddressWord;
    }
   
   private void setAndressWord() {
       String enderecoBin;
       
       enderecoBin = Integer.toBinaryString(anddress);
       
       for (int i = 0 ; i < (32 - enderecoBin.length()); i++){
            anddressWord[i] = '0';            
        }        
        for (int i = 0, j = 32-enderecoBin.length() ; i < enderecoBin.length() ; i++ , j++){
            anddressWord[j] = enderecoBin.charAt(i);
        }
   }
   
   @Override
   public String toString(){
        String resposta = "";
        resposta = resposta + this.anddress;
        return resposta;
   }
    
}
