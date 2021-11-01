package mastermind.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

public class ColorView {
    private PlateauModel model;
    private PlateauController controller;
    Color color1, color2, color3, color4, color5, color6;

    public ColorView(PlateauModel model,
                     PlateauController controller) {
        this.setAllColors();
        color1 = model.getColor1();
        color2 = model.getColor2();
        color3 = model.getColor3();
    }

    private PlateauModel model() {
        return model;
    }

    private PlateauController controller() {
        return controller;
    }

    private void setAllColors() {
        model.setColor1(model.getCouleursChoisies().get(0));
        model.setColor2(model.getCouleursChoisies().get(1));
        model.setColor3(model.getCouleursChoisies().get(2));
        model.setColor4(model.getCouleursChoisies().get(3));
        model.setColor5(model.getCouleursChoisies().get(4));
        model.setColor6(model.getCouleursChoisies().get(5));
    }
}
