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
public class FunctionDeclaration {
    public Type type;
    public String id;
    public ArgumentList argumentlist;

    public FunctionDeclaration(Type type, String id, ArgumentList argumentlist) {
        this.type = type;
        this.id = id;
        this.argumentlist = argumentlist;
    }
}
