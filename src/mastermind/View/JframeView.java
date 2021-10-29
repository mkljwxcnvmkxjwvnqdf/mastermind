package mastermind.View;

import javax.swing.*;

public class JframeView
{
    public void createWindow()
    {
        JFrame frame = new JFrame("Mastermind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlateauView WPanel01 = new PlateauView();
        frame.getContentPane().add(WPanel01);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
