// on importe la librairie javafx precedemment telechargee et ajoutee au projet

import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

// la class earth hérite de la classe group qui appartient à javafx

public class Earth extends Group {
    private ArrayList<Sphere> blueSphere;
    private Rotate ry = new Rotate(); // faire tourner la terre
    private Sphere sph; //creation de l'objet sph de nature Sphere

    public Sphere getEarth() {
        return sph; // on affiche la terre
    }

    public Earth() {
        blueSphere = new ArrayList<Sphere>(); // on créé notre sphere bleue
        sph = new Sphere(300); // diametre de la terre egal a 300 pixels

        // on définit la lumière appliquée au matériau (=image de la terre)
        PhongMaterial skin = new PhongMaterial();
        skin.setDiffuseMap(new Image("file:./data/earth_lights_4800.png"));
        skin.setSelfIlluminationMap(new Image("file:./data/earth_lights_4800.png"));
        sph.setMaterial(skin);

        this.getChildren().add(sph); // on rajoute la terre à l'ensemble du group
        this.getTransforms().add(ry);


            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    ry.setAxis(new Point3D(0,1,0));
                    ry.setAngle(l/50000000);
                }
            };
            animationTimer.start();
        }

    public Sphere createSphere(Aeroport a){

        double latitude=Math.toRadians(a.getLatitude()); // on passe des degrés aux radians
        double longitude=Math.toRadians(a.getLongitude());

        Sphere aeroportSphere = new Sphere(2); // instanciation de l'objet coloredSphere de type Sphere

        // o
        Translate tz = new Translate();
        double x = 300*Math.cos(latitude)*Math.sin(longitude);
        double y = -300*Math.sin(latitude)-300*Math.cos(latitude);
        double z = -300*Math.cos(latitude)*Math.cos(longitude);
        tz.setX(x);
        tz.setY(y);
        tz.setZ(z);
        aeroportSphere.getTransforms().add(tz);
        // rotation sur x et y
        Rotate rotatex = new Rotate (50,0,0,-300,Rotate.X_AXIS);
        Rotate rotatey = new Rotate (50,0,0,-300,Rotate.Y_AXIS);

        aeroportSphere.getTransforms().add(tz);
        aeroportSphere.getTransforms().add(rotatex);
        aeroportSphere.getTransforms().add(rotatey);

        return aeroportSphere;
    }
}