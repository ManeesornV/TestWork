package Palette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvaColor extends CreateColor implements ActionListener {
    static Color[] colors = {
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
            new Color(200,51,50),
    };

    public AvaColor(){
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