/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author tuhin
 */
public class ApplicationPageController implements Initializable {

    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    
    @FXML
    public void SignIn(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Designs/SignIn.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    
    
     @FXML
    void StudentRegistration(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Designs/StudentRegistration.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Students Registration");
    }


    @FXML
    void TeacherRegistration(ActionEvent event) {

    }


    @FXML
    void StudentInformation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Designs/StudentInformation.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Students Registration");
    }
     @FXML
    void TeacherInfo(ActionEvent event) {

    }
    



    @FXML
    void TBA(ActionEvent event) {

    }


   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
