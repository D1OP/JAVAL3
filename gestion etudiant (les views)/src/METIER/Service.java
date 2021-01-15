/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METIER;

import DAO.DaoClasse;
import DAO.DaoDetails;
import DAO.DaoPersonne;
import MODEL.Admin;
import MODEL.Classe;
import MODEL.Details;
import MODEL.Etudiant;
import MODEL.Personne;
import MODEL.Professeur;
import java.util.List;

/**
 *
 * @author Djiby DIOP
 */
public class Service {
    private DaoClasse daoClasse;
     private DaoPersonne daoPersonne;
      private DaoDetails daoDetails;
     
     
    public Service(){
        daoClasse=new DaoClasse();
        daoPersonne=new DaoPersonne();
        daoDetails=new DaoDetails();
    }
    
    public boolean creerClasse (Classe classe){        
        int nbreLigne=daoClasse.insert(classe);
        if(nbreLigne==0)return false ;
        else return true;
    }
    
    public boolean seConnecter (Admin admin){        
        return daoPersonne.insert(admin) !=0;
    }
    
    
    public List<Classe> listerClasse(){
        return daoClasse.findAll();
    }
    
    public List<Personne> listerEtudiantParClasse(Classe classe){
        return daoPersonne.findByClasse(classe);
    }
    
    public List<Personne> listerProfesseurParModules(Professeur prof){
        return daoDetails.findProfesseurByModules(prof);
    }
    
    public List<Details> listerModulesParProfesseurEtClasse(Details details){
        return daoDetails.findModulesByProfesseurAndClasse(details);
    }  
    
     public List<Personne> listerProfesseur(){
        return daoPersonne.findAllProfesseur();
    }
    
    
    /*public boolean creerEtudiant (Etudiant etu){   
        return daoPersonne.insert(etu) !=0;  
         /*c la mm chose que 
     int nbreLigne=daoClasse.insert(classe);
        if(nbreLigne==0)return false ;
        else return true;
   
    }
    public boolean creerProfesseur (Professeur prof){   
        return daoPersonne.insert(prof) !=0;  
    }
     les 2 précédent c la mm chose que c ki suit avec personne
    */
    
     public boolean creerPersonne (Etudiant pers){   
        return daoPersonne.insert(pers) !=0;  
     }
    
    public Professeur chercherProfesseur(String matricule){
        return daoPersonne.findProfesseurByMatricule(matricule);        
    }
    
     public boolean attribuerClasse (Classe classe, Professeur prof, List<String>modules,String annee){   
           if(prof.getId()==0){
               int id=daoPersonne.insert(prof);
               prof.setId(id); 
           }
           Details details=new Details(annee, modules, classe, prof);
           return daoDetails.insert(details)!=0;
     }
    
   
}
