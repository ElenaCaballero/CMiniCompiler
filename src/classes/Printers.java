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
public class Printers {
    public String type, literal;
    public Variables v;

    public Printers(String type, String literal) {
        this.type = type;
        this.literal = literal;
    }

    public Printers(String type, String literal, Variables v) {
        this.type = type;
        this.literal = literal;
        this.v = v;
    }

    public Printers() {
        
    }
    
    
}
