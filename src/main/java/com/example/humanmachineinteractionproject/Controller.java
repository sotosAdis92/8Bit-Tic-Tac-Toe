package com.example.humanmachineinteractionproject;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.awt.color.*;
import javafx.concurrent.Task;


import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.TimerTask;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.sound.sampled.*;

public class Controller implements Initializable {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    Label labelrr2;
    @FXML
    Label x;
    @FXML
    Label o;
    @FXML
    private Button exitgame;
    @FXML
    Label playertime1;
    @FXML
    Label playertime2;
    @FXML
    private Label player1score;
    @FXML
    private Label player2score;
    @FXML
    private Label player1name;
    @FXML
    private Label player2name;

    @FXML
    Button ticbutton1;
    @FXML
    Button ticbutton2;
    @FXML
    Button ticbutton3;
    @FXML
    Button ticbutton4;
    @FXML
    Button ticbutton5;
    @FXML
    Button ticbutton6;
    @FXML
    Button ticbutton7;
    @FXML
    Button ticbutton8;
    @FXML
    Button ticbutton9;
    @FXML
    Label labelrr;
    @FXML
    private Button about;
    @FXML
    private AnchorPane boardPane;
    @FXML
    private TextField nameTextField1;
    private String startGame = "X";
    private int xCount = 0;
    private int oCount = 0;
    public boolean wonflag = false;
    int turns = 0;
    boolean gameOver = false;
    private Integer seconds;
    private int minutes;
    private Alert alert3;
    private DialogPane dialog3;
    @FXML
    Label movelabel;

    private boolean xturn = false;
    private boolean oturn = false;

    private Integer seconds2;
    private int minutes2;

    boolean longgame;
    boolean shortgame;
    boolean fortyfive;
    boolean fiftyfive;
    boolean two;
    boolean notime;

    boolean timeout1;
    boolean timeout2;

    private Alert alert;
    private DialogPane dialog;

    @FXML
    Button returnbutton3;
    @FXML
    Button returnbutton4;
    @FXML
    Hyperlink hyperlink;
    @FXML
    Label scorelabel;
    @FXML
    Label scorelabel1;
    //private int time = seconds;
    //private int time2 = seconds2;
    @FXML
    Button startgamebutton;
    @FXML
    Label playershow;
    @FXML
    AnchorPane gamepane;
    @FXML
    Label nameLabel;
    @FXML
    Label nameLabelTwo;
    @FXML
    Label startgamelabel;
    ArrayList<Button> buttons;

    DiscordRichPresence rich;
    DiscordEventHandlers handlers;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("Round Not Started Yet").setDetails("Playing a 2 Player Game").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public void enteredButton5(){
        returnbutton3.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void exitedButton5(){
        returnbutton3.setStyle("");
    }

    public void enteredButton8(){
        returnbutton4.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void exitedButton8(){
        returnbutton4.setStyle("");
    }

    public void enteredButton6(){
        startgamebutton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(4,88,7,1), 10, 0, 0, 0)");
    }

    public void exitedButton6(){
        startgamebutton.setStyle("");
    }



    public void displayName(String username) {
        nameLabel.setText(username);
    }

    public void displayName2(String username2) {
        nameLabelTwo.setText(username2);
    }

    public void hyperlink(ActionEvent e) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.exploratorium.edu/explore/puzzles/tictactoe"));
    }


 /*   public void switchToScene1(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sceneplayersettings.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } */

    public void openlink(ActionEvent e)throws URISyntaxException, IOException {
        System.out.println("Link clicked");
        Desktop.getDesktop().browse(new URI("https://www.exploratorium.edu/explore/puzzles/tictactoe"));
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

        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        dialog3 = alert3.getDialogPane();
        alert3.setGraphic(new ImageView(this.getClass().getResource("warning.png").toString()));
        dialog3.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        dialog3.getStyleClass().add("dialog2");
        alert3.setTitle("Return to Main Menu");
        alert3.setHeaderText("You are About to return to the main menu");
        alert3.setContentText("All game progress (Score, time) will be lost, are you sure you wish to exit?");
        if(alert3.showAndWait().get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
                System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            }).build();
            DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
            rich = new DiscordRichPresence.Builder("").setDetails("In The Main Menu").build();
            DiscordRPC.discordUpdatePresence(rich);
        }

    }

    public void switchToSceneMain2(ActionEvent e) throws IOException {
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            event.printStackTrace();
        }

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("").setDetails("In The Main Menu").build();
        DiscordRPC.discordUpdatePresence(rich);
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
 /*   public void switchToScene2(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scenegamesettings.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } */
 /*public void switchToSceneGame(ActionEvent e) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("gamescene.fxml"));
     stage = (Stage)((Node)e.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
 }*/
 public void checkTime(){
     if(labelrr.getText().equals("1:00")){
         seconds = 0;
         minutes = 1;
         longgame = true;
     }
     else if(labelrr.getText().equals("0:30")){
         seconds = 30;
         minutes = 0;
         shortgame = true;
     }
 }


    public void checkTime2(){
        if(labelrr2.getText().equals("1:00")){
            seconds2 = 0;
            minutes2 = 1;
            longgame = true;
        }
        else if(labelrr2.getText().equals("0:30")){
            seconds2 = 30;
            minutes2 = 0;
            shortgame = true;
        }
    }

    private void doTime() {
        Timeline time= new Timeline();
        KeyFrame frame= new KeyFrame(Duration.seconds(0.8), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!labelrr.getText().equals("∞")) {
                    checkTime();
                    if (gameOver == false) {
                        seconds--;
                        labelrr.setText(minutes + ":" + seconds);
                        if (seconds == -1) {
                            seconds = 59;
                            minutes--;
                            labelrr.setText(minutes + ":" + seconds);
                        }
                        if (seconds < 10 && minutes<1) {
                            labelrr.setStyle("-fx-text-fill: red");
                            labelrr.setText(minutes + ":0" + seconds);
                        }
                        if (oturn == true) {
                            time.stop();
                        }
                        if (seconds == 0 && minutes == 0) {
                            //playershow.setText("Player O's turn");
                            startGame = "O";
                            oCount++;
                            gameScore();
                            timeout1 = true;

                            try {
                                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioIn);
                                clip.start();
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ev) {
                                ev.printStackTrace();
                            }

                            Alert alert = new Alert(Alert.AlertType.NONE);
                            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
                            dialog = alert.getDialogPane();
                            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
                            dialog.getStyleClass().add("dialog");
                            alert.setContentText("X's TIME RAN OUT,O WINS THE ROUND!!");
                            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                            alert.show();

                            resetbutton();
                            time.stop();
                            startgamebutton.setDisable(false);
                            gamepane.setDisable(true);
                        }
                        if (labelrr.getText().equals("∞")) {
                            time.stop();
                        }

                    } else if (gameOver == true) {
                        time.stop();
                        startgamebutton.setDisable(false);
                    }
                }
            }
        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        time.play();
    }

    private void doTime2() {
        Timeline time2= new Timeline();
        KeyFrame frame2= new KeyFrame(Duration.seconds(0.8), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!labelrr2.getText().equals("∞")) {
                    checkTime2();
                    if (gameOver == false) {
                        seconds2--;
                        labelrr2.setText(minutes2 + ":" + seconds2);
                        if (seconds2 == -1) {
                            seconds2 = 59;
                            minutes2--;
                            labelrr2.setText(minutes2 + ":" + seconds2);
                        }
                        if (seconds2 < 10 && minutes2<1) {
                            labelrr2.setText(minutes2 + ":0" + seconds2);
                            labelrr2.setStyle("-fx-text-fill: red");
                        }
                        if (xturn == true) {
                            time2.stop();
                        }
                        if (seconds2 == 0 && minutes2 == 0) {
                            //playershow.setText("Player X's turn");
                            startGame = "X";
                            xCount++;
                            gameScore();
                            timeout2 = true;

                            try {
                                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioIn);
                                clip.start();
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ev) {
                                ev.printStackTrace();
                            }

                            Alert alert = new Alert(Alert.AlertType.NONE);
                            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
                            dialog = alert.getDialogPane();
                            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
                            dialog.getStyleClass().add("dialog");
                            alert.setContentText("Ο's TIME RAN OUT,X WINS THE ROUND!!");
                            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                            alert.show();

                            resetbutton();
                            time2.stop();
                            startgamebutton.setDisable(false);
                            gamepane.setDisable(true);
                        }
                        if (labelrr.getText().equals("∞")) {
                            time2.stop();
                        }

                    } else if (gameOver == true) {
                        time2.stop();
                        startgamebutton.setDisable(false);

                    }
                }
            }
        });

        time2.setCycleCount(Timeline.INDEFINITE);
        time2.getKeyFrames().add(frame2);
        time2.play();
    }



    public void startGame(ActionEvent e) throws IOException{
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            event.printStackTrace();
        }

        System.out.println(player1score.getText());
        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("X Score: " + player1score.getText() + " |||| " + "O Score: " + player2score.getText()).setDetails("In The Middle of a Round").build();
        DiscordRPC.discordUpdatePresence(rich);

        System.out.println("Started");
        System.out.println("StartGame= "+startGame);
        if(timeout1==true){

            choosePlayer();
            timeout1 = false;
        }
        else if (timeout2==true) {

            choosePlayer();
            timeout2 = false;
        }
        else{
            gameOver=false;
            if(startGame.equals("X")) {
                playershow.setText("Player X's Turn");
                player1score.setStyle("-fx-opacity: 1");
                nameLabel.setStyle("-fx-opacity: 1");
                labelrr.setStyle("-fx-opacity: 1");
                playertime1.setStyle("-fx-opacity: 1");
                scorelabel.setStyle("-fx-opacity: 1");

                player2score.setStyle("-fx-opacity: 0.4");
                nameLabelTwo.setStyle("-fx-opacity: 0.4");
                labelrr2.setStyle("-fx-opacity: 0.4");
                playertime2.setStyle("-fx-opacity: 0.4");
                scorelabel1.setStyle("-fx-opacity: 0.4");
                doTime();
            }
            if(startGame.equals("O")) {
                nameLabel.setStyle("-fx-opacity: 0.4");
                player1score.setStyle("-fx-opacity: 0.4");
                labelrr.setStyle("-fx-opacity: 0.4");
                playertime1.setStyle("-fx-opacity: 0.4");
                scorelabel.setStyle("-fx-opacity: 0.4");

                nameLabelTwo.setStyle("-fx-opacity: 1");
                player2score.setStyle("-fx-opacity: 1");
                labelrr2.setStyle("-fx-opacity: 1");
                playertime2.setStyle("-fx-opacity: 1");
                scorelabel1.setStyle("-fx-opacity: 1");
                doTime2();
            }
        }
        startgamelabel.setStyle("-fx-opacity: 0");
        playershow.setStyle("-fx-opacity: 1");
        gameOver = false;
        returnbutton3.setDisable(true);
        gamepane.setDisable(false);
        startgamebutton.setDisable(true);
    }

    public void ticButton1action(ActionEvent e) throws IOException{


        if(ticbutton1.getText()=="") {

                ticbutton1.setText(startGame);
                if (startGame.equalsIgnoreCase("X")) {
                    ticbutton1.setStyle("-fx-background-color: #5594fd");

                    try {
                        File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                        event.printStackTrace();
                    }

                } else {

                    ticbutton1.setStyle("-fx-background-color: #fe7c68");

                    try {
                        File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                        event.printStackTrace();
                    }
                }
                choosePlayer();
                turns++;

        }
        else if(ticbutton1.getText()=="X" || ticbutton1.getText()=="O"){
            illegalmove();
        }

        winninggame();

    }

    public void ticButton2action(ActionEvent e) throws IOException{
        if(ticbutton2.getText()=="") {
            ticbutton2.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton2.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton2.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton2.getText()=="X" || ticbutton2.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton3action(ActionEvent e) throws IOException{
        if(ticbutton3.getText()=="") {
            ticbutton3.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton3.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton3.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton3.getText()=="X" || ticbutton3.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton4action(ActionEvent e) throws IOException{
        if(ticbutton4.getText()=="") {
            ticbutton4.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton4.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton4.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton4.getText()=="X" || ticbutton4.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton5action(ActionEvent e) throws IOException{
        if(ticbutton5.getText()=="") {
            ticbutton5.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton5.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton5.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton5.getText()=="X" || ticbutton5.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton6action(ActionEvent e) throws IOException{
        if(ticbutton6.getText()=="") {
            ticbutton6.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton6.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton6.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton6.getText()=="X" || ticbutton6.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton7action(ActionEvent e) throws IOException{
        if(ticbutton7.getText()=="") {
            ticbutton7.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton7.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton7.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton7.getText()=="X" || ticbutton7.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton8action(ActionEvent e) throws IOException{
        if(ticbutton8.getText()=="") {
            ticbutton8.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton8.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton8.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton8.getText()=="X" || ticbutton8.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void ticButton9action(ActionEvent e) throws IOException{
        if(ticbutton9.getText()=="") {
            ticbutton9.setText(startGame);
            if (startGame.equalsIgnoreCase("X")) {

                ticbutton9.setStyle("-fx-background-color: #5594fd");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            } else {

                ticbutton9.setStyle("-fx-background-color: #fe7c68");

                try {
                    File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                    event.printStackTrace();
                }

            }
            choosePlayer();
            turns++;
        }
        else if(ticbutton9.getText()=="X" || ticbutton9.getText()=="O"){
            illegalmove();
        }


        winninggame();

    }

    public void illegalmove(){
        try {
            File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-powerup.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
            event.printStackTrace();
        }
        movelabel.setStyle("-fx-opacity: 1");
        delay(1000, () -> dis());
    }
    public void dis(){
        movelabel.setStyle("-fx-opacity: 0");
    }



    public void winninggame(){
        String b1 = ticbutton1.getText();
        String b2 = ticbutton2.getText();
        String b3 = ticbutton3.getText();

        String b4 = ticbutton4.getText();
        String b5 = ticbutton5.getText();
        String b6 = ticbutton6.getText();

        String b7 = ticbutton7.getText();
        String b8 = ticbutton8.getText();
        String b9 = ticbutton9.getText();


        //PLAYER X CONDING
        if(b1 == ("X") && b2 == ("X") && b3 == ("X")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton2.setStyle("-fx-background-color: yellow");
            ticbutton3.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            startGame = "O";

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }

        if(b4 == ("X") && b5 == ("X") && b6 == ("X")){
            ticbutton4.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton6.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b7 == ("X") && b8 == ("X") && b9 == ("X")){
            ticbutton7.setStyle("-fx-background-color: yellow");
            ticbutton8.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b1 == ("X") && b4 == ("X") && b7 == ("X")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton4.setStyle("-fx-background-color: yellow");
            ticbutton7.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b2 == ("X") && b5 == ("X") && b8 == ("X")){
            ticbutton2.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton8.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b3 == ("X") && b6 == ("X") && b9 == ("X")){
            ticbutton3.setStyle("-fx-background-color: yellow");
            ticbutton6.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b1 == ("X") && b5 == ("X") && b9 == ("X")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b3 == ("X") && b5 == ("X") && b7 == ("X")){
            ticbutton3.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton7.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            xCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }


        //PLAYER O CONDING
        if(b1 == ("O") && b2 == ("O") && b3 == ("O")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton2.setStyle("-fx-background-color: yellow");
            ticbutton3.setStyle("-fx-background-color: yellow");


            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            startGame = "X";

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b4 == ("O") && b5 == ("O") && b6 == ("O")){
            ticbutton4.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton6.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b7 == ("O") && b8 == ("O") && b9 == ("O")){
            ticbutton7.setStyle("-fx-background-color: yellow");
            ticbutton8.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b1 == ("O") && b4 == ("O") && b7 == ("O")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton4.setStyle("-fx-background-color: yellow");
            ticbutton7.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b2 == ("O") && b5 == ("O") && b8 == ("O")){
            ticbutton2.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton8.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b3 == ("O") && b6 == ("O") && b9 == ("O")){
            ticbutton3.setStyle("-fx-background-color: yellow");
            ticbutton6.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b1 == ("O") && b5 == ("O") && b9 == ("O")){
            ticbutton1.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton9.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        if(b3 == ("O") && b5 == ("O") && b7 == ("O")){
            ticbutton3.setStyle("-fx-background-color: yellow");
            ticbutton5.setStyle("-fx-background-color: yellow");
            ticbutton7.setStyle("-fx-background-color: yellow");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            oCount++;
            gameScore();
            resetbutton();
            gameOver = true;
            gamepane.setDisable(true);
            return;
        }
        System.out.println(turns);
        if(turns==9){
            ticbutton1.setStyle("-fx-background-color: orange");
            ticbutton2.setStyle("-fx-background-color: orange");
            ticbutton3.setStyle("-fx-background-color: orange");
            ticbutton4.setStyle("-fx-background-color: orange");
            ticbutton5.setStyle("-fx-background-color: orange");
            ticbutton6.setStyle("-fx-background-color: orange");
            ticbutton7.setStyle("-fx-background-color: orange");
            ticbutton8.setStyle("-fx-background-color: orange");
            ticbutton9.setStyle("-fx-background-color: orange");

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("TIE GAME!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            gameOver = true;
            gamepane.setDisable(true);
            resetbutton();
            System.out.println("Tie Game");
        }
    }

    public void resetbutton(){

        delay(1500, () -> ticbutton1.setText(""));
        delay(1500, () -> ticbutton1.setStyle(null));


        delay(1500, () -> ticbutton2.setText(""));
        delay(1500, () -> ticbutton2.setStyle(null));

        delay(1500, () -> ticbutton3.setText(""));
        delay(1500, () -> ticbutton3.setStyle(null));

        delay(1500, () -> ticbutton4.setText(""));
        delay(1500, () -> ticbutton4.setStyle(null));

        delay(1500, () -> ticbutton5.setText(""));
        delay(1500, () -> ticbutton5.setStyle(null));

        delay(1500, () -> ticbutton6.setText(""));
        delay(1500, () -> ticbutton6.setStyle(null));

        delay(1500, () -> ticbutton7.setText(""));
        delay(1500, () -> ticbutton7.setStyle(null));

        delay(1500, () -> ticbutton8.setText(""));
        delay(1500, () -> ticbutton8.setStyle(null));

        delay(1500, () -> ticbutton9.setText(""));
        delay(1500, () -> ticbutton9.setStyle(null));
        turns = 0;



        if(longgame==true){
            seconds = 0;
            seconds2 = 0;
            minutes = 1;
            minutes2 = 1;
            labelrr.setText("1:00");
            labelrr2.setText("1:00");
            longgame = false;
        }
        else if(shortgame==true){
            seconds = 30;
            seconds2 = 30;
            labelrr.setText("0:30");
            labelrr2.setText("0:30");
            shortgame = false;
        }
        else if(notime==true){
            labelrr.setText("∞");
            labelrr2.setText("∞");
            seconds = -2;
            seconds2 = -2;
            notime = false;
        }
        startgamebutton.setDisable(false);
        returnbutton3.setDisable(false);
        nameLabel.setStyle("-fx-opacity: 1");
        player1score.setStyle("-fx-opacity: 1");
        labelrr.setStyle("-fx-opacity: 1");
        playertime1.setStyle("-fx-opacity: 1");
        scorelabel.setStyle("-fx-opacity: 1");

        nameLabelTwo.setStyle("-fx-opacity: 1");
        player2score.setStyle("-fx-opacity: 1");
        labelrr2.setStyle("-fx-opacity: 1");
        playertime2.setStyle("-fx-opacity: 1");
        scorelabel1.setStyle("-fx-opacity: 1");

        labelrr.setStyle("-fx-text-fill: black");
        labelrr2.setStyle("-fx-text-fill: black");

        startgamelabel.setStyle("-fx-opacity: 1");
        playershow.setStyle("-fx-opacity: 0.4");

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("Round Not Started Yet").setDetails("Playing a 2 Player Game").build();
        DiscordRPC.discordUpdatePresence(rich);


    }
    public static void delay(long millis, Runnable continuation){
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception{
                try{Thread.sleep(millis); }
                catch (InterruptedException e){}
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    public void gameScore(){
        player1score.setText(String.valueOf(xCount));
        player2score.setText(String.valueOf(oCount));
    }

    public void choosePlayer(){
     System.out.println("StartGame= "+startGame);
        if(startGame.equalsIgnoreCase("X")){
            startGame = "O";
            playershow.setText("Player O's Turn");
            nameLabel.setStyle("-fx-opacity: 0.4");
            player1score.setStyle("-fx-opacity: 0.4");
            labelrr.setStyle("-fx-opacity: 0.4");
            playertime1.setStyle("-fx-opacity: 0.4");
            scorelabel.setStyle("-fx-opacity: 0.4");

            nameLabelTwo.setStyle("-fx-opacity: 1");
            player2score.setStyle("-fx-opacity: 1");
            labelrr2.setStyle("-fx-opacity: 1");
            playertime2.setStyle("-fx-opacity: 1");
            scorelabel1.setStyle("-fx-opacity: 1");
            xturn = false;
            oturn = true;
            doTime2();
        }
        else{
            startGame = "X";
            playershow.setText("Player X's Turn");
            player1score.setStyle("-fx-opacity: 1");
            nameLabel.setStyle("-fx-opacity: 1");
            labelrr.setStyle("-fx-opacity: 1");
            playertime1.setStyle("-fx-opacity: 1");
            scorelabel.setStyle("-fx-opacity: 1");

            player2score.setStyle("-fx-opacity: 0.4");
            nameLabelTwo.setStyle("-fx-opacity: 0.4");
            labelrr2.setStyle("-fx-opacity: 0.4");
            playertime2.setStyle("-fx-opacity: 0.4");
            scorelabel1.setStyle("-fx-opacity: 0.4");
            xturn = true;
            oturn = false;
            doTime();
        }
    }




}