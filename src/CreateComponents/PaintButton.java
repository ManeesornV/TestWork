package CreateComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class PaintButton extends JButton {
    public PaintButton(){
        super();
        this.setFont(new Font("Verdana",Font.BOLD,24));
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setUI(new UIButton());
    }

    public PaintButton(String text){
        this();
        this.setText(text);
    }

    public PaintButton(Icon icon){
        this();
        this.setIcon(icon);
    }
}