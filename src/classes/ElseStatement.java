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
public class ElseStatement {
    public String eS;
    public Expressions e;
    public IfStatement ifS;

    public ElseStatement(String eS, Expressions e) {
        this.eS = eS;
        this.e = e;
    }

    public ElseStatement(String eS, IfStatement ifS) {
        this.eS = eS;
        this.ifS = ifS;
    }
    
    
}
