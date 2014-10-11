/*
 * O manipulador de Arquivo é responsável 
 *      pela abertura do arquivo que contém as instruções
 */
package services;

/**
 *
 * @author glaucomunsberg
 */
public class ManipulatorFile {
    private String nameOfFile;
    private int localizationCounter;
    private int lineCounter;
    private static volatile ManipulatorFile instance = null;
    
    private ManipulatorFile() {
        
    }

    public static ManipulatorFile getInstance() {
        if (instance == null) {
            synchronized (ManipulatorFile.class) {
                if (instance == null) {
                    instance = new ManipulatorFile();
                }
            }
        }
        return instance;
    }
    
    public void setFileUrl(String fileURL){
        
    }
    
    public boolean openFile(){
        return true;
    }
    
    public Line getNextLine(){
        return null;
    }
}
