/*
 * Config é a classe base de configurações para o sistema inteiro
 */
package services;

/**
 *
 * @author glaucomunsberg
 */
public class Config {
    private static volatile Config instance = null;
    private int startLocation;
    private Config() {

    }

    public static Config getInstance() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }
}
