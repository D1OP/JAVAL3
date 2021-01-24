/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import METIER.Service;
import MODEL.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Djiby DIOP
 */
public class viewConnexionController implements Initializable {
    
    
    @FXML
    private PasswordField textPwd;
    @FXML
    private TextField textLogin;
    @FXML
    private Text lblError;
    
    private Service metier;
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblError.setVisible(false);
        metier=new Service();
    }    

    @FXML
    private void handleConnection(ActionEvent event) throws IOException {
        String login=textLogin.getText();
        String pwd=textPwd.getText();
        Personne pers=metier.seConnecter(login, pwd);
        if (pers==null){
            lblError.setVisible(true);
        }else{
            textLogin.getScene().getWindow().hide();
            AnchorPane view= FXMLLoader.load(getClass().getResource("viewMenu.fxml"));
            Scene scene= new Scene(view);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        }
    }
    
}
