/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COURS.List;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djiby DIOP
 */
public class exercice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       List<String>personneString=new ArrayList();
               
        personneString.add("DIOP");
        personneString.add("CISSE");
        personneString.add("FAYE");                
        personneString.add("WANE");
        personneString.add("DIOUF");
        personneString.add("FALL");        
    
        personneString.forEach((personne) -> {
            System.out.println(personne);
        });
              
        
        
        
    }
    
}
