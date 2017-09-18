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
class IfStatement {
    String ifS;
    Condition c;
    Expression e;
    ElseStatement eS;

    public IfStatement(String ifS, Condition c, Expression e) {
        this.ifS = ifS;
        this.c = c;
        this.e = e;
    }

    public IfStatement(String ifS, Condition c, Expression e, ElseStatement eS) {
        this.ifS = ifS;
        this.c = c;
        this.e = e;
        this.eS = eS;
    }
    
    
}
