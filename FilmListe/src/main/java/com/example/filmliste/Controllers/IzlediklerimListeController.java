package com.example.filmliste.Controllers;

import com.example.filmliste.Data.MsSql;
import com.example.filmliste.Film;
import com.example.filmliste.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class IzlediklerimListeController implements Initializable{

    @FXML
    private Button filmEkleButton, izleyeceklerimButton, filmSilButton;

    @FXML
    TableView<Film> izlediklerimTable;
    @FXML
    TableColumn<Film, String> izlediklerimFilmAdi, izlediklerimYonetmen, izlediklerimTur;
    @FXML
    TableColumn<Film, Integer> izlediklerimId, izlediklerimYil, izlediklerimUzunluk;
    @FXML
    TableColumn<Film, Double> izlediklerimPuan;

    ObservableList<Film> obList = FXCollections.observableArrayList();

    //Connection Object
    Connection con = MsSql.connect();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //İzlediğim Filmler verisi listesini döndürür
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT * FROM izledigim_filmler"
            );

            while(rs.next()) {
                obList.add(new Film(
                   rs.getInt("id"),
                   rs.getString("filmAdi"),
                   rs.getString("yonetmen"),
                   rs.getString("tur"),
                   rs.getInt("yil"),
                   rs.getInt("uzunluk"),
                   rs.getDouble("puan")
                ));
            }

            izlediklerimTable.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        izlediklerimId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        izlediklerimFilmAdi.setCellValueFactory(
                new PropertyValueFactory<>("filmAdi")
        );
        izlediklerimYonetmen.setCellValueFactory(
                new PropertyValueFactory<>("yonetmen")
        );
        izlediklerimTur.setCellValueFactory(
                new PropertyValueFactory<>("tur")
        );
        izlediklerimYil.setCellValueFactory(
                new PropertyValueFactory<>("yil")
        );
        izlediklerimUzunluk.setCellValueFactory(
                new PropertyValueFactory<>("uzunluk")
        );
        izlediklerimPuan.setCellValueFactory(
                new PropertyValueFactory<>("puan")
        );

    }



    //Fil Sil Sayfasını Açar
    @FXML
    public void filmSilSayfaCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("film-sil.fxml"));

        Stage window = (Stage) filmSilButton.getScene().getWindow();
        Scene scene = new Scene(root, 660,630);

        window.setScene(scene);
    }
    //Film Ekleme Sayfasını açar
    @FXML
    public void filmEkleSayfaCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("film-ekle.fxml"));

        Stage window = (Stage) filmEkleButton.getScene().getWindow();

        Scene scene = new Scene(root, 660,630);

        window.setScene(scene);
    }
    //İzleyeceklerim Butonuna tıklandığında izleyeceklerim sayfasını açar
    @FXML
    public void izleyeceklerimListeCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("izleyeceklerim-liste.fxml"));

        Stage window = (Stage) izleyeceklerimButton.getScene().getWindow();
        Scene scene = new Scene(root, 660,630);

        window.setScene(scene);
    }



}
