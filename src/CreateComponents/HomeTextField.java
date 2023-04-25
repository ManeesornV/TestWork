package CreateComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

public class HomeTextField extends JTextField {
    private Shape shape;
    public HomeTextField(){
        super();
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(255,51,153));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        g.setColor(getBackground());
        g.fillRoundRect(5, 5, getWidth()-10, getHeight()-10, 15, 15);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Color.white);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}