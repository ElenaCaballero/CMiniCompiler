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
    public Types type;
    public String main;
    public ArgumentList argumentlist;
    public Expressions expressions;

    public MainClause(Types type, String main, ArgumentList argumentlist, Expressions expressions) {
        this.type = type;
        this.main = main;
        this.argumentlist = argumentlist;
        this.expressions = expressions;
    }
    
	
}
