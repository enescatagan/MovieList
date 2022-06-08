package com.example.filmliste.Data;

import com.example.filmliste.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class MsSql {


    public static Connection connect() {
        String url = "jdbc:sqlserver://DESKTOP-FG7GELQ:1433;" +
                "databaseName=mbp106_filmListele;" +
                "encrypt=true;" +
                "trustServerCertificate=true;" +
                "integratedSecurity=true";

        Connection con;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }


}