package mastermind.Controller;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CombinaisonController {

    public void genererCmb(ArrayList<Color> c, Integer n, Integer m);
    public String saisirCmb(ArrayList<Color> c, Integer n, Integer m);
    public String afficherCmb(Integer n);
    public void copierCmb(String src,String dest,Integer n);
}

