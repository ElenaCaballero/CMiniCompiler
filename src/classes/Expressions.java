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
class Expressions {
    Expressions expressions;
    Expression expression;
    ReturnStatement returnStatement;

    public Expressions(Expressions expressions, Expression expression, ReturnStatement returnStatement) {
        this.expressions = expressions;
        this.expression = expression;
        this.returnStatement = returnStatement;
    }

    public Expressions(Expression expression, ReturnStatement returnStatement) {
        this.expression = expression;
        this.returnStatement = returnStatement;
    }

    public Expressions(ReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }

}
