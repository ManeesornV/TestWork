package Palette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvaColor extends CreateColor implements ActionListener {
    static Color[] colors = {
            new Color(255,69,0),
            new Color(255,140,0),
            new Color(255,215,0),
            new Color(46,139,87),
            new Color(60,179,113),
            new Color(0,255,127),
            new Color(65,105,225),
            new Color(30,144,255),
            new Color(0,191,255),
            new Color(0,0,0),
            new Color(128,128,128),
            new Color(255,255,255),
    };

    public AvaColor(){
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