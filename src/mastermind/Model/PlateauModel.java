package mastermind.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PlateauModel {

    private ArrayList<Color> colors = new ArrayList<Color>();
    private final Integer CMAX = 6;
    private final Integer BIEN_PLACE = -1;
    private final Integer MAL_PLACE = 0;
    private Integer n;
    private Integer m;

    public PlateauModel(Integer MAX_TENTATIVES, Integer n, Integer m) {
        this.n = n;
        this.m = m;
        colors.add(Color.red);
        colors.add(Color.yellow);
        colors.add(Color.blue);
        colors.add(Color.orange);
        colors.add(Color.black);
        colors.add(Color.magenta);
        colors.add(Color.cyan);
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }
}