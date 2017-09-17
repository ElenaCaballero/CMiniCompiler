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
class ArgumentList {
    ArgumentList argumentList;
    Argument argument;

    public ArgumentList(Argument argument) {
        this.argument = argument;
    }

    public ArgumentList(ArgumentList argumentList, Argument argument) {
        this.argumentList = argumentList;
        this.argument = argument;
    }
    
}
