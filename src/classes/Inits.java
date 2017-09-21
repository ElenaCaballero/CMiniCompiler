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
public class Inits {
    public String type, id;
    public Value val;
    public Factor fact;

    public Inits(String type, String id, Value val) {
        this.type = type;
        this.id = id;
        this.val = val;
    }
    
    public Inits(String type, String id, Factor val) {
        this.type = type;
        this.id = id;
        this.fact = val;
    }
    
}
