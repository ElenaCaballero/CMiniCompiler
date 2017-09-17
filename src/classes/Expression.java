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
class Expression {
    VariableDeclaration variableDeclaration;
    Statements statements;
    Scanners scanners;
    Printers printers;

    public Expression(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public Expression(Statements statements) {
        this.statements = statements;
    }

    public Expression(Scanners scanners) {
        this.scanners = scanners;
    }

    public Expression(Printers printers) {
        this.printers = printers;
    }
}
