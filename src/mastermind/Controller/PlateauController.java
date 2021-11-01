package mastermind.Controller;

import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

import java.awt.*;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlateauController implements CombinaisonController {
    private PlateauModel model;
    private PlateauView view = null;
    private String pion1;
    private String pion2;
    private String pion3;
    private String pion4;
    private final Color BIEN_PLACE = Color.black;
    private final Color MAL_PLACE = Color.white;
    private int lastInsertId;
    Connection conn = Bdd.getInstance().getConn();


    public PlateauController(PlateauModel m) {
        model = m;
    }

    @Override
    public void genererCmb(ArrayList<Color> c, Integer n, Integer m) {
        int difference = c.size() - m;
        model.setCouleursChoisies(c);
        for (int i = 0; i < difference; i++) {
            int iterationRandom = (int) ((Math.random() * c.size()));
            model.getCouleursChoisies().remove(c.get(iterationRandom));
        }
        for (int i = 0; i < n; i++) {
            int iterationRandom2 = (int) ((Math.random() * c.size()));
            model.getCombinaisonSecrete().add(c.get(iterationRandom2));
        }
        //System.out.println("Combinaison secrète   : " + model.getCombinaisonSecrete());
        // System.out.println("Couleurs choisies : " + model.getColors());
        model.setCombinaisonSecrete(model.getCombinaisonSecrete());
        model.setCopieCombinaisonSecrete((ArrayList<Color>) model.getCombinaisonSecrete().clone());
        model.setC1("#" + Integer.toHexString(model.getCombinaisonSecrete().get(0).getRGB()).substring(2));
        model.setC2("#" + Integer.toHexString(model.getCombinaisonSecrete().get(1).getRGB()).substring(2));
        model.setC3("#" + Integer.toHexString(model.getCombinaisonSecrete().get(2).getRGB()).substring(2));
        model.setC4("#" + Integer.toHexString(model.getCombinaisonSecrete().get(3).getRGB()).substring(2));

        //System.out.println(model.getC1());
        //System.out.println(model.getC2());
        //System.out.println(model.getC3());
        //System.out.println(model.getC4());

      /*  try {
            this.newPartie(model.getC1(), model.getC2(), model.getC3(), model.getC4());
        } catch (SQLException e) {
            e.printStackTrace();
        } */
    }

    @Override
    public ArrayList<Color> saisirCmb(ArrayList<Color> c, Integer n, Integer m) {
        if (!(model.getCombinaisonJoueur().isEmpty())) {
            model.viderCombinaisonJoueur(model.getCombinaisonJoueur());
            model.getReponse().clear();
        }
        for (int i = 0; i < n; i++) {
            int iterationRandom = (int) ((Math.random() * c.size()));
            model.getCombinaisonJoueur().add(c.get(iterationRandom));
        }
        // System.out.println("Combinaison du joueur : " + model.getCombinaisonJoueur());
        model.setCombinaisonJoueur(model.getCombinaisonJoueur());
        setPion1("#" + Integer.toHexString(model.getCombinaisonJoueur().get(0).getRGB()).substring(2));
        setPion2("#" + Integer.toHexString(model.getCombinaisonJoueur().get(1).getRGB()).substring(2));
        setPion3("#" + Integer.toHexString(model.getCombinaisonJoueur().get(2).getRGB()).substring(2));
        setPion4("#" + Integer.toHexString(model.getCombinaisonJoueur().get(3).getRGB()).substring(2));
        //System.out.println(getPion1());
        //System.out.println(getPion2());
        //System.out.println(getPion3());
        //System.out.println(getPion4());
        //this.newTour(getPion1(), getPion2(), getPion3(),getPion4());
        model.setCopieCombinaisonSecrete((ArrayList<Color>) model.getCombinaisonSecrete().clone());
        model.setReponse((ArrayList<Color>) model.getReponse().clone());
        //position(3, model.getCombinaisonJoueur());
        afficherCmb(model.getCombinaisonSecrete(),n);
        return model.getCombinaisonJoueur();
    }

    @Override
    public ArrayList<Color> afficherCmb(ArrayList<Color> combinaison, Integer n) {
        System.out.println("La combinaison " + combinaison + " est une combinaison de " + n + " symboles, la réponse est :" + model.getReponse());
        System.out.println("Les couleurs choisies sont : " + model.getCouleursChoisies() + "Pion bien placé = " +  trouverBienPlaces());
        System.out.println("Les couleurs choisies sont : " + model.getCouleursChoisies() + "Pion bien placé = " +  trouverMalPlaces());
        return combinaison;
    }

    public void test_code() {


        this.genererCmb(model.getColors(), 4, 6);
        // this.afficherCmb(model.getCombinaisonSecrete(), 4);

        this.saisirCmb(model.getColors(), 4, 6);
        this.saisirCmb(model.getColors(), 4, 6);
        this.saisirCmb(model.getColors(), 4, 6);


        // this.afficherCmb(model.getCombinaisonJoueur(), 4);
    }

    public int trouverBienPlaces() {
        int nbp = 0;
        for (int i = 0; i < model.getCopieCombinaisonSecrete().size(); i++) {
            if (model.getCombinaisonSecrete().get(i) == model.getCombinaisonJoueur().get(i)) {
                nbp++;
                model.getCopieCombinaisonSecrete().set(i, BIEN_PLACE);
                model.getCombinaisonJoueur().set(i, MAL_PLACE);
                model.getReponse().add(BIEN_PLACE);
            }
        }
        System.out.println("Copie Bien Place = " + model.getCopieCombinaisonSecrete());
        System.out.println("Réponse         = " + model.getReponse());
        return nbp;
    }

    public int trouverMalPlaces() {
        int nmp = 0;

        for (int i = 0; i < model.getCombinaisonSecrete().size(); i++) {
            for (int j = 0; j < model.getCombinaisonJoueur().size(); j++) {
                if (model.getCopieCombinaisonSecrete().get(i) == model.getCombinaisonJoueur().get(j) && model.getCombinaisonJoueur().get(j) != MAL_PLACE) {
                    nmp++;
                    model.getCopieCombinaisonSecrete().set(i, MAL_PLACE);
                    model.getCombinaisonJoueur().set(j, MAL_PLACE);
                    j = model.getCombinaisonJoueur().size();
                    model.getReponse().add(MAL_PLACE);

                }
            }
        }
        System.out.println("Copie Mal Place = " + model.getCopieCombinaisonSecrete());
        System.out.println("Réponse         = " + model.getReponse());
        return nmp;
    }

    public Color position(int valeurPosition, ArrayList<Color> combinaison) {
        Color positionSouhaitee = null;
        Object[] color = combinaison.toArray();
        if (valeurPosition > 0 && valeurPosition < color.length) { // vérifier la validité de l'indice
            positionSouhaitee = (Color) color[valeurPosition];
        } else {
            System.out.println("Erreur la position souhaitée n'existe pas !!"); // mettre un popup qui dit ça existe pas à la place
        }
        System.out.println(positionSouhaitee);
        return positionSouhaitee;
    }

    public void newPartie(String c1, String c2, String c3, String c4) throws SQLException {
        String prenom = view.getT1();
        Statement statement = conn.createStatement();
        PreparedStatement insertion = conn.prepareStatement(
                "INSERT INTO partie(idPartie,pseudo,c1,c2,c3,c4)" + "VALUES (NULL,'" + prenom + "','" + c1 + "','" + c2 + "','" + c3 + "','" + c4 + "')", Statement.RETURN_GENERATED_KEYS);
        insertion.executeUpdate();
        ResultSet RSid = insertion.getGeneratedKeys();
        RSid.next();
        int IdIntervention = RSid.getInt(1);
        setLastInsertId(IdIntervention);

    }

    public void newTour(String pion1, String pion2, String pion3, String pion4) {
        String requete = "INSERT INTO tour VALUES (NULL,'" + pion1 + "','" + pion2 + "','" + pion3 + "','" + pion4 + "'," + getLastInsertId() + ")";
        System.out.println(requete);
        try {

            Statement statement = conn.createStatement();
            int nbMaj = statement.executeUpdate(requete);
            System.out.println("nb Ajout = " + nbMaj);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur");
        }

    }

    public String getPion1() {
        return pion1;
    }

    public void setPion1(String pion1) {
        this.pion1 = pion1;
    }

    public String getPion2() {
        return pion2;
    }

    public void setPion2(String pion2) {
        this.pion2 = pion2;
    }

    public String getPion3() {
        return pion3;
    }

    public void setPion3(String pion3) {
        this.pion3 = pion3;
    }

    public String getPion4() {
        return pion4;
    }

    public void setPion4(String pion4) {
        this.pion4 = pion4;
    }

    public int getLastInsertId() {
        return lastInsertId;
    }

    public void setLastInsertId(int lastInsertId) {
        this.lastInsertId = lastInsertId;
    }

    public void addView(PlateauView view) {
        this.view = view;
    }
}
