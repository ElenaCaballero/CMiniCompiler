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
public class Term {
    public Term term;
    public String opmult;
    public Factor factor;

    public Term(Term term, String opmult, Factor factor) {
        this.term = term;
        this.opmult = opmult;
        this.factor = factor;
    }

    public Term(Factor factor) {
        this.factor = factor;
    }
   
}
