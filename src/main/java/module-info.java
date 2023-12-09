module gerenciador.escolar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens com.gerenciador.gerenciadorescolar to javafx.fxml;
    opens com.gerenciador.gerenciadorescolar.controller to javafx.fxml;
    opens com.gerenciador.gerenciadorescolar.model to javafx.base;

    exports com.gerenciador.gerenciadorescolar;
    exports com.gerenciador.gerenciadorescolar.controller;
}
