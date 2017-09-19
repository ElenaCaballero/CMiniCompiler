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
public class Statements {
    public IfStatement ifStatement;
    public WhileStatement whileStatement;
    public ForStatement forStatement;

    public Statements(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    public Statements(WhileStatement whileStatement) {
        this.whileStatement = whileStatement;
    }

    public Statements(ForStatement forStatement) {
        this.forStatement = forStatement;
    }
    
}
