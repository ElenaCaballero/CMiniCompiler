/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.beans.Expression;

/**
 *
 * @author elenacaballero
 */
class MainClause {
    Type i;
    String main;
    Arguments arguments;
    Expression expression;

    public MainClause(Type i, String main, Arguments arguments, Expression expression) {
        this.i = i;
        this.main = main;
        this.arguments = arguments;
        this.expression = expression;
    }
    
	
}
