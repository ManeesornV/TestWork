package CreateComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class HomeButton extends JButton {
    public HomeButton(String text){
        super();
        this.setText(text);
        this.setFont(new Font("Verdana",Font.BOLD,24));
        this.setBackground(new Color(255,51,153));
        this.setForeground(new Color(255,255,255));
        this.setUI(new UIButton());
    }
}