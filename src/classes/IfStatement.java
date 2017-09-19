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
public class IfStatement {
    public String ifS;
    public Condition c;
    public Expressions e;
    public ElseStatement eS;
    public IfStatement i;

    public IfStatement(String ifS, Condition c, Expressions e) {
        this.ifS = ifS;
        this.c = c;
        this.e = e;
    }

    public IfStatement(IfStatement i, ElseStatement eS) {
        this.i = i;
        this.eS = eS;
    }
    
    
}
