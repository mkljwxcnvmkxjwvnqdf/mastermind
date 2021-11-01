package mastermind.View;

import mastermind.Controller.PlateauController;
import mastermind.Model.PlateauModel;

public class ColorView extends PlateauView{

    public ColorView(PlateauModel model,
                       PlateauController controller) {









    private void setAllColors(){
        model.setColor1(model.getCouleursChoisies().get(0));
        model.setColor2(model.getCouleursChoisies().get(1));
        model.setColor3(model.getCouleursChoisies().get(2));
        model.setColor4(model.getCouleursChoisies().get(3));
        model.setColor5(model.getCouleursChoisies().get(4));
        model.setColor6(model.getCouleursChoisies().get(5));
    }
}
