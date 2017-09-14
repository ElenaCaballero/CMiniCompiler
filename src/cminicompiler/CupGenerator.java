/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cminicompiler;

/**
 *
 * @author elenacaballero
 */
public class CupGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String params[] = new String[5];
        
        params[0] = "-destdir";
        params[1] = "src/cminicompiler/";
        params[2] = "-parser";
        params[3] = "parser";
        params[4] = "src/cminicompiler/CMiniSyntax.cup";
        try {
            java_cup.Main.main(params);
        } catch (Exception e) {
            System.out.println("EN EL CUP GENERATOR");
            System.out.println(e);
        }
    }
    
}
