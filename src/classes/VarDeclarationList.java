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
public class VarDeclarationList {
    public VarDeclarationList varDeclList;
    public Variables vars;

    public VarDeclarationList(VarDeclarationList varDeclList, Variables vars) {
        this.varDeclList = varDeclList;
        this.vars = vars;
    }

    public VarDeclarationList(Variables vars) {
        this.vars = vars;
    }
    
}
