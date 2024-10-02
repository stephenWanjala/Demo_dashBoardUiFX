module com.example.demo {
    requires javafx.fxml;

    requires java.sql;
    requires org.jfxtras.styles.jmetro;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}