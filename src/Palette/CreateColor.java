package Palette;

import javax.swing.*;
import java.awt.*;

public class CreateColor extends JPanel {
    public static Color color;
    protected JPanel colorPanel = new JPanel();
    public static JButton[] buttons = new JButton[12];

    public CreateColor() {
        colorPanel.setLayout(new GridLayout(4,3));
    }

    public static Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public JButton createColor(Color color){
        JButton button = new JButton();
        button.setSize(200, 200);
        button.setBackground(color);
        return button;
    }

    public JPanel getColorPanel(){
        return this.colorPanel;
    }
}