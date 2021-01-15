/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Classe;
import MODEL.Details;
import MODEL.Personne;
import MODEL.Professeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djiby DIOP
 */
public class DaoDetails {
    private final String SQL_INSERT="INSERT INTO `details` (`classe_id`, `professeur_id`, `modules`, `annee`) VALUES (?,?,?,?);";      
    private final String SQL_SELECT_PROFESSEUR_BY_MODULES="select modules from details where professeur_id=?";
    private final String SQL_SELECT_MODULES_BY_PROFESSEUR_AND_CLASSE="select modules from details where professeur_id=? and classe_id=?";

 public int insert(Details details){
         int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
     }    
  
 
public List<Personne> findProfesseurByModules(Professeur prof){
        List<Personne> lProfesseur=new ArrayList<>();
        //recup de traitement
        return lProfesseur;
    }


public List<Details> findModulesByProfesseurAndClasse(Details details){
        List<Details> lModules=new ArrayList<>();
        //recup de traitement
        return lModules;
    }
 
}


