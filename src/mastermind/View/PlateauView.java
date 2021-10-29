package mastermind.View;

import mastermind.Controller.Bdd;
import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PlateauView extends JPanel{
    protected PlateauModel model;
    protected PlateauController controller;
    private JFrame frame;
    private JPanel p1,p2,p3;
    private JTextField t1;
    private JTabbedPane onglets;
    private JButton b1;
    Connection conn = Bdd.getInstance().getConn();

    public PlateauView()
    {
        frame = new JFrame("Mastermind");
        frame.setSize(400,400);

        onglets = new JTabbedPane();
        onglets.setBounds(0,0,1280,720);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        t1 = new JTextField(10);
        b1 = new JButton("Valider");

        //Ce qu'il y a dans l'onglet Joueur
        onglets.add("Joueur", p1);
        p1.add(t1);
        p1.add(b1);

        //Ce qu'il y a dans l'onglet Couleur
        onglets.add("Couleur", p2);

        //Ce qu'il y a dans l'onglet Plateau
        onglets.add("Plateau", p3);

        frame.add(onglets);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

}
