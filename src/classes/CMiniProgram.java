/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author elenacaballero
 */
public class CMiniProgram {
    public FunctionDeclaration functionDeclaration;
    public MainClause mainClause;
    public FunctionList functionList;

    public CMiniProgram(FunctionDeclaration functionDeclaration, MainClause mainClause, FunctionList functionList) {
        this.functionDeclaration = functionDeclaration;
        this.mainClause = mainClause;
        this.functionList = functionList;
    }

    public CMiniProgram(MainClause mainClause) {
        this.mainClause = mainClause;
    }
    
    
}
