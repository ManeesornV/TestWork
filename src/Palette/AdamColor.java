package Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdamColor extends CreateColor implements ActionListener {
    public static Color[] colorsAdam = {
            new Color(255,153,153),
            new Color(255,204,153),
            new Color(255,255,153),
            new Color(204,255,153),
            new Color(153,255,153),
            new Color(153,255,204),
            new Color(153,204,255),
            new Color(153,153,255),
            new Color(204,153,255),
            new Color(255,153,255),
            new Color(255,153,204),
            new Color(224,224,224),
    };
    JButton[] buttons = new JButton[12];
    public AdamColor(){
        setSize(400,400);
        for(int i = 0; i < 12; i++){
            buttons[i] = super.createColor(colorsAdam[i]);
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
                super.color = colorsAdam[i];
                System.out.println(super.color);
            }
        }
    }

}
