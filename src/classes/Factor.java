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
public class Factor {
    public ArithmeticExp aE;
    public Value val;

    public Factor(ArithmeticExp aE) {
        this.aE = aE;
    }

    public Factor(Value val) {
        this.val = val;
    }

}
