/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Details;
import MODEL.Personne;

/**
 *
 * @author Djiby DIOP
 */
public class DaoDetails {
    private final String SQL_INSERT="INSERT INTO `details` (`classe_id`, `professeur_id`, `modules`, `annee`) VALUES (?,?,?,?);";
 
 public int insert(Details details){
         int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
     }    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


