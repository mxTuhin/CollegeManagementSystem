/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 *
 * @author tuhin
 */
public class SignInController implements Initializable {
    


    @FXML
    private JFXTextField signin_username;
    @FXML
    private JFXTextField signup_email;


    @FXML
    private JFXPasswordField signin_password;
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/loginfo";
    
     @FXML
    void SignIn(ActionEvent event) throws IOException, SQLException {
        
        if(signin_username.getText().isEmpty() | signin_password.getText().isEmpty()){
            Notifications.create()
                    .title("Warning")
                    .text("You are missing input")
                    .darkStyle()
                    .showWarning();
                    
        }
        else{
            String username, password;

        username = signin_username.getText();
        password = signin_password.getText();
        Connection conn=null;
        conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from user where username" +
                " = '" + username + "' or email = '" + signup_email + "' and pass = '" + password + "'");

        if (resultSet.next()) {
            Parent root = FXMLLoader.load(getClass().getResource("Designs/ApplicationPage.fxml"));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            
            Notifications.create()
                    .title("Congratulations")
                    .text("You have Logged in as : "+username).darkStyle()
                    .showInformation();

        }
        
        else{
            Notifications.create()
                    .title("Warning")
                    .text("Your information is wrong").darkStyle()
                    .showWarning();
        }
            
        }
        
        
        
        
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        
        
        
Parent root = FXMLLoader.load(getClass().getResource("Designs/SignUpValidator.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Sign Up");

    }

    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        
//        
//
//
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
