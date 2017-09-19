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
    public int i;
    public String id;

    public Factor(ArithmeticExp aE) {
        this.aE = aE;
    }

    public Factor(int i) {
        this.i = i;
    }
    
    //este debe cambiar

    public Factor(String id) {
        this.id = id;
    }
    
    
}
