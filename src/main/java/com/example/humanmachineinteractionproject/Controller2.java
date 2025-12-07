package com.example.humanmachineinteractionproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.sound.sampled.*;

public class Controller2 implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Alert alert2;
    private DialogPane dialog2;

    private Alert alert3;
    private DialogPane dialog3;
    @FXML
    Button returnButton3;
    @FXML
    ColorPicker mycolorpicker1;
    @FXML
    private AnchorPane scene1;
    @FXML
    AnchorPane gamepane;
    @FXML
    Button ticbutton1;
    @FXML
    Label timechoice;
    @FXML
    Button playbutton1;
    @FXML
    Button instructions;
    @FXML
    Button about;
    @FXML
    Button exitgame;
    @FXML
    Button player1game;
    boolean timepicked;
    String temp = "0:30";

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue(temp);
        timechoice.setText(temp);
        choiceBox.getItems().addAll("∞", "0:30", "1:00");
        choiceBox.setStyle("-fx-font-family: 'Pixelify Sans'");
        choiceBox.setOnAction(this::getData);
    }

    private void getData(ActionEvent event) {
        String selectedtime = choiceBox.getValue();
        timechoice.setText(selectedtime);
        timepicked = true;
    }

    public void enteredButton() {
        playbutton1.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void enteredButton2() {
        instructions.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void enteredButton3() {
        about.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void enteredButton4() {
        exitgame.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(133,24,9,1), 10, 0, 0, 0)");
    }

    public void exitedButton() {
        playbutton1.setStyle("");
    }

    public void exitedButton2() {
        instructions.setStyle("");
    }

    public void exitedButton3() {
        about.setStyle("");
    }

    public void exitedButton4() {
        exitgame.setStyle("");
    }

    public void enteredButton15() {
        player1game.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void exitedButton15() {
        player1game.setStyle("");
    }


    DiscordRichPresence rich;
    DiscordEventHandlers handlers;


    public void login(ActionEvent event) throws IOException {

        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException eve) {
            eve.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamescene.fxml"));
        root = loader.load();


        Controller scene2Controller = loader.getController();
        scene2Controller.gamepane.setDisable(true);
        scene2Controller.movelabel.setStyle("-fx-opacity: 0");
        scene2Controller.labelrr.setText(timechoice.getText());
        scene2Controller.labelrr2.setText(timechoice.getText());
        scene2Controller.playershow.setStyle("-fx-opacity: 0.4");

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchtogamecpu(ActionEvent event) throws IOException {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException eve) {
            eve.printStackTrace();
        }

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("").setDetails("Playing a 1 player Game").build();
        DiscordRPC.discordUpdatePresence(rich);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("singlepl.fxml"));
        root = loader.load();

        Controller3 singlepl = loader.getController();
        singlepl.gamepane2.setDisable(true);
        singlepl.movelabel.setStyle("-fx-opacity: 0");
        singlepl.playershow.setStyle("-fx-opacity: 0.4");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToSceneInstructions(ActionEvent e) throws IOException {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException eve) {
            eve.printStackTrace();
        }

        Parent root = FXMLLoader.load(getClass().getResource("scenegamesettings.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("").setDetails("In The App Guide").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public void exit(ActionEvent event) {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException eve) {
            eve.printStackTrace();
        }

        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        dialog2 = alert2.getDialogPane();
        alert2.setGraphic(new ImageView(this.getClass().getResource("warning.png").toString()));
        dialog2.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        dialog2.getStyleClass().add("dialog2");
        alert2.setTitle("Exit Game Screen");
        alert2.setHeaderText("You are About to Exit the Game");
        alert2.setContentText("Are you sure you wish to exit the Application?");

        if (alert2.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scene1.getScene().getWindow();
            System.out.println("You exited the game");
            stage.close();
        }

    }

    public void about(ActionEvent e) throws IOException {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            event.printStackTrace();
        }

        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("").setDetails("In The About Section").build();
        DiscordRPC.discordUpdatePresence(rich);
    }


    public void switchToSceneMain(ActionEvent e) throws IOException {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            event.printStackTrace();
        }

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}


