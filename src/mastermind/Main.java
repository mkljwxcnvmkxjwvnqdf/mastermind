package mastermind;

import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;
import mastermind.View.PlateauView;

public class Main {
    final static Integer MAX_TENTATIVES = 10;
        public Main() {
            PlateauModel PlateauModel = new PlateauModel(MAX_TENTATIVES, 4, 6);
            PlateauController PlateauController = new PlateauController(PlateauModel);
            PlateauView Mastermind = new PlateauView(PlateauModel, PlateauController);
            PlateauController.addView(Mastermind);
        }
    public static void main ( String args []) {
//Schedule a job for the event-dispatching thread:
//creating and showing this application’s GUI.
        javax . swing . SwingUtilities . invokeLater (new Runnable () {
            public void run () {
                new Main ();
            }
        });
    }

}
