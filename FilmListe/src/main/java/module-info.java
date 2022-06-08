module com.example.filmliste {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.filmliste to javafx.fxml;
    exports com.example.filmliste;
    exports com.example.filmliste.Controllers;
    opens com.example.filmliste.Controllers to javafx.fxml;
}