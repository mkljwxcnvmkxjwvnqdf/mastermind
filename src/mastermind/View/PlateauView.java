package mastermind.View;

import mastermind.Controller.Bdd;
import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PlateauView extends JFrame{
    protected PlateauModel model;
    protected PlateauController controller;
    private GridLayout gl1;
    private JFrame frame;
    private JPanel p1,p1_1,p2,p3;
    private JTextField t1;
    private JTabbedPane onglets;
    private JButton b1;
    //Connection conn = Bdd.getInstance().getConn();

    public PlateauView()
    {
        frame = new JFrame("Mastermind");
        frame.setSize(1280,720);

        gl1 = new GridLayout(2,2);

        onglets = new JTabbedPane();
        onglets.setBounds(0,0,1280,720);
        p1 = new JPanel();
        p1.setSize(1282,720);
        p1.setBackground(Color.red);
        p1_1 = new JPanel();
        p1_1.setSize(400,400);
        p1_1.setBounds(10,10,100,100);
        p1_1.setBackground(Color.blue);
        p2 = new JPanel();
        p3 = new JPanel();
        t1 = new JTextField(10);
        b1 = new JButton("Valider");
        JButton bcolor1 = new JButton();
        JButton bcolor2 = new JButton();
        JButton bcolor3 = new JButton();
        JButton bcolor4 = new JButton();
        JButton bcolor5 = new JButton();
        JButton bcolor6 = new JButton();
        JButton bcolor7 = new JButton();
        JButton bcolor8 = new JButton();

        //Ce qu'il y a dans l'onglet Joueur
        onglets.add("Joueur", p1);
        p1.add(t1);
        p1.add(b1);
        p1.add(onglets.add("sfg", p1_1));

        p1_1.add(bcolor1);
        bcolor1.setEnabled(false);
        bcolor1.setBackground(Color.red);
        p1_1.add(bcolor2);
        bcolor2.setEnabled(false);
        bcolor2.setBackground(Color.yellow);
        p1_1.add(bcolor3);
        bcolor3.setEnabled(false);
        bcolor3.setBackground(Color.blue);
        p1_1.add(bcolor4);
        bcolor4.setEnabled(false);
        bcolor4.setBackground(Color.orange);
        p1_1.add(bcolor5);
        bcolor5.setEnabled(false);
        bcolor5.setBackground(Color.black);
        p1_1.add(bcolor6);
        bcolor6.setEnabled(false);
        bcolor6.setBackground(Color.magenta);
        p1_1.add(bcolor7);
        bcolor7.setEnabled(false);
        bcolor7.setBackground(Color.cyan);
        p1_1.add(bcolor8);
        bcolor8.setEnabled(false);
        bcolor8.setBackground(Color.green);
        
        //Ce qu'il y a dans l'onglet Plateau
        onglets.add("Plateau", p2);

        //Ce qu'il y a dans l'onglet l'Historique
        onglets.add("Historique", p3);

        frame.add(onglets);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
