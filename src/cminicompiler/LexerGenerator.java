/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cminicompiler;

import java.io.File;

/**
 *
 * @author elenacaballero
 */
public class LexerGenerator {
    public static void main(String[] args) {
        try {
            jflex.Main.generate(new File("src/cminicompiler/CMiniLexer.flex"));
        } catch (Exception e) {
            System.out.println("AQUI EN LEXER GENERATOR");
        }
    }
}
