/*
 * Esta é uma ENUM conténdo os operadores suportado
 *      pelo montador
 */
package services;

/**
 *
 * @author glaucomunsberg
 */
public enum Operation {
    ADD     //ACC←  ACC + opd1 
    ,BR     //PC← opd1 
    ,BRNEG  //PC← opd1, se ACC < 0 
    ,BRPOS  //PC← opd1, se ACC > 0 
    ,BRZERO // PC← opd1, se ACC = 0 
    ,CALL   //[SP]← PC; PC← opd1 (desvio para sub-rotina opd1)
    ,COPY   //opd1← opd2 
    ,DIVIDE //ACC← ACC / opd1 
    ,LOAD   //ACC← opd1
    ,MULT   //ACC← ACC * opd1 
    ,READ   //opd1← input stream 
    ,RET    //PC← [SP]  (retorno de sub-rotina) 
    ,STOP   //término (fim) de execução 
    ,STORE  //opd1← ACC
    ,SUB    //ACC← ACC - opd1 
    ,WRITE; //Output stream← opd1 
}
