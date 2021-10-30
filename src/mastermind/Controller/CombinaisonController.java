package mastermind.Controller;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CombinaisonController {

    public  void genererCmb(ArrayList<Color> c, Integer n, Integer m);
    public  ArrayList<Color> saisirCmb(ArrayList<Color> c, Integer n, Integer m);
    public ArrayList<Color> afficherCmb(ArrayList<Color> combinaison, Integer n);
    public void copierCmb(String src,String dest,Integer n);
}

