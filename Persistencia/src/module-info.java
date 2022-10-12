module Preparcial {
	requires javafx.controls;
	requires java.logging;
	requires java.base;
	requires javafx.fxml;
	requires javafx.graphics;
    requires java.desktop;

    opens controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
