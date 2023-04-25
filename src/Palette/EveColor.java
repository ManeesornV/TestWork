package Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EveColor extends CreateColor implements ActionListener {
    Color[] colors = {
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
            new Color(255,100,100),
    };
    JButton[] buttons = new JButton[12];
    public EveColor(){
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
