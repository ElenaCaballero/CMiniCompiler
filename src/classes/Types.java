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
public class Types {
    public String tipo, asterisk;

    public Types(String tipo) {
        this.tipo = tipo;
    }

    public Types(String tipo, String asterisk) {
        this.tipo = tipo + asterisk;
    }
    
}
