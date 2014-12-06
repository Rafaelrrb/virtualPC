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
    
    private Symbol symbol;
    private int anddress;

    public Usage(Symbol simbolo, int end) {
        this.symbol = simbolo;
        this.anddress = end;
    }

    public int getEndereco() {
        return anddress;
    }

    public Symbol getSimbolo() {
        return symbol;
    }
    
    @Override
    public String toString(){
        return "{ {symbol:"+symbol.getSimbolo()+", defined:"+symbol.isDefined()+", anddress:"+symbol.getEndereco()+", XREF:"+symbol.isXREF()+", XDEF:"+symbol.isXDEF()+"},{usage:"+anddress+"}}"; 
    }
    
    
}
