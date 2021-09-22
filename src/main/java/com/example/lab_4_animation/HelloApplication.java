package com.example.lab_4_animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Dessins!");
        stage.setHeight(500);
        stage.setWidth(1000);


        Group jour = new Group(ciel(), maison(), texte(), oiseau1(), oiseau2(), soleil(), etoile(), lune());

        Scene scene = new Scene(jour);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Group ciel() {

        Rectangle cielJour = new Rectangle(0, 0, 500, 500);
        cielJour.setFill(Color.LIGHTGRAY);

        Rectangle cielNuit = new Rectangle(500, 0, 500, 500);
        cielNuit.setFill(Color.BLACK);

        return new Group(cielJour, cielNuit);
    }

    public Group maison() {

        Rectangle base = new Rectangle(200, 250, 100, 60);
        base.setFill(Color.BEIGE);

        Polygon toit = new Polygon(250, 200, 305, 250, 195, 250);
        toit.setFill(Color.DARKRED);

        Group maison = new Group(base, toit);
        DropShadow ds = new DropShadow(10,-10,10, Color.GRAY);
        GaussianBlur blur = new GaussianBlur(10);
        maison.setEffect(blur);
        maison.setEffect(ds);

        Rectangle baseNuit = new Rectangle(700, 250, 100, 60);
        baseNuit.setFill(Color.BEIGE);

        Polygon toitNuit = new Polygon(750, 200, 805, 250, 695, 250);
        toitNuit.setFill(Color.DARKRED);

        Rectangle fenetre = new Rectangle(255, 260, 35, 20);
        fenetre.setFill(Color.AQUA);
        fenetre.setStroke(Color.MEDIUMAQUAMARINE);

        Line ligneFenetre1 = new Line(273, 280, 273, 260);
        ligneFenetre1.setStroke(Color.MEDIUMAQUAMARINE);

        Line ligneFenetre2 = new Line(255, 270, 290, 270);
        ligneFenetre2.setStroke(Color.MEDIUMAQUAMARINE);

        Rectangle fenetreNuit = new Rectangle(755, 260, 35, 20);
        fenetreNuit.setFill(Color.AQUA);
        fenetreNuit.setStroke(Color.MEDIUMAQUAMARINE);

        Line ligneFenetre1Nuit = new Line(773, 280, 773, 260);
        ligneFenetre1Nuit.setStroke(Color.MEDIUMAQUAMARINE);

        Line ligneFenetre2Nuit = new Line(755, 270, 790, 270);
        ligneFenetre2Nuit.setStroke(Color.MEDIUMAQUAMARINE);

        Rectangle porte = new Rectangle(215, 275, 25, 35);
        porte.setFill(Color.SADDLEBROWN);

        Rectangle porteNuit = new Rectangle(715, 275, 25, 35);
        porteNuit.setFill(Color.SADDLEBROWN);

        Circle poignee = new Circle(235, 293, 5);
        poignee.setFill(Color.YELLOWGREEN);

        Circle poigneeNuit = new Circle(735, 293, 5);
        poigneeNuit.setFill(Color.YELLOWGREEN);

        return new Group(maison, baseNuit, toitNuit, fenetre, ligneFenetre1, ligneFenetre2, fenetreNuit, ligneFenetre1Nuit, ligneFenetre2Nuit, porte, porteNuit, poignee, poigneeNuit);
    }

    public Group texte() {
        Font f = Font.font("Arial", 80);

        Text jour = new Text(170, 420, "Jour");
        jour.setFont(f);
        jour.setFill(Color.BLACK);

        Text nuit = new Text(670, 420, "Nuit");
        nuit.setFont(f);
        nuit.setFill(Color.WHITE);

        return new Group(jour, nuit);

    }

    public Group oiseau1(){

        QuadCurve aile1 = new QuadCurve(100, 100, 75, 75, 50, 100);
        aile1.setStroke(Color.BLACK);
        aile1.setFill(Color.TRANSPARENT);
        QuadCurve aile2 = new QuadCurve(100, 100, 125, 75, 150, 100);
        aile2.setStroke(Color.BLACK);
        aile2.setFill(Color.TRANSPARENT);

        Timeline timelineOiseau = new Timeline();
        timelineOiseau.setCycleCount(Timeline.INDEFINITE);

        KeyValue debutAile1Oiseau1 = new KeyValue(aile1.startYProperty(), 110);
        KeyFrame finAile1Oiseau = new KeyFrame(Duration.seconds(1), debutAile1Oiseau1);
        KeyValue debutAile2Oiseau1 = new KeyValue(aile2.startYProperty(), 110);
        KeyFrame finAile2Oiseau = new KeyFrame(Duration.seconds(1), debutAile2Oiseau1);

        KeyValue finAile1 = new KeyValue(aile1.endYProperty(), 80);
        KeyFrame centre1Oiseau = new KeyFrame(Duration.seconds(1), finAile1);

        KeyValue finAile2 = new KeyValue(aile2.endYProperty(), 80);
        KeyFrame centre2Oiseau = new KeyFrame(Duration.seconds(1), finAile2);


        timelineOiseau.getKeyFrames().addAll(finAile1Oiseau, finAile2Oiseau, centre1Oiseau, centre2Oiseau);
        timelineOiseau.setAutoReverse(true);
        timelineOiseau.play();
        return new Group(aile1, aile2);
    }

    public Group oiseau2(){

        QuadCurve aile1 = new QuadCurve(200, 120, 175, 95, 150, 120);
        aile1.setStroke(Color.BLACK);
        aile1.setFill(Color.TRANSPARENT);
        QuadCurve aile2 = new QuadCurve(200, 120, 225, 95, 250, 120);
        aile2.setStroke(Color.BLACK);
        aile2.setFill(Color.TRANSPARENT);

        Timeline timelineOiseau = new Timeline();
        timelineOiseau.setCycleCount(Timeline.INDEFINITE);

        KeyValue debutAile1Oiseau = new KeyValue(aile1.startYProperty(), 110);
        KeyFrame finAile1Oiseau = new KeyFrame(Duration.seconds(1), debutAile1Oiseau);
        KeyValue debutAile2Oiseau = new KeyValue(aile2.startYProperty(), 110);
        KeyFrame finAile2Oiseau = new KeyFrame(Duration.seconds(1), debutAile2Oiseau);

        KeyValue finAile1 = new KeyValue(aile1.endYProperty(), 80);
        KeyFrame centre1Oiseau = new KeyFrame(Duration.seconds(1), finAile1);

        KeyValue finAile2 = new KeyValue(aile2.endYProperty(), 80);
        KeyFrame centre2Oiseau = new KeyFrame(Duration.seconds(1), finAile2);


        timelineOiseau.getKeyFrames().addAll(finAile1Oiseau, finAile2Oiseau, centre1Oiseau, centre2Oiseau);
        timelineOiseau.setAutoReverse(true);
        timelineOiseau.play();
        return new Group(aile1, aile2);
    }

    public Group soleil(){

        Circle soleil= new Circle(400, 100, 30);
        soleil.setFill(Color.YELLOW);


        Line grandRayon1 = new Line(400, 60, 400, 0);
        grandRayon1.setStroke(Color.YELLOW);

        Line grandRayon2 = new Line(440, 100, 500, 100);
        grandRayon2.setStroke(Color.YELLOW);

        Line grandRayon3 = new Line(400, 140, 400, 200);
        grandRayon3.setStroke(Color.YELLOW);

        Line grandRayon4 = new Line(360, 100, 300, 100);
        grandRayon4.setStroke(Color.YELLOW);

        Line petitRayon1 = new Line(430, 70, 460, 40);
        petitRayon1.setStroke(Color.YELLOW);

        Line petitRayon2 = new Line(430, 130, 460, 160);
        petitRayon2.setStroke(Color.YELLOW);

        Line petitRayon3 = new Line(370, 130, 340, 160);
        petitRayon3.setStroke(Color.YELLOW);

        Line petitRayon4 = new Line(370, 70, 340, 40);
        petitRayon4.setStroke(Color.YELLOW);

        Group rayons = new Group(grandRayon1, grandRayon2, grandRayon3, grandRayon4, petitRayon1, petitRayon2, petitRayon3, petitRayon4);
        RotateTransition rotation = new RotateTransition(Duration.seconds(5), rayons);
        rotation.setByAngle(360);
        rotation.setCycleCount(Timeline.INDEFINITE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();

        FillTransition couleur = new FillTransition(Duration.seconds(3), soleil);
        couleur.setToValue(Color.ORANGE);
        couleur.setCycleCount(Timeline.INDEFINITE);
        couleur.setAutoReverse(true);
        couleur.play();


        return new Group(soleil, rayons);
    }

    public Group etoile() {

        int radius[] = {20, 8, 20, 8};
        int nPoints = 10;
        int max = 5;
        double[] X = new double[nPoints];
        double[] Y = new double[nPoints];

        Polygon etoile1 = new Polygon();
        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / max)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / max)) * radius[i % 4];

            X[i] = (int) x + 850;
            Y[i] = (int) y + 100;
            etoile1.getPoints().add(X[i]);
            etoile1.getPoints().add(Y[i]);
        }
        etoile1.setFill(Color.YELLOW);
        etoile1.setStroke(Color.YELLOW);
        etoile1.setRotate(-17);
        FadeTransition fade1 = new FadeTransition(Duration.seconds(0.9), etoile1);
        fade1.setFromValue(1.0);
        fade1.setToValue(0);
        fade1.setCycleCount(Timeline.INDEFINITE);
        fade1.setAutoReverse(true);
        fade1.play();

        Polygon etoile2 = new Polygon();
        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / max)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / max)) * radius[i % 4];

            X[i] = (int) x + 770;
            Y[i] = (int) y + 150;
            etoile2.getPoints().add(X[i]);
            etoile2.getPoints().add(Y[i]);
        }
        etoile2.setFill(Color.YELLOW);
        etoile2.setStroke(Color.YELLOW);
        etoile2.setRotate(-17);
        FadeTransition fade2 = new FadeTransition(Duration.seconds(3.4), etoile2);
        fade2.setFromValue(1.0);
        fade2.setToValue(0);
        fade2.setCycleCount(Timeline.INDEFINITE);
        fade2.setAutoReverse(true);
        fade2.play();

        Polygon etoile3 = new Polygon();
        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / max)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / max)) * radius[i % 4];

            X[i] = (int) x + 650;
            Y[i] = (int) y + 170;
            etoile3.getPoints().add(X[i]);
            etoile3.getPoints().add(Y[i]);
        }
        etoile3.setFill(Color.YELLOW);
        etoile3.setStroke(Color.YELLOW);
        etoile3.setRotate(-17);
        FadeTransition fade3 = new FadeTransition(Duration.seconds(2.8), etoile3);
        fade3.setFromValue(1.0);
        fade3.setToValue(0);
        fade3.setCycleCount(Timeline.INDEFINITE);
        fade3.setAutoReverse(true);
        fade3.play();

        Polygon etoile4 = new Polygon();
        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / max)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / max)) * radius[i % 4];

            X[i] = (int) x + 550;
            Y[i] = (int) y + 75;
            etoile4.getPoints().add(X[i]);
            etoile4.getPoints().add(Y[i]);
        }
        etoile4.setFill(Color.YELLOW);
        etoile4.setStroke(Color.YELLOW);
        etoile4.setRotate(-17);
        FadeTransition fade4 = new FadeTransition(Duration.seconds(1.5), etoile4);
        fade4.setFromValue(1.0);
        fade4.setToValue(0);
        fade4.setCycleCount(Timeline.INDEFINITE);
        fade4.setAutoReverse(true);
        fade4.play();



        return new Group(etoile1, etoile2, etoile3, etoile4);
    }

    public Group lune() {

        Circle lune = new Circle(925, 65, 30);
        lune.setFill(Color.WHITE);

        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(1, Color.BLACK),
        };

        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);

        lune.setFill(gradient);


        return new Group(lune);

    }

}

