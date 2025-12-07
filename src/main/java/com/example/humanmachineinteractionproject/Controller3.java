package com.example.humanmachineinteractionproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
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
import java.util.*;
import java.util.List;
import java.util.TimerTask;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.*;
import java.io.IOException;

public class Controller3 {
    @FXML
    Label playershow;
    private Alert alert;
    private DialogPane dialog;
    @FXML
    private Button ticbutton1;
    @FXML
    private Button ticbutton2;
    @FXML
    private Button ticbutton3;
    @FXML
    private Button ticbutton4;
    @FXML
    private Button ticbutton5;
    @FXML
    private Button ticbutton6;
    @FXML
    private Button ticbutton7;
    @FXML
    private Button ticbutton8;
    @FXML
    private Button ticbutton9;
    @FXML
    private Button startgamebutton;
    @FXML
    private Button returnbutton3;
    @FXML
    private Label player1score;
    @FXML
    private Label player2score;
    @FXML
    AnchorPane gamepane2;
    @FXML
    Label nameLabel;
    @FXML
    Label labelhuman;
    @FXML
    Label labelcpu;
    @FXML
    Label nameLabelTwo;
    @FXML
    private Label labelrr;
    @FXML
    private Label labelrr2;
    @FXML
    Label movelabel;
    @FXML
    Label scorelabel2;
    @FXML
    Label scorelabel3;
    @FXML
    Label startgamelabel;



    private Alert alert4;
    private DialogPane dialog4;

    private Stage stage;
    private Scene scene;
    private Parent root;
    DiscordRichPresence rich;
    DiscordEventHandlers handlers;

    int turns = 0;
    private int xCount = 0;
    private int oCount = 0;
    private String startGame = "X";
    private boolean xturn = false;
    private boolean oturn = false;
    private boolean gameOver = false;

    private String[][] board = new String[3][3];
    private boolean playerTurn = true;

    private Media media;
    private MediaPlayer mediaPlayer;

    public void enteredButton5(){
        returnbutton3.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(97,43,3,1), 10, 0, 0, 0)");
    }

    public void exitedButton5(){
        returnbutton3.setStyle("");
    }

    public void enteredButton6(){
        startgamebutton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(4,88,7,1), 10, 0, 0, 0)");
    }

    public void exitedButton6(){
        startgamebutton.setStyle("");
    }
    public void initialize() {


        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("Round Not Started Yet").setDetails("Playing a 1 player Game").build();
        DiscordRPC.discordUpdatePresence(rich);

        ticbutton1.setOnAction(e -> player(ticbutton1, 0, 0));
        ticbutton2.setOnAction(e -> player(ticbutton2, 0, 1));
        ticbutton3.setOnAction(e -> player(ticbutton3, 0, 2));
        ticbutton4.setOnAction(e -> player(ticbutton4, 1, 0));
        ticbutton5.setOnAction(e -> player(ticbutton5, 1, 1));
        ticbutton6.setOnAction(e -> player(ticbutton6, 1, 2));
        ticbutton7.setOnAction(e -> player(ticbutton7, 2, 0));
        ticbutton8.setOnAction(e -> player(ticbutton8, 2, 1));
        ticbutton9.setOnAction(e -> player(ticbutton9, 2, 2));


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
        rich = new DiscordRichPresence.Builder("X Score: " + player1score.getText() + " ||||| " + "O Score: " + player2score.getText()).setDetails("In The Middle of a Round").build();

        DiscordRPC.discordUpdatePresence(rich);
        System.out.println(startGame);
        gameOver = false;
        gamepane2.setDisable(false);
        returnbutton3.setDisable(true);
        startgamebutton.setDisable(true);
        startgamelabel.setStyle("-fx-opacity: 0");
        playershow.setStyle("-fx-opacity: 1");

        if(startGame=="X"){
            playershow.setText("Player X's Turn");
            player1score.setStyle("-fx-opacity: 1");
            nameLabel.setStyle("-fx-opacity: 1");
            labelhuman.setStyle("-fx-opacity: 1");
            scorelabel2.setStyle("-fx-opacity: 1");

            player2score.setStyle("-fx-opacity: 0.4");
            nameLabelTwo.setStyle("-fx-opacity: 0.4");
            labelcpu.setStyle("-fx-opacity: 0.4");
            scorelabel3.setStyle("-fx-opacity: 0.4");
        }
        else{
            playershow.setText("Player O's Turn");
            nameLabel.setStyle("-fx-opacity: 0.4");
            player1score.setStyle("-fx-opacity: 0.4");
            labelhuman.setStyle("-fx-opacity: 0.4");
            scorelabel2.setStyle("-fx-opacity: 0.4");

            player2score.setStyle("-fx-opacity: 1");
            nameLabelTwo.setStyle("-fx-opacity: 1");
            labelcpu.setStyle("-fx-opacity: 1");
            scorelabel3.setStyle("-fx-opacity: 1");
            handleCpuMove();
        }
    }

    private void player(Button button, int row, int col) {
        if(!button.getText().isEmpty() || !playerTurn){
            illegalmove();
            delay(1000, () -> dis());
            return;
        }

        if (playerTurn && board[row][col] == null) {
            board[row][col] = "X"; // Player uses "X"
            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-4.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }
            choosePlayer();
            button.setStyle("-fx-background-color: #5594fd");
            button.setText("X");
            playerTurn = false;
            turns++;



            if (!checkWinner("X")) {
                delay(800, () -> handleCpuMove());
            }
        }
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
        System.out.println("illegalmove");
        movelabel.setStyle("-fx-opacity: 1");
        return;
    }
    public void dis(){
        movelabel.setStyle("-fx-opacity: 0");
    }

    private void handleCpuMove() {
        int[] bestMove = findBestMove();
        if (bestMove != null) {
            board[bestMove[0]][bestMove[1]] = "O"; // CPU uses "O"
            Button cpuButton = getButtonForPosition(bestMove[0], bestMove[1]);
            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/retro-coin-2.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }
            cpuButton.setText("O");
            choosePlayer();
            turns++;
            cpuButton.setStyle("-fx-background-color: #fe7c68");

        }



        if (!checkWinner("O")) {
            playerTurn = true;
        }
    }

    private Button getButtonForPosition(int row, int col) {
        if (row == 0 && col == 0) return ticbutton1;
        if (row == 0 && col == 1) return ticbutton2;
        if (row == 0 && col == 2) return ticbutton3;
        if (row == 1 && col == 0) return ticbutton4;
        if (row == 1 && col == 1) return ticbutton5;
        if (row == 1 && col == 2) return ticbutton6;
        if (row == 2 && col == 0) return ticbutton7;
        if (row == 2 && col == 1) return ticbutton8;
        if (row == 2 && col == 2) return ticbutton9;
        return null;
    }

    private int[] findBestMove() {
        int bestValue = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    board[i][j] = "O"; // Simulate CPU move
                    int moveValue = minimax(0, false);
                    board[i][j] = null; // Undo the move

                    if (moveValue > bestValue) {
                        bestValue = moveValue;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimax(int depth, boolean isMaximizing) {
        String result = checkGameState();
        if (result != null) {
            return switch (result) {
                case "X" -> -10 + depth; // Favor faster wins for the player
                case "O" -> 10 - depth;  // Favor slower losses for the CPU
                case "draw" -> 0;
                default -> 0;
            };
        }

        if (isMaximizing) {
            int bestValue = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == null) {
                        board[i][j] = "O"; // Simulate CPU move
                        bestValue = Math.max(bestValue, minimax(depth + 1, false));
                        board[i][j] = null; // Undo the move
                    }
                }
            }
            return bestValue;
        } else {
            int bestValue = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == null) {
                        board[i][j] = "X"; // Simulate player move
                        bestValue = Math.min(bestValue, minimax(depth + 1, true));
                        board[i][j] = null; // Undo the move
                    }
                }
            }
            return bestValue;
        }
    }

    private String checkGameState() {
        int[][] winningPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontal
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertical
                {0, 4, 8}, {2, 4, 6}             // Diagonal
        };

        for (int[] pos : winningPositions) {
            String a = getBoardValue(pos[0]);
            String b = getBoardValue(pos[1]);
            String c = getBoardValue(pos[2]);
            if (a != null && a.equals(b) && a.equals(c)) {
                return a;
            }
        }

        for (String[] row : board) {
            for (String cell : row) {
                if (cell == null) {
                    return null; // Game is ongoing
                }
            }
        }

        return "draw"; // It's a draw
    }

    private String getBoardValue(int pos) {
        return board[pos / 3][pos % 3];
    }

    private boolean checkWinner(String symbol) {
        String result = checkGameState();

        if (result != null) {
            if (result.equals("X")) { // Case for "X" winning
                if (symbol.equals("X")) {
                    showPopupAlert("X");
                }
                endGame("Player X wins!");
                return true;
            } else if (result.equals("O")) { // Case for "O" winning
                if (symbol.equals("O")) {
                    showPopupAlert("O");
                }
                endGame("CPU O wins!");
                return true;
            } else if (result.equals("draw")) { // Case for a draw
                showPopupAlert("D");
                endGame("It's a draw!");
                return true;
            }
        }

        return false;
    }

    private void showPopupAlert(String symbol){
        if(symbol.equals("O")){
            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("O WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            gameOver = true;

            oCount++;
            gameScore();
            resetGame();
            return;
        }
        if(symbol.equals("X")){
            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("X WINS THE ROUND!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            gameOver = true;

            xCount++;
            gameScore();
            resetGame();
            return;
        }
        if(symbol.equals("D")){
            try {
                File soundFile = new File("src/main/resources/com/example/humanmachineinteractionproject/victory.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                event.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(this.getClass().getResource("trophy.png").toString()));
            dialog = alert.getDialogPane();
            dialog.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            dialog.getStyleClass().add("dialog");
            alert.setContentText("TIE GAME!!");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.show();

            gameOver = true;
            resetGame();
            System.out.println("Tie Game");
        }
    }
    private void endGame(String message) {
        System.out.println(message);

    }


    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
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
        startgamebutton.setDisable(false);
        gamepane2.setDisable(true);
        returnbutton3.setDisable(false);

        nameLabel.setStyle("-fx-opacity: 1");
        player1score.setStyle("-fx-opacity: 1");
        labelhuman.setStyle("-fx-opacity: 1");
        scorelabel2.setStyle("-fx-opacity: 1");

        player2score.setStyle("-fx-opacity: 1");
        nameLabelTwo.setStyle("-fx-opacity: 1");
        labelcpu.setStyle("-fx-opacity: 1");
        scorelabel3.setStyle("-fx-opacity: 1");

        startgamelabel.setStyle("-fx-opacity: 1");
        playershow.setStyle("-fx-opacity: 0.4");

        board = new String[3][3];

        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("Round Not Started Yet").setDetails("Playing a 1 player Game").build();
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
        if(startGame.equalsIgnoreCase("X")){
            playershow.setText("Player O's Turn");
            startGame = "0";
            nameLabel.setStyle("-fx-opacity: 0.4");
            player1score.setStyle("-fx-opacity: 0.4");
            labelhuman.setStyle("-fx-opacity: 0.4");
            scorelabel2.setStyle("-fx-opacity: 0.4");

            nameLabelTwo.setStyle("-fx-opacity: 1");
            player2score.setStyle("-fx-opacity: 1");
            labelcpu.setStyle("-fx-opacity: 1");
            scorelabel3.setStyle("-fx-opacity: 1");
            playerTurn = false;
            xturn = false;
            oturn = true;
        }
        else{
            playershow.setText("Player X's Turn");
            startGame = "X";
            nameLabel.setStyle("-fx-opacity: 1");
            player1score.setStyle("-fx-opacity: 1");
            labelhuman.setStyle("-fx-opacity: 1");
            scorelabel2.setStyle("-fx-opacity: 1");

            nameLabelTwo.setStyle("-fx-opacity: 0.4");
            player2score.setStyle("-fx-opacity: 0.4");
            labelcpu.setStyle("-fx-opacity: 0.4");
            scorelabel3.setStyle("-fx-opacity: 0.4");
            playerTurn = true;
            xturn = true;
            oturn = false;
        }
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

        Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION);
        dialog4 = alert4.getDialogPane();
        alert4.setGraphic(new ImageView(this.getClass().getResource("warning.png").toString()));
        dialog4.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        dialog4.getStyleClass().add("dialog2");
        alert4.setTitle("Return to Main Menu");
        alert4.setHeaderText("You are About to return to the main menu");
        alert4.setContentText("All game progress (Score, time) will be lost, are you sure you wish to exit?");
        if(alert4.showAndWait().get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
                System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            }).build();
            DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
            rich = new DiscordRichPresence.Builder("").setDetails("In the Main Menu").build();
            DiscordRPC.discordUpdatePresence(rich);
        }
    }
}
