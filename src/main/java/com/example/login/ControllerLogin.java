package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerLogin {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLable;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {
        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            // loginMessageLable.setText("You try to login!");
            validateLogin();
        } else {
            loginMessageLable.setText("Please enter username and password.");
        }
    }

    //@FXML
    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDN = connectNow.getConnection();

        String verifLogin = "select count(1) from UserAccounts where username = '" + usernameTextField.getText() + "' and password = '" + passwordPasswordField.getText() + "';";

        try {
            Statement statement = connectDN.createStatement();
            ResultSet queryResult = statement.executeQuery(verifLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMessageLable.setText("Welcome!");
                } else {
                    createAccountFrom();
                    loginMessageLable.setText("Invalid Login. Please try again.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createAccountFrom(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 600);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            //stage.setTitle("Login window");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}