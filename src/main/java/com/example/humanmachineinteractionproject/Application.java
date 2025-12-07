package com.example.humanmachineinteractionproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;



public class Application extends javafx.application.Application {


    DiscordRichPresence rich;
    DiscordEventHandlers handlers;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tic Tac Toe");
        Image icon = new Image("im.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);



        handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();
        DiscordRPC.discordInitialize("1312731661879742464", handlers, true);
        rich = new DiscordRichPresence.Builder("").setDetails("In The Main Menu").build();
        DiscordRPC.discordUpdatePresence(rich);

        String css = this.getClass().getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}