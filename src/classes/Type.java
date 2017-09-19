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
public class Type {
    public String tipo, asterisk;

    public Type(String tipo) {
        this.tipo = tipo;
    }

    public Type(String tipo, String asterisk) {
        this.tipo = tipo + asterisk;
    }
    
}
