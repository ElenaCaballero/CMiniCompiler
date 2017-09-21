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
public class Condition {
    public Value valLeft;
    public String exp;
    public Value valRight;
    public AndOR aO;
    public Factor factL;
    public Factor factR;

    public Condition(Value valLeft, String exp, Value valRight) {
        this.valLeft = valLeft;
        this.exp = exp;
        this.valRight = valRight;
    }

    public Condition(Value valLeft, String exp, Value valRight, AndOR aO) {
        this.valLeft = valLeft;
        this.exp = exp;
        this.valRight = valRight;
        this.aO = aO;
    }

    public Condition( Factor factL,String exp, Factor factR, AndOR aO) {
        this.exp = exp;
        this.aO = aO;
        this.factL = factL;
        this.factR = factR;
    }

    public Condition(Factor factL, String exp, Factor factR) {
        this.exp = exp;
        this.factL = factL;
        this.factR = factR;
    }
    
    
    
    
}
