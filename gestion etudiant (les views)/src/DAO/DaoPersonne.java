/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Admin;
import MODEL.Classe;
import MODEL.Personne;
import MODEL.Professeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djiby DIOP
 */
public class DaoPersonne {
    private final String SQL_SELECT_BY_CLASSE="select * from personne where type='Etudiant' and classe_id=?";    
    private final String SQL_INSERT="INSERT INTO `personne` (`nom_complet`, `type`, `tuteur`,`classe_id`) VALUES (?,?,?,?,?,?)";
    private final String SQL_SELECT_POFESSEUR="select * from personne where matricule=?";
    private final String SQL_SELECT_ALL_POFESSEUR="select * from personne where type='professeur'";
    private final String SQL_SELECT_CONNEXION="INSERT INTO `personne` (`login`, `mdp`) VALUES (?,?)";
   

    public List<Personne> findByClasse(Classe classe){
        List<Personne> lEtudiants=new ArrayList<>();
        //recup de traitement
        return lEtudiants;
    }
                
     public int insert(Personne pers){
         int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
     }
     
     public Professeur findProfesseurByMatricule(String matriclue){
        Professeur professeur=null;
        //recherche de professeur
        return professeur;        
    }
     
    public List<Personne> findAllProfesseur(){
        List<Personne>lProfesseur=new ArrayList<>();        
        //remplir la liste
        return lProfesseur;
    } 
    
     public int insert(Admin admin){
        int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
    }
    
}
