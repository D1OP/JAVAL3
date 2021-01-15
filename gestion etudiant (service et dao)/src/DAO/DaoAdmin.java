/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Admin;
import MODEL.Classe;

/**
 *
 * @author Djiby DIOP
 */
public class DaoAdmin {
    private final String SQL_INSERT="INSERT INTO `admin` (`login`, `mdp`) VALUES (?,?);";
    
    public int insert(Admin admin){
        int nbreLigne=0;
        //insertion puis retourne le nombre de ligne
        return nbreLigne;
    }
    






}
