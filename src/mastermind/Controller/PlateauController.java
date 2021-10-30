package mastermind.Controller;

import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

import java.awt.*;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlateauController implements CombinaisonController {
    private PlateauModel model;
    Connection conn = Bdd.getInstance().getConn();


    public PlateauController(PlateauModel m) {
        model = m;
    }

    @Override
    public ArrayList<Color> genererCmb(ArrayList<Color> c, Integer n, Integer m) {
        String c1;
        String c2;
        String c3;
        String c4;
        int difference = c.size() - m;
        ArrayList<Color> combiQuatreCouleur = new ArrayList<Color>();
        for (int i = 0; i < difference; i++) {
            int iterationRandom = (int) ((Math.random() * c.size()));
            c.remove(iterationRandom);
        }
        for (int i = 0; i < n; i++) {
            int iterationRandom2 = (int) ((Math.random() * c.size()));
            combiQuatreCouleur.add(c.get(iterationRandom2));
        }
        System.out.println(combiQuatreCouleur);
        model.setCombinaison(combiQuatreCouleur);
        c1 = "#" + Integer.toHexString(combiQuatreCouleur.get(0).getRGB()).substring(2);
        c2 = "#" + Integer.toHexString(combiQuatreCouleur.get(1).getRGB()).substring(2);
        c3 = "#" + Integer.toHexString(combiQuatreCouleur.get(2).getRGB()).substring(2);
        c4 = "#" + Integer.toHexString(combiQuatreCouleur.get(3).getRGB()).substring(2);
        /*
        System.out.println("c1 : " +c1);
        System.out.println(c3);
        System.out.println(c4);
        */
        this.Ajout(c1, c2, c3, c4);
        return combiQuatreCouleur;
    }

    @Override
    public ArrayList<Color> saisirCmb(ArrayList<Color> c, Integer n, Integer m) {
        return null;
    }

    @Override
    public ArrayList<Color> afficherCmb(ArrayList<Color> combiQuatreCouleur, Integer n) {
        System.out.println("La combinaison " + model.getCombinaison() + " est une combinaison de " + n + " symboles");
        return model.getCombinaison();
    }

    public void test_cmb(ArrayList<Color> combiQuatreCouleur, Integer n, Integer m) {
       this.genererCmb(model.getColors(),n,m);
       this.afficherCmb(model.getCombinaison(),n);
    }

    @Override
    public void copierCmb(String src, String dest, Integer n) {

    }

    public void Ajout(String c1, String c2, String c3, String c4) {
        String prenom = "Laurent";
        String requete = "INSERT INTO partie VALUES (NULL,'" + prenom + "','" + c1 + "','" + c2 + "','" + c3 + "','" + c4 + "')";
        System.out.println(requete);
        try {

            Statement statement = conn.createStatement();
            int nbMaj = statement.executeUpdate(requete);
            System.out.println("nb Ajout = " + nbMaj);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur");
        }

    }
}
