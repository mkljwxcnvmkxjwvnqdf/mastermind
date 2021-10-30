package mastermind;

import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

public class Main {
    final static Integer MAX_TENTATIVES = 10;
    public static void main(String[] args)
    {
        PlateauModel pm = new PlateauModel(MAX_TENTATIVES, 4,6);
       PlateauController Pc = new PlateauController(pm);
       Pc.test_cmb(pm.getColors(),4,6);
       Pc.test_cmb(pm.getColors(),4,6);


    }

}
