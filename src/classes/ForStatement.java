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
public class ForStatement {
    public String forS;
    public Inits init;
    public Condition c;
    public ForArthmExp aE;
    public Expressions e;

    public ForStatement(String forS, Inits init, Condition c, ForArthmExp aE, Expressions e) {
        this.forS = forS;
        this.init = init;
        this.c = c;
        this.aE = aE;
        this.e = e;
    }
    
    
}
