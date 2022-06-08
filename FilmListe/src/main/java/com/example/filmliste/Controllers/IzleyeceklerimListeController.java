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

public class IzleyeceklerimListeController implements Initializable {

    @FXML
    private Button filmEkleButton, izlediklerimButton, filmSilButton;

    @FXML
    TableView<Film> izleyeceklerimTable;
    @FXML
    TableColumn<Film, String> izleyeceklerimFilmAdi, izleyeceklerimYonetmen, izleyeceklerimTur;
    @FXML
    TableColumn<Film, Integer> izleyeceklerimId, izleyeceklerimYil, izleyeceklerimUzunluk;
    @FXML
    TableColumn<Film, Double> izleyeceklerimPuan;

    ObservableList<Film> obList = FXCollections.observableArrayList();

    //Connection Object
    Connection con = MsSql.connect();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //İzlediğim Filmler verisi listesini döndürür
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT * FROM izleyecegim_filmler"
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

            izleyeceklerimTable.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        izleyeceklerimId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        izleyeceklerimFilmAdi.setCellValueFactory(
                new PropertyValueFactory<>("filmAdi")
        );
        izleyeceklerimYonetmen.setCellValueFactory(
                new PropertyValueFactory<>("yonetmen")
        );
        izleyeceklerimTur.setCellValueFactory(
                new PropertyValueFactory<>("tur")
        );
        izleyeceklerimYil.setCellValueFactory(
                new PropertyValueFactory<>("yil")
        );
        izleyeceklerimUzunluk.setCellValueFactory(
                new PropertyValueFactory<>("uzunluk")
        );
        izleyeceklerimPuan.setCellValueFactory(
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
    //İzlediklerim Butonuna tıklandığında izlediklerim sayfasını açar
    @FXML
    public void izlediklerimListeCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("izlediklerim-liste.fxml"));

        Stage window = (Stage) izlediklerimButton.getScene().getWindow();
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

}
