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
public class Variables {
    public String id;
    public Variables variables;
    public Value value;

    public Variables(String id) {
        this.id = id;
    }

    public Variables(String id, Variables variables) {
        this.id = id;
        this.variables = variables;
    }

    public Variables(String id, Value value) {
        this.id = id;
        this.value = value;
    }

    public Variables(String id, Value value, Variables variables) {
        this.id = id;
        this.variables = variables;
        this.value = value;
    }
    
           
            
}
