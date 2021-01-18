/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Test;

import DAO.DaoClasse;
import DAO.DaoDetails;
import MODEL.Classe;
import MODEL.Details;

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
        
        //daoClasse.findAll().forEach((classe)->{
          //  System.out.println(classe);            
        //});
        
        
        DaoDetails daoDetails=new DaoDetails();
        Details details=new Details();
        daoDetails.insert(details);
        
    }
    
}
