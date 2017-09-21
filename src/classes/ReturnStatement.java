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
public class ReturnStatement {
    public String ret;
    public Value val;
    public Factor f;

    public ReturnStatement(String ret, Value val) {
        this.ret = ret;
        this.val = val;
    }

    public ReturnStatement(String ret, Factor f) {
        this.ret = ret;
        this.f = f;
    }
    
    public ReturnStatement() {
    }
    
}
