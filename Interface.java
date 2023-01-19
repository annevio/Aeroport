/* structure de base d'une interface en java

public class Interface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 600, 400,true);
        primaryStage.setScene(theScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}*/

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Interface extends Application {

    Translate tz = new Translate();
    private double mousePosX;
    private double mousePosY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        World w = new World("./data/airport-codes_no_comma.csv"); // on créé l'objet w de type World qui réfère à notre liste d'aéroports

        primaryStage.setTitle("La terre est plate"); // nom de

        Earth earth = new Earth();
        Scene ihm = new Scene(earth, 800, 600,true); // création de la Scene (=fenetre) de type Scene

        // Objet de type caméra pour avoir la 3D

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1); // distances auxquelles l'objet n'est plus affiché
        camera.setFarClip(3000.0); // distances auxquelles l'objet n'est plus affiché
        camera.setFieldOfView(35);
        ihm.setCamera(camera);

        primaryStage.setScene(ihm);
        primaryStage.show(); // on affiche
    }

    public static void main(String[] args) {
        launch(args);
    }
}
