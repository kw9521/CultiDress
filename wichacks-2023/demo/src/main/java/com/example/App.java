package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;


    @Override
    public void start(Stage stage) throws IOException {
        VBox layout = new VBox();
        VBox layout2 = new VBox();
     
        Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));

        layout.getStyleClass().add("color-palette");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#a3d2e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        layout2.getStyleClass().add("color-palette");
        layout2.setBackground(new Background(new BackgroundFill(Color.web("#c5a4eb"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout2.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        Scene scene2 = new Scene(layout2, 900, 600);

        Label name = new Label("Name");

         
        Button button = new Button("Save");
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.setOnAction(e -> stage.setScene(scene2));
         
        TextField text = new TextField();
        text.setMaxWidth(200);

        Image body = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Character.png");
        Image top = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve.png");
        Image bottom = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Baggy.png");
        Image hair = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Hair\\Low_Bun.png");
        Image shoes = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Shoes\\Flats.png");
        ImageView imageView = new ImageView(body);
        imageView.setFitWidth(425);
        imageView.setFitHeight(425);
        imageView.setX(0);
        imageView.setY(0);
        ImageView imageView2 = new ImageView(top);
        imageView2.setFitWidth(425);
        imageView2.setFitHeight(425);
        imageView2.setX(0);
        imageView2.setY(0);
        ImageView imageView3 = new ImageView(bottom);
        imageView3.setFitWidth(425);
        imageView3.setFitHeight(425);
        imageView3.setX(0);
        imageView3.setY(0);
        ImageView imageView4 = new ImageView(hair);
        imageView4.setFitWidth(425);
        imageView4.setFitHeight(425);
        imageView4.setX(0);
        imageView4.setY(0);
        ImageView imageView5 = new ImageView(shoes);
        imageView5.setFitWidth(425);
        imageView5.setFitHeight(425);
        imageView5.setX(50);
        imageView5.setY(50);

        StackPane stackp = new StackPane();
        stackp.setAlignment(Pos.CENTER_LEFT);
        stackp.getChildren().addAll(imageView, imageView2, imageView3, imageView4, imageView5);
        
        
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("body", "shoes", "top", "bottom", "hair");
        cb.setValue("body");
        final ColorPicker colorPicker = new ColorPicker();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                        Color c = colorPicker.getValue();
                        Lighting lighting = new Lighting(new Light.Distant(45, 90, c));
                        ColorAdjust bright = new ColorAdjust(0, 0, 0, .1);
                        lighting.setContentInput(bright);
                        lighting.setSurfaceScale(0.0);
                        String val = cb.getValue();
                        switch (val){
                                case "body": imageView.setEffect(lighting);
                                case "shoes": imageView5.setEffect(lighting);
                                case "top": imageView2.setEffect(lighting);
                                case "bottom": imageView3.setEffect(lighting);
                                case "hair": imageView4.setEffect(lighting);
                        }
                        // todo: fix
                        
                        
                
                }
        };

        HBox hbox = new HBox(10);
        VBox vbox = new VBox(20);
        Button b1 = new Button("Hair");
        Button b2 = new Button("Tops");
        Button b3 = new Button("Bottoms");
        Button b4 = new Button("Shoes");
        Button b5 = new Button("Cultural");
        vbox.getChildren().addAll(b1,b2,b3,b4,b5);
        VBox vbox2 = new VBox();





        // vbox2.getChildren().set(0,vb);
        hbox.getChildren().addAll(stackp, vbox,vbox2);



        colorPicker.setOnAction(event);
        // layout.getChildren().addAll(GridPane)
        layout.getChildren().addAll(name, text, hbox, colorPicker, cb);
        stage.setTitle("CultiDress");
        stage.setScene(scene); 
        stage.show();
        // VBox layout = new VBox();
        // VBox layout2 = new VBox();

        // Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));
        // Scene scene2 = new Scene(layout2, 900, 600, Color.web("#c5a4eb"));
        // stage.setScene(scene);

        // Image image = new Image("file:IMAGES\\CharacterThumbnail.png");

        // Label label1 = new Label("Name:");
        // TextField textField = new TextField();
        // HBox hb = new HBox();
        // hb.getChildren().addAll(label1, textField);
        // hb.setSpacing(10);

        // Button submit = new Button("Next");
        // submit.setOnAction(e -> primaryStage.setScene(scene2));


        // ImageView iv1 = new ImageView();
        // iv1.setImage(image);
        // layout.getChildren().addAll(iv1, hb, submit);


        

        // stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}