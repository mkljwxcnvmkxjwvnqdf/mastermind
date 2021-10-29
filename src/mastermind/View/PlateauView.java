package mastermind.View;

import mastermind.Controller.Bdd;
import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PlateauView extends JPanel{
    protected PlateauModel model;
    protected PlateauController controller;
    Connection conn = Bdd.getInstance().getConn();

    public PlateauView()
    {
        controller = new PlateauController(model);
        model = new PlateauModel();

        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 720));
    }


}
