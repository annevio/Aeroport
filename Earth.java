// on importe la librairie javafx precedemment telechargee et ajoutee au projet

import javafx.scene.Group;
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
        blueSphere = new ArrayList<Sphere>();
        sph = new Sphere(300); // diametre de la terre egal a 300 pixels
        this.getChildren().add(sph); // on rajoute la terre à l'ensemble du group
        this.getTransforms().add(ry);
    }

    public Sphere createSphere(Aeroport a){

        double latitude=Math.toRadians(a.getLatitude());
        double longitude=Math.toRadians(a.getLongitude());

        Sphere coloredSphere = new Sphere(2); // instanciation de l'objet coloredSphere de type Sphere

        //   Translate tz= new Translate(300.*Math.cos(latitude)*Math.sin(longitude),-300*Math.sin(latitude),-300*Math.cos(latitude)*Math.cos(longitude));
        Translate tz = new Translate(0,0,-300);
        coloredSphere.getTransforms().add(tz);
        Rotate rTheta = new Rotate (50,0,0,300,Rotate.X_AXIS);
        Rotate rPhi = new Rotate (50,0,0,300,Rotate.Y_AXIS);
        coloredSphere.getTransforms().add(rTheta);
        coloredSphere.getTransforms().add(rPhi);

        return coloredSphere;
    }
}