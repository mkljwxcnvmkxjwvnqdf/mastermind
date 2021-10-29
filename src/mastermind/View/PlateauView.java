package mastermind.View;

import mastermind.Controller.Bdd;
import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

import javax.swing.*;
import java.sql.Connection;
import java.util.Arrays;

public class PlateauView extends JFrame{
    private String label;
    protected PlateauModel model;
    protected PlateauController controller;
    Connection conn = Bdd.getInstance().getConn();

    public PlateauView(PlateauModel model, PlateauController controller) {
        this.model = model;
        this.controller = controller;
    }
    protected PlateauModel getModel() {
        return model;
    }

    public static void main(String[] args)
    {
        Bdd.getInstance();
        PlateauModel PlateauModel = new PlateauModel ();
        PlateauController PlateauController = new PlateauController ( PlateauModel );
        PlateauView PlateauView = new PlateauView(PlateauModel, PlateauController);
        int[] c = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(c));
        PlateauController.genererCmb(c, 4,6);

    }

}
