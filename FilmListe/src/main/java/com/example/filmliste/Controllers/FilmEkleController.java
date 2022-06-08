package com.example.filmliste.Controllers;

import com.example.filmliste.Data.MsSql;
import com.example.filmliste.Film;
import com.example.filmliste.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmEkleController {

    @FXML
    private TextField film_adi, yonetmen, tur, yil, puan, uzunluk;
    @FXML
    private RadioButton izlediklerim, izleyeceklerim;
    @FXML
    private Button izlediklerimButton, izleyeceklerimButton, filmSilButton;


    //Ekrandan alınıp düzenlenen degiskenler
    String film_adi_, yonetmen_, tur_;
    int yil_, uzunluk_;
    double puan_;

    @FXML
    public void filmEkle() throws SQLException {
        //Database Connection
        Connection con = MsSql.connect();
        ekrandanVeriAl();
        Film film = new Film(film_adi_, yonetmen_, tur_, yil_, uzunluk_, puan_);

        //İzlediğim Filmler tablosuna girilen veriler eklenir.
        if (izlediklerim.isSelected()) {
            String query = "Insert Into izledigim_filmler VALUES(?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, film.getFilmAdi());
            pst.setString(2, film.getYonetmen());
            pst.setString(3, film.getTur());
            pst.setInt(4, film.getYil());
            pst.setInt(5, film.getUzunluk());
            pst.setDouble(6, film.getPuan());
            int count = pst.executeUpdate();
            if (count > 0) {
                basariliİslemMessage();
            }


            pst.close();
            con.close();
        }
        //İzlediklerim Filmler tablosuna girilen veriler eklenir.
        if (izleyeceklerim.isSelected()) {
            String query = "Insert Into izleyecegim_filmler VALUES(?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, film.getFilmAdi());
            pst.setString(2, film.getYonetmen());
            pst.setString(3, film.getTur());
            pst.setInt(4, film.getYil());
            pst.setInt(5, film.getUzunluk());
            pst.setDouble(6, film.getPuan());
            int count = pst.executeUpdate();
            if (count > 0) {
                basariliİslemMessage();
            }

            pst.close();
            con.close();
        }
    }

    public void basariliİslemMessage() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Başarılı İşlem!");
        a.setHeaderText("Film Başarıyla veritabanına eklendi");
        //a.setContentText("information message");
        a.showAndWait();

        //TilePane tilePane = new TilePane();
    }



    /*Diğer Sayfalara Geçiş Methodları*/
    //Film Sil Sayfasını Açar
    @FXML
    public void filmSilSayfaCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("film-sil.fxml"));

        Stage window = (Stage) filmSilButton.getScene().getWindow();
        Scene scene = new Scene(root, 660,630);

        window.setScene(scene);
    }
    //İzlediklerim Butonuna tıklandığında izlediklerim sayfasını açar
    @FXML
    public void izlediklerimListeCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("izlediklerim-liste.fxml"));

        Stage window = (Stage) izlediklerimButton.getScene().getWindow();
        Scene scene = new Scene(root, 660, 630);

        window.setScene(scene);
    }

    //İzleyeceklerim Butonuna tıklandığında izleyeceklerim sayfasını açar
    @FXML
    public void izleyeceklerimListeCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("izleyeceklerim-liste.fxml"));

        Stage window = (Stage) izleyeceklerimButton.getScene().getWindow();
        Scene scene = new Scene(root, 660, 630);

        window.setScene(scene);
    }


    public void ekrandanVeriAl() {
        film_adi_ = film_adi.getText();
        yonetmen_ = yonetmen.getText();
        tur_ = tur.getText();
        yil_ = Integer.parseInt(yil.getText());
        uzunluk_ = Integer.parseInt(uzunluk.getText());
        puan_ = Double.parseDouble(puan.getText());

    }


}