module junit.maven.jenkins.starter {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    exports starter;

    opens starter;
    opens starter.shelter;

    exports starter.Animals;
    exports starter.shelter;


}