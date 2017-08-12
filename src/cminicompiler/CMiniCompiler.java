/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cminicompiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import cminicompiler.LexerGenerator;

/**
 *
 * @author User
 */
public class CMiniCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LexerGenerator.main(args);
        
        try {
            Reader reader = new BufferedReader(new FileReader("./test/ejercicio.txt"));
            CMiniLexer lexer = new CMiniLexer(reader);
            lexer.next_token();

            System.out.println("No errors.");

        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
        
    }
    
}
