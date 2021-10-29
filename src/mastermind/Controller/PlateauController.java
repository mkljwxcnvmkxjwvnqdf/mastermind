package mastermind.Controller;

import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlateauController implements CombinaisonController {
    private PlateauModel model;


    public PlateauController(PlateauModel m) {
        model = m;
    }

    @Override
    public ArrayList<Color> genererCmb(ArrayList<Color> c, Integer n, Integer m) {
        int difference = c.size() - m;
        ArrayList<Color> combiQuatreCouleur = new ArrayList<Color>();
        for (int i = 0; i < difference; i++) {
            int rando = (int) ((Math.random() * c.size()));
            c.remove(rando);
            c.get(i);
        }
        Random rand = new Random();

        return combiQuatreCouleur;
    }

    @Override
    public ArrayList<Color> saisirCmb(ArrayList<Color> c, Integer n, Integer m) {
        return null;
    }

    @Override
    public String afficherCmb(Integer n) {
        return null;
    }

    @Override
    public void copierCmb(String src, String dest, Integer n) {

    }
}
