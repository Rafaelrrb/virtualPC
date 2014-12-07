/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.macro;

import java.awt.List;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author glaucomunsberg
 */
public class Macro {
    private static volatile Macro instance = null;
    private final static Logger logger = Logger.getLogger(Macro.class.getName());
    int j;
   // public final String entrada;
    
    public Macro(){
        logger.info("Macro Processor Loaded");
        //this.entrada= "SAV2    MACRO";
        this.j=0;
        
    }
    
    public static Macro getInstance() {
        if (instance == null) {
            synchronized (Macro.class) {
                if (instance == null) {
                    instance = new Macro();
                }
            }
        }
        return instance;
    }
    
    
        // 1. Acha as macros e armazenas elas em 
        // 2. quando acha uma referência a elas então substitui
        // 3. salva o texto final em outro arquivo que deve ser chamado "out_macro" por exemplo
        // 3. retorna a string que foi salva como out_macro
        //texto[0]=entrada;
    
    public String[] processText(String[] texto){
        logger.info("Macro Processor start process the string...");
        
        int i,z; 
        char[] str;
        ArrayList<Character> lista = new ArrayList<>();
        ArrayList<String> listaPalavras = new ArrayList<>();
        char[] palavra = new char[30];
        //List<char[]> asList = Arrays.asList(str);  
        //List<Character> list = new ArrayList<Character>(teste);
        
        
        
        for(z=0;z<texto.length;z++){
            
            str = texto[z].toCharArray();
            
            //retira os comentarios
            for(i=0;i<str.length;i++){    
                if(str[i]=='\t'){
                        i++;        
                }else if(str[i]==';'){
                        lista.add(str[i]);
                        i=str.length;
                }else{    
                    lista.add(str[i]);    
                }
            }
            i=0;
            //lista.remove(' ');
            //colocar contadores diferentes
            while(lista.get(i)!=' ' || lista.get(i)=='\n'){    
                
                palavra[i] = lista.get(i);
                i++;        
            }
            
            listaPalavras.add(new String(palavra));
            
            while( lista.get(i)!=';'|| lista.get(i)=='\n'){    
                
                palavra[i] = lista.get(i);
                i++;        
            }
            
            i=0;
            listaPalavras.add(new String(palavra));
            
        
        
        }
        
           

        
        listaPalavras.add(lista.toString());
        
        
        
        
        /*
        for(i=0;i<lista.size();i++){
            
            
            if(lista.get(i)!=' '){
                    palavra[j]=lista.get(i);
                    j++;
            }else{    
                listaPalavras.add(str[i]);    
            }
        }
        */
        
        
        
        return new String[0];
    }
    
    
   
}
