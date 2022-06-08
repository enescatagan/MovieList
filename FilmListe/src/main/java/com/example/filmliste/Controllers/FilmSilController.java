package com.example.filmliste.Controllers;

import com.example.filmliste.Data.MsSql;
import com.example.filmliste.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FilmSilController implements Initializable {

    @FXML
    private Button filmEkleButton, izlediklerimButton, izleyeceklerimButton;
    @FXML
    private TextField filmSilText;
    @FXML
    private MenuButton listelerMenu;
    @FXML
    private Label message;

    private String fm, tabloAdi, temp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < listelerMenu.getItems().size(); i++) {
            listelerMenu.getItems().get(i).setOnAction(event -> {
                listelerMenu.setText(((MenuItem)event.getSource()).getText());
            });
        }
    }


    //Film verisini sil
    public void filmSil(){
        Connection con = MsSql.connect();

        fm = filmSilText.getText();
        temp = listelerMenu.getText();
        if (temp.equals("İzlediklerim")) tabloAdi = "izledigim_filmler";
        if (temp.equals("İzleyeceklerim")) tabloAdi = "izleyecegim_filmler";


        String query = "DELETE FROM "+tabloAdi+" WHERE filmAdi=?";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,fm);
            st.executeUpdate();

            st.close();
            con.close();
            message.setText("Silme İşlemi Başarılı");
        } catch (SQLException e) {
            message.setText("Silme İşlemi Başarısız");
            throw new RuntimeException(e);
        }


    }


    //Film Ekleme Sayfasını açar
    @FXML
    public void filmEkleSayfaCagir() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("film-ekle.fxml"));

        Stage window = (Stage) filmEkleButton.getScene().getWindow();

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


}
