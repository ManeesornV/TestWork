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

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        HomeButton homeButton1 = new HomeButton("TEST");
        JPanel jPanel = new JPanel();
        jPanel.add(homeButton1);
        jFrame.add(jPanel);
        jFrame.setSize(1280,720);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}