/*
 * Usage é a classe que representa os simbolos usados
 *      e o endereço que eles estão representando
 */
package M68000.assistance;

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
