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
public class MainClause {
    Type i;
    String main;
    ArgumentList argumentlist;
    Expressions expressions;

    public MainClause(Type i, String main, ArgumentList argumentlist, Expressions expressions) {
        this.i = i;
        this.main = main;
        this.argumentlist = argumentlist;
        this.expressions = expressions;
    }
    
	
}