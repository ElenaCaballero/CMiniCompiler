/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cminicompiler;

import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.Lexer;
import java_cup.parser;

/**
 *
 * @author User
 */
public class CMiniCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "./test/ejercicio.txt";
        buildLexer();
        buildParser();
        runFile(file);
    }

    private static void buildLexer() {
        jflex.Main.generate(new File("src/cminicompiler/CMiniLexer.flex"));
    }

    private static void buildParser() {
        String params[] = new String[5];

        params[0] = "-destdir";
        params[1] = "src/cminicompiler/";
        params[2] = "-parser";
        params[3] = "parser";
        params[4] = "src/cminicompiler/CMiniSyntax.cup";
        try {
            java_cup.Main.main(params);
        } catch (IOException ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void runFile(String file) {
        
        try {
            parser parser = new parser(new Lexer(new FileReader(file)));
            parser.parse();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
