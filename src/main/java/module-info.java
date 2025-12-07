module com.example.humanmachineinteractionproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires discord.rpc;
    requires javafx.media;

    opens com.example.humanmachineinteractionproject to javafx.fxml;
    exports com.example.humanmachineinteractionproject;
}