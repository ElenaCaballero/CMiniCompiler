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
public class CMiniProgram {
    FunctionDeclaration functionDeclaration;
    MainClause mainClause;
    FunctionList functionList;

    public CMiniProgram(FunctionDeclaration functionDeclaration, MainClause mainClause, FunctionList functionList) {
        this.functionDeclaration = functionDeclaration;
        this.mainClause = mainClause;
        this.functionList = functionList;
    }
    
    
}
