module com.example.coolingwarminglaw {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.coolingwarminglaw to javafx.fxml;
    exports com.example.coolingwarminglaw;
}