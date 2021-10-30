package mastermind.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PlateauModel {

    private ArrayList<Color> colors = new ArrayList<Color>();
    private ArrayList<Color> combinaisonSecrete = new ArrayList<Color>();
    private ArrayList<Color> copieCombinaisonSecrete = new ArrayList<Color>();
    private ArrayList<Color> combinaisonJoueur = new ArrayList<Color>();
    private final Integer CMAX = 6;
    private Integer n;
    private Integer m;
    private String c1;
    private String c2;
    private String c3;
    private String c4;


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
        colors.add(Color.green);
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<Color> getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    public ArrayList<Color> getEverySymbolOfCombinaison() {
        Color combi = null;
        int i = 0;
        for (Color combinaison : getCombinaisonSecrete()) {
            i++;
            combi = combinaison;
            System.out.println("Couleur numéro " + i + " de la combinaison : " + combi);
        }
        return combinaisonSecrete;
    }

    public void setCombinaisonSecrete(ArrayList<Color> combinaisonSecrete) {
        this.combinaisonSecrete = combinaisonSecrete;
    }

    public ArrayList<Color> getCopieCombinaisonSecrete() {
        return copieCombinaisonSecrete;
    }

    public void setCopieCombinaisonSecrete(ArrayList<Color> copieCombinaisonSecrete) {
        this.copieCombinaisonSecrete = copieCombinaisonSecrete;
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

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }


    public ArrayList<Color> getCombinaisonJoueur() {
        return combinaisonJoueur;
    }

    public void setCombinaisonJoueur(ArrayList<Color> combinaisonJoueur) {
       this.combinaisonJoueur = combinaisonJoueur;
    }

    public void viderCombinaisonJoueur(ArrayList<Color> combinaisonJoueur) {
        combinaisonJoueur.clear();
    }


}