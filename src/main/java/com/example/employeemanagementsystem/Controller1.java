package com.example.employeemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller1 {
    @FXML
    private Label welcomeText;
    @FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @FXML
    private Button closeBtn;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    ///Database tools
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private double x=0;
    private double y=0;
    public void loginAdmin()
    {
        String sql = "select * from users where username=? and password=?";
        connection=Database.connectDb();
        try{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,username.getText());
                preparedStatement.setString(2,password.getText());
                resultSet=preparedStatement.executeQuery();
            Alert alert;
            if(username.getText().isEmpty() || password.getText().isEmpty())
            {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
                return;

            }else{
                if(resultSet.next()){
                      getdata.username=username.getText();
                       alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Success");
                       alert.setHeaderText(null);
                       alert.setContentText("Successfully logged in");
                       alert.showAndWait();
                       loginBtn.getScene().getWindow().hide();
                       Parent root= FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    root.setOnMousePressed((MouseEvent event)->{
                        x = event.getSceneX();
                        y = event.getSceneY();

                    });
                    root.setOnMouseDragged((MouseEvent event)->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();

                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("wrong username or password");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        System.exit(0);
    }
    public void closeBtn(){
        closeBtn.getScene().getWindow().hide();
    }

}