package Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EveColor extends CreateColor implements ActionListener {
    Color[] colors = {
            new Color(169,169,169),
            new Color(176,196,222),
            new Color(210,180,140),
            new Color(255,182,193),
            new Color(154,205,50),
            new Color(244,164,96),
            new Color(188,143,143),
            new Color(186,85,211),
            new Color(95,158,160),
            new Color(128,128,0),
            new Color(205,92,92),
            new Color(0,128,128),
    };
    JButton[] buttons = new JButton[12];
    public EveColor(){
        setSize(400,400);
        for(int i = 0; i < 12; i++){
            buttons[i] = super.createColor(colors[i]);
        }

        for(int i = 0; i < 12; i++){
            super.colorPanel.add(buttons[i]);
            buttons[i].addActionListener(this::actionPerformed);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 12; i++){
            if(e.getSource() == buttons[i]){
                super.color = colors[i];
                System.out.println(super.color);
            }
        }
    }
}