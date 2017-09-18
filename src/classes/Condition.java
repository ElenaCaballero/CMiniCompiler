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
class Condition {
    Value valLeft;
    String exp;
    Value valRight;
    AndOR aO;

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
    
    
}
