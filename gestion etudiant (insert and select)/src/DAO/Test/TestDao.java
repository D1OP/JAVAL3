/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Test;

import DAO.DaoClasse;
import DAO.DaoDetails;
import DAO.DaoPersonne;
import MODEL.Classe;
import MODEL.Details;
import MODEL.Etudiant;
import MODEL.Personne;

/**
 *
 * @author Djiby DIOP
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //DaoClasse daoClasse=new DaoClasse();
        //Classe classe=new Classe("TTL3",10);
        //daoClasse.insert(classe);
        
        
        //DaoPersonne daoPersonne=new DaoPersonne();
        //Etudiant pers=new Etudiant("djibril_diop","Etudiant");
        //daoPersonne.insert(pers);
        
        
        
        
        DaoPersonne daoPersonne=new DaoPersonne();
       Etudiant etu =new Etudiant("djibril_diop","diop");
        daoPersonne.insertEtudiant(etu);
        
        
        //daoClasse.findAll().forEach((classe)->{
         //   System.out.println(classe);            
       // });
        
        
        //DaoDetails daoDetails=new DaoDetails();
        //Details details=new Details();
        //daoDetails.insert(details);
        
        //DaoPersonne daoPers=new DaoPersonne();     
        //daoPers.findByClasse(new Classe(1)).forEach(System.out::println);                
        //System.out.println(daoPers.findProfesseurByMatricule("MAT20212"));
        
        //DaoPersonne daoPersonne=new DaoPersonne();
       //daoPersonne.findProfesseur().forEach((professeur)->{
         //System.out.println(professeur);
       //});                           
            
     }
    
}
