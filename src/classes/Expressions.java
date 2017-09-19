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
public class Expressions {
    public Expressions expressions;
    public Expression expression;

    public Expressions(Expressions expressions, Expression expression) {
        this.expressions = expressions;
        this.expression = expression;
    }

    public Expressions(Expression expression) {
        this.expression = expression;
    }

}
