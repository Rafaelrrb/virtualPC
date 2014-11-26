/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000.assistance;

import M68000.services.Anddress;

/**
 *
 * @author Ruhan
 */
public class Usage {
    
    private String simbolo;
    private Anddress endereco;

    public Usage(String simbolo, Anddress end) {
        this.simbolo = simbolo;
        this.endereco = end;
    }

    public Anddress getEndereco() {
        return endereco;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
    
}
