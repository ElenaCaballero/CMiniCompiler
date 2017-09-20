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
public class Function {
    public Types i;
    public String id;
    public ArgumentList argumentlist;
    public Expressions expressions;

    public Function(Types i, String id, ArgumentList argumentlist, Expressions expressions) {
        this.i = i;
        this.id = id;
        this.argumentlist = argumentlist;
        this.expressions = expressions;
    }
}
