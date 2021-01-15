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
public class exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        1-creer une liste de string
        2-ajouter des elts de la liste       
        3-aff des elt de la liste
        4-supp des elts de la liste
        5-modif un elt de la liste
        6-rechercher un elt de la liste
        */
    
        //1-creer une liste string
       List<String> lString=new ArrayList ();
       
        //2-ajouter des elts de la liste
        lString.add("Bonjour");
        lString.add("Au revoir");
        lString.add("Les etudiants");
        
        //3-aff des elt de la liste
            //Methode1:la boucle forEach
            lString.forEach((elt)->{
                System.out.println(elt);
            });
            
            lString.add(0,"Debut");
            lString.forEach((elt)->{
                System.out.println(elt);
            });
        
        //4-supp des elts de la liste
        lString.remove("Debut");
        lString.remove(2);
        System.out.print("Affichage apres suppression");
        lString.forEach((elt) -> {
            System.out.println(elt);
        });
        
        //modifier un elt de la liste
        lString.set(0, "Bonsoir");
        System.out.print("Affichage apres modification");
        lString.forEach((elt) -> {
            System.out.println(elt);
        });

        //rechercher dans la liste
        if(lString.contains("Bonsoir")==true){
            System.out.print("Elt existe");
        }else{
            System.out.print("Elt existe");
        }
    }
    
}                                                            