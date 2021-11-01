package mastermind.View;

import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlateauView extends JFrame implements ActionListener {
    protected PlateauModel model;
    protected PlateauController controller;
    protected GridLayout gl1, gl2;
    protected JFrame frame;
    protected JPanel p1, p1_1, p2, p2_1;
    protected JTextField t1;
    protected JTextArea ta2;
    protected JTabbedPane onglets;
    protected JButton b1;

    //Connection conn = Bdd.getInstance().getConn();

    public PlateauView(PlateauModel model,
                       PlateauController controller) {
        this.model = model;
        this.controller = controller;
        frame = new JFrame("Mastermind");
        frame.setSize(1280, 720);

        gl1 = new GridLayout(1, 2);
        gl2 = new GridLayout(1, 4);

        onglets = new JTabbedPane();
        onglets.setBounds(0, 0, 1280, 720);
        p1 = new JPanel();
        p2 = new JPanel();
        p2.setBackground(Color.GREEN);
        p1_1 = new JPanel();
        p1_1.setLayout(gl1);
        p2_1 = new JPanel();
        p2_1.setBackground(Color.RED);
        p2_1.setLayout(gl2);
        t1 = new JTextField(10);
        ta2 = new JTextArea("Couleur disponible :");
        b1 = new JButton("Valider");

        b1.addActionListener(this);

        JButton bcolor1 = new JButton();
        JButton bcolor2 = new JButton();
        JButton bcolor3 = new JButton();
        JButton bcolor4 = new JButton();
        JButton bcolor5 = new JButton();
        JButton bcolor6 = new JButton();
        JButton bcolor7 = new JButton();
        JButton bcolor8 = new JButton();

        JButton bp1 = new JButton();
        JButton bp2 = new JButton();
        JButton bp3 = new JButton();
        JButton bp4 = new JButton();

        //Ce qu'il y a dans l'onglet Joueur
        onglets.add("Joueur", p1);
        onglets.setEnabled(false);
        p1.add(t1);
        p1.add(b1);
        p1.add(ta2);
        ta2.setEnabled(false);
        ta2.setDisabledTextColor(Color.BLACK);
        p1.add(onglets.add("gl1", p1_1));

        p1_1.add(bcolor1);
        bcolor1.setEnabled(false);
        bcolor1.setBackground(Color.red);
        bcolor1.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor2);
        bcolor2.setEnabled(false);
        bcolor2.setBackground(Color.yellow);
        bcolor2.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor3);
        bcolor3.setEnabled(false);
        bcolor3.setBackground(Color.blue);
        bcolor3.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor4);
        bcolor4.setEnabled(false);
        bcolor4.setBackground(Color.orange);
        bcolor4.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor5);
        bcolor5.setEnabled(false);
        bcolor5.setBackground(Color.black);
        bcolor5.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor6);
        bcolor6.setEnabled(false);
        bcolor6.setBackground(Color.magenta);
        bcolor6.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor7);
        bcolor7.setEnabled(false);
        bcolor7.setBackground(Color.cyan);
        bcolor7.setPreferredSize(new Dimension(40, 20));
        p1_1.add(bcolor8);
        bcolor8.setEnabled(false);
        bcolor8.setBackground(Color.green);
        bcolor8.setPreferredSize(new Dimension(40, 20));

        //Ce qu'il y a dans l'onglet Partie
        onglets.add("Partie", p2);
        p2.add(onglets.add("gl2", p2_1));

        p2_1.add(bp1);
        p2_1.add(bp2);
        p2_1.add(bp3);
        p2_1.add(bp4);


        frame.add(onglets);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.test_code();
        onglets.setSelectedComponent(p2);
    }

    public String getT1() {
        return t1.getText();
    }

    private PlateauModel model() {
        return model;
    }

    private PlateauController controller() {
        return controller;
    }
}
