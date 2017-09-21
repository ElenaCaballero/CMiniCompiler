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
public class Variables {
    public String id, amper;
    public AssignmentProc assignmentProc;
    public Variables vars;

    public Variables(String id, AssignmentProc assignmentProc) {
        this.id = id;
        this.assignmentProc = assignmentProc;
    }

    public Variables(String amper, Variables vars) {
        this.amper = amper;
        this.vars = vars;
    }
        
}
