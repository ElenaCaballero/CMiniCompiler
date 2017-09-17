/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author elenacaballero
 */
public class FunctionList {
    FunctionList functionlist;
    Function function;

    public FunctionList(FunctionList functionlist, Function function) {
        this.functionlist = functionlist;
        this.function = function;
    }

    public FunctionList(Function function) {
        this.function = function;
    }
    
    
}
