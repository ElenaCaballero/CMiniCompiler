/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cminicompiler;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.*;

/**
 *
 * @author User
 */
public class CMiniCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        buildLexer();
        buildParser();
        
        try {
            parser p = new parser(new CMiniLexer(new FileReader("./test/ejercicio.txt")));
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
            //System.out.println(symtab);
            p.parse(); 
            mapper.writeValue(new File("./test/AST.json"), p.root);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CMiniCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
}
