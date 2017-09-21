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
public class VariableDeclaration {
    public Types type; 
    public VarDeclarationList varDeclList;

    public VariableDeclaration(Types type, VarDeclarationList varDeclList) {
        this.type = type;
        this.varDeclList = varDeclList;
    }

    public VariableDeclaration(VarDeclarationList varDeclList) {
        this.varDeclList = varDeclList;
    }
    
    

}
