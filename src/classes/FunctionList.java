/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author elenacaballero
 */
public class FunctionList {
    public Function function;
    public FunctionList funcList;

    public FunctionList(FunctionList funcList, Function function) {
        this.function = function;
        this.funcList = funcList;
    }

    public FunctionList(Function function) {
        this.function = function;
    }

    
}
