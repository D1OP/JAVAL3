/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import METIER.Service;
import MODEL.Classe;
import MODEL.Details;
import MODEL.Etudiant;
import MODEL.Personne;
import MODEL.Professeur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Djiby DIOP
 */
public class ViewProfesseursController implements Initializable {

     private Service METIER;
    ObservableList<Classe> obClasse;
    ObservableList <Professeur> obProfesseur;
    ObservableList <Details> obModules;
    
    @FXML
    private TableView<Professeur> tblvProfesseurs;
    @FXML
    private TableColumn<Professeur, String> tblcId;
    @FXML
    private TableColumn<Professeur, String> tblcNom;
    @FXML
    private TableColumn<Professeur, String> tblcGrade;
    @FXML
    private TableView<Details> tblvModules;
    @FXML
    private TableColumn<Details, String> tblcLibelle;
    @FXML
    private TableColumn<Details, String> tblcClasse;
    @FXML
    private ComboBox<Classe> cbmClasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        METIER=new Service();
        obModules=FXCollections.observableArrayList(METIER.listerModules());
             
          loadTable();
    }
        
    private void loadTable(){
            tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));        
            tblvProfesseurs.setItems(obProfesseur);
        
    }        
    
    @FXML
    private void handleShowModules(MouseEvent event) {
         Professeur professeurSelected=tblvProfesseurs.getSelectionModel().getSelectedItem();
        obModules=FXCollections.observableArrayList(METIER.listerModules());
        
         tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tblcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));         
         tblvModules.setItems(obModules);
    }
}
