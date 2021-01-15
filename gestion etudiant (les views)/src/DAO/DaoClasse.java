/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Classe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djiby DIOP
 */
public class DaoClasse {
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`, `nbre-etudiant`) VALUES (?,?);";
    private final String SQL_SELECT_ALL="select * from classe";
    
    public int insert(Classe classe){
        int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
    }
    
    public List<Classe> findAll(){
        List<Classe>lClasses=new ArrayList<>();
        
        //remplir la liste
        return lClasses;
    }
    
}
