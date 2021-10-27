package mastermind.Controller;

import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class PlateauController implements CombinaisonController {
    private PlateauModel model;
    private PlateauView view = null;
    private Color[] colors;

    public PlateauController(PlateauModel m) {
        model = m;
    }

    public void addView(PlateauView view) {
        this.view = view;
    }

    @Override
    public void genererCmb(int[] c, Integer n, Integer m) {
        Random random = new Random();
        c = new int[n];
        for (int k = 0; k < n; ++k) {
            c[k] = random.nextInt(m);

        }
        System.out.println(Arrays.toString(c));
    }

    @Override
    public String saisirCmb(int[] c, Integer n, Integer m) {
        return null;
    }

    @Override
    public String afficherCmb(Integer n) {
        return null;
    }

}
