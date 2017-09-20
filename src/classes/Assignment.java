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
public class Assignment {
    public String id, ida, a;
    public ArithmeticExp aE;
    public Assignment ass;

    public Assignment(String id, ArithmeticExp aE) {
        this.id = id;
        this.aE = aE;
    }

    public Assignment(Assignment ass) {
        this.ass = ass;
    }

    public Assignment(String ida, String a, String id) {
        this.id = id;
        this.ida = ida;
        this.a = a;
    }
    
    
    
}
