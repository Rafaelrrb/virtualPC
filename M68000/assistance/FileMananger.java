/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assistance;

import java.net.URL;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author glaucomunsberg
 */
public class FileMananger {
    
    private static volatile FileMananger instance = null;
    private static final Logger logger = Logger.getLogger(FileMananger.class.getName());
    private boolean isOpen;
    private boolean isClose;
    private String path;
    private URL url;
    private FileReader file;
    private BufferedReader bufferedFile;
    private int numberOfLine;
    private String[] lines;
    
    /**
     * Construtor privado que seta como
     *  0 a posição inicial e memória do tamanho de 1K
     */
    private FileMananger() {
               
        logger.info("File Loaded");
        isOpen  = false;
        isClose = false;
        path    = "";
    }
    
    public static FileMananger getInstance() {
        
        if (instance == null) {
            synchronized (FileMananger.class) {
                if (instance == null) {
                    instance = new FileMananger();
                }
            }
        }
        return instance;   
    }
    
    public boolean openFile(String url){
        
        if(!isOpen){
            logger.info("Starting open file");
            path = url;

            try {

                file = new FileReader(path);
                bufferedFile = new BufferedReader(file);
                String temporary;
                numberOfLine = 0;
                while ((temporary = bufferedFile.readLine()) != null) {
                    numberOfLine++;
                }

                String[] lines = new String[numberOfLine];
                file = new FileReader(path);
                bufferedFile = new BufferedReader(file);
                numberOfLine = 0;
                temporary = " ";

                while (temporary != null) {

                    temporary = bufferedFile.readLine();
                    if (temporary != null) {
                        lines[numberOfLine] = temporary;
                        numberOfLine++;
                    }
                }
                this.lines = lines;

            } catch (FileNotFoundException ex) {

                logger.severe("Can't open the file");
                return false;

            } catch (IOException ex) {

                logger.severe("Can't open the file (IOException)");
                return false;

            }
            logger.log(Level.INFO, "Success when opening the file with {0} lines", numberOfLine);
            
        
            return isOpen = true;   
        }else{
            logger.info("One file was open after");
            return true;
        }
    }
    
    public String[] getLines(){
        return this.lines;
    }
    
    public boolean closeFile(){
 
        try{
            bufferedFile.close();
            this.isClose = true;
            logger.info("Success to close");
        }catch(Exception e){
            this.isClose = false;
            logger.info("Error to close");
        }
        
        return isClose;
    }
    
    public boolean isOpen(){
        return isOpen;
    }
    
    public boolean isClose(){
        return isClose;
    }
}