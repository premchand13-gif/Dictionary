package com.example.dictionary12;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary extends Application {
    TextField textField;
    Button searchButton;
    Button getMeaningButton;
    Label meaningLabel=new Label();
    Label textLabel;
    ListView<String> suggestion;
    DictionaryUsingHashMap dictionaryUsingHashMap =new DictionaryUsingHashMap();
    Pane root =new Pane();
    Pane find(){
        Pane root=new Pane();
        root.setPrefSize(500,600);

        textField=new TextField();
        textField.setTranslateX(20);
        textField.setTranslateY(20);

        searchButton =new Button("search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(20);


        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word=textField.getText();
                if(word.isBlank()||word.isEmpty()){
                    textLabel.setText("Please enter text");
                    textLabel.setTextFill(Color.RED);
                }
                else{
                    ArrayList<String> meaning=dictionaryUsingHashMap.getSuggestion(word.toLowerCase());
//                    meaningLabel.setText("MEANING : "+meaning);
//                    meaningLabel.setTextFill(Color.GREEN);
                    textLabel.setText("Enter word here");
                    textLabel.setTextFill(Color.BLACK);
                    suggestion.getItems().clear();
                    suggestion.getItems().addAll(meaning);
                }
            }
        });
        getMeaningButton=new Button("Get Meaning");
        getMeaningButton.setTranslateX(350);
        getMeaningButton.setTranslateY(20);
        getMeaningButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word=textField.getText();
                if(word.isBlank()||word.isEmpty()){
                    textLabel.setText("Please enter text");
                    textLabel.setTextFill(Color.RED);
                }
                else{
                    String meaning=dictionaryUsingHashMap.getMeaning(word.toLowerCase());
                    meaningLabel.setText("MEANING : "+meaning);
                    meaningLabel.setTextFill(Color.GREEN);
                    textLabel.setText("Enter word here");
                    textLabel.setTextFill(Color.BLACK);
                }
            }
        });
        textLabel =new Label("Enter word here");
        textLabel.setTranslateX(20);
        textLabel.setTranslateY(50);
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(70);
        suggestion=new ListView<>();
        suggestion.setTranslateX(20);
        suggestion.setTranslateY(90);
//        String[] allWords={"hi","prem"};

//        suggestion.getItems().addAll(allWords);
        suggestion.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String meaning=suggestion.getSelectionModel().getSelectedItem();
                textField.setText(meaning);
            }
        });
       root.setStyle("-fx-background-color: #FFE7C7");
        root.getChildren().addAll(textField, searchButton, getMeaningButton,textLabel,meaningLabel,suggestion);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(find());
        stage.setTitle("                Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}