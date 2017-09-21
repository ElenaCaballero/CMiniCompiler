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
public class Scanners {
    public String type, literal;
    public VarDeclarationList v;

    public Scanners(String type, String literal, VarDeclarationList v) {
        this.type = type;
        this.literal = literal;
        this.v = v;
    }
    
    
}
