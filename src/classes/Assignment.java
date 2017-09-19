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
    public String id, type;
    public int value;
    public char charval;

    public Assignment(String id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Assignment(String id, String type, char charval) {
        this.id = id;
        this.type = type;
        this.charval = charval;
    }
    
    
}
