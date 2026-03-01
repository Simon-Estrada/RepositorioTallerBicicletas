module co.edu.uniquindio.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.demo to javafx.fxml;
    opens co.edu.uniquindio.demo.viewController to javafx.fxml;
    opens co.edu.uniquindio.demo.model to javafx.base, javafx.fxml;
    opens co.edu.uniquindio.demo.controller to javafx.fxml;
    exports co.edu.uniquindio.demo;
}