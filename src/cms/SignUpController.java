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
public class SignUpController implements Initializable {
    
     @FXML
    private JFXTextField signup_email;


    @FXML
    private JFXTextField signup_username;

    @FXML
    private JFXTextField signup_name;

    @FXML
    private JFXPasswordField signup_password;
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/loginfo";
    
     @FXML
    void SignIn(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Designs/SignIn.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Sign In");
    }

    @FXML
    void SignUp(ActionEvent event) {
System.out.println(signup_email.getText());
System.out.println(signup_username.getText());
System.out.println(signup_name.getText());
System.out.println(signup_password.getText());

Connection conn=null;
        try{
            conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");                      
            Statement stmt=(Statement) conn.createStatement();
            String name=signup_name.getText();
             String email=signup_email.getText();
            String username=signup_username.getText();
            String pass=signup_password.getText();
            System.out.println("Connected2");
            String insert="";
            if(name.isEmpty()| username.isEmpty() | email.isEmpty() | pass.isEmpty()){
            System.out.println("No ENtry");
            Notifications.create()
                    .title("Warning")
                    .text("You are missing input").darkStyle()
                    .showWarning();
            }
            else
            {
                insert="INSERT INTO user (id ,name, username, email, pass) VALUES (NULL, ' "+name+"', '"+username+"','"+email+"', '"+pass+"') ";
                stmt.executeUpdate(insert);
                Notifications.create()
                    .title("Congratulations")
                    .text("You are registered as: "+username).darkStyle()
                    .showInformation();
                
            }
            
            
            System.out.println(insert);
            
            signup_name.setText("");
            signup_email.setText("");
            signup_username.setText("");
            signup_password.setText("");
            
            
//            String select="SELECT * FROM user";
//            ResultSet resultSet= stmt.executeQuery(select);
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//                
//            }
        }
        catch(SQLException e){
            System.err.println(e);
        }

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
