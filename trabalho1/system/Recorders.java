/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

/**
 *
 * @author glaucomunsberg
 */
public class Recorders {
    private static volatile Recorders instance = null;
    short counterInstructions;      //Mantém o endereço da próxima instrução a ser executada 
    short stackPointer;             //Aponta para o topo da pilha do sistema; tem incremento decremento automático(push/pop)
    short accumulator;              //Armazena os dados (carregados e resultantes)  das operações da Unid. de Lógica e Aritmética
    byte operatingMode;             //Armazena o indicador do modo de operação,  que é alterado apenas por painel de operação  (via console de operação - interface visual) 
    short recorderInstruction;      //Mantém o opcode da instrução em execução (registrador interno) 
    short recorderMemoryAddress;    //Mantém o endereço de acesso à memória de  dados (registrador interno) 
    
    
    private Recorders() {
        
    }

    public static Recorders getInstance() {
        if (instance == null) {
            synchronized (SymbolTable.class) {
                if (instance == null) {
                    instance = new Recorders();
                }
            }
        }
        return instance;
    }
    
}

