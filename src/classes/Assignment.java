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
    public String id, amper;
    public ArithmeticExp aE;
    public Value vals;
    public VarDeclarationList varDecList;

    public Assignment(ArithmeticExp aE) {
        this.aE = aE;
    }

    public Assignment(VarDeclarationList varDecList) {
        this.varDecList = varDecList;
    }

    public Assignment(Value vals, VarDeclarationList varDecList) {
        this.vals = vals;
        this.varDecList = varDecList;
    }

    public Assignment(String id, String amper) {
        this.id = id;
        this.amper = amper;
    }

    
}
