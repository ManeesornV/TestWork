package Palette;

import PanelProgram.PaperPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdamColor extends CreateColor implements ActionListener {
    public static Color[] colorsAdam = {
            new Color(255,0,255),
            new Color(155,100,200),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
            new Color(255,0,255),
    };
    JButton[] buttons = new JButton[12];
    public AdamColor(){
        for(int i = 0; i < 12; i++){
            buttons[i] = super.createColor(colorsAdam[i]);
        }

        for(int i = 0; i < 12; i++){
            super.colorPanel.add(buttons[i]);
            buttons[i].addActionListener(this::actionPerformed);
        }
    }

    public static void main(String[] args) {
        AdamColor adamColor = new AdamColor();
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        jPanel.add(adamColor.getColorPanel());
        jFrame.setSize(1280,720);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 12; i++){
            if(e.getSource() == buttons[i]){
                super.color = colorsAdam[i];
                System.out.println(super.color);
            }
        }
    }

}
