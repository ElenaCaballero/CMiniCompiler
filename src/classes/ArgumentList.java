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
public class ArgumentList {
    public ArgumentList argumentList;
    public Argument argument;

    public ArgumentList(Argument argument) {
        this.argument = argument;
    }

    public ArgumentList(ArgumentList argumentList, Argument argument) {
        this.argumentList = argumentList;
        this.argument = argument;
    }

    
    
}
