package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

import com.google.api.client.util.Data;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        

        VBox layout = new VBox();
     
        Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));

        layout.getStyleClass().add("color-palette");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#a3d2e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        primaryStage.setMinWidth(600);
        

        Label signIn = new Label("Sign In");
        signIn.setFont(new Font("Impact", 24));
        signIn.setAlignment(Pos.CENTER);
        signIn.setTextFill(Color.CORNFLOWERBLUE);

        TextField username = new TextField("");
        username.setPromptText("Enter username");

        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");

        Button login = new Button("Login");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                  if (username.getText().equals("") || String.valueOf(password.getText()).equals("")) {
                } else
                        try {
                                if (verifyLogin(username.getText(),
                                password.getText()) == -1){
                                        Application.launch(App.class);

                                }
                        } catch (ClassNotFoundException e1) {
                                System.out.println(e1);
                        }
            };
        };
        login.setOnAction(event);

        VBox textFields = new VBox();
        textFields.getChildren().addAll(username, password);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(signIn, textFields, login);
        vbox.setAlignment(Pos.CENTER);


        primaryStage.setScene(new Scene(vbox));
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


        /**
     *
     * @param username
     * @param password
     * @return if the user exists, it returns the user id.
         * @throws ClassNotFoundException
     */
    public static int verifyLogin(String username, String password) throws ClassNotFoundException {
        // Class.forName("com.google.cloud.sql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc");
        String instanceConnectionName = "vast-zodiac-379618:us-central1:wichacks";
        String databaseName = "dressUp";


        String IP_of_instance = "10.83.160.3";
        String username1 = "wichacks";
        String password1 = "imsohungry";

        String jdbcUrl = String.format(
                "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
                 + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
        IP_of_instance,
        databaseName,
        instanceConnectionName);

        try {
                Connection conn = DriverManager.getConnection(jdbcUrl, username1, password1);
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select username, password from userInfo where username=?;");

            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (password == rs.getString(2)) {
                    return 1;
                    //update most recent access date
                }
                else return -1;
        }
            
        } catch (SQLException e) {
                System.out.println("AHHHHH");
                System.out.println(e);
        }

        return -1;

    }
}
