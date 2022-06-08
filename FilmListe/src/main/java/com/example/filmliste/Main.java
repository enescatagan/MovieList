package com.example.filmliste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("film-ekle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 630);
        stage.setTitle("Film Listele!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //DataBase Connect
        /*MsSql con = new MsSql();
        con.connect();*/

        launch();
    }
}

//TODO-1: Listelere Girilen Filmleri Veritabanından sil
//TODO-2: İzlediklerim ve izleyeceklerim tablolarındaki verileri güncelle