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
    
   
    
    public List<Classe> listerClasse(){
        return daoClasse.findAll();
    }    
    
    public List<Etudiant> listerEtudiantParClasse(Classe classe){
        return daoPersonne.findByClasse(classe);
    }        
    
    /*public boolean creerPersonne (Etudiant pers){   
        return daoPersonne.insert(pers) !=0;  
     }*/
    
    public boolean creerEtudiant (Etudiant etu){   
        return daoPersonne.insertEtudiant(etu) !=0;
    }
    public boolean creerProfesseur (Professeur pers){   
        return daoPersonne.insertProfesseur(pers) !=0;
    }
    
    public List<Details> listerModules(){
       return daoDetails.findAllModules();
   }
    
    public Professeur chercherProfesseur(String matricule){
        return daoPersonne.findProfesseurByMatricule(matricule);        
    }
    
     public boolean attribuerClasse (Classe classe, Professeur prof, List<String>modules,String annee){   
           if(prof.getId()==0){
               int id=daoPersonne.insertProfesseur(prof);
               prof.setId(id); 
           }
           Details details=new Details(annee, modules, classe, prof);
           return daoDetails.insert(details)!=0;
     }     
    
     public List<Professeur> listerProfesseur(Personne personne){
        return daoPersonne.findProfesseur(personne);
    }   
    
     public List<Details>listerModulesProfesseurParClasse(Classe classe,Professeur professeur){
        Details details=new Details(classe, professeur);
        return daoDetails.findModules(details);
     }
     public Personne seConnecter(String login,String pwd){
         return daoPersonne.findUserConect(login, pwd);
     }
     
}
