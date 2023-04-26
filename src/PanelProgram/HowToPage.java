package PanelProgram;

import CreateComponents.HomeButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPage implements ActionListener {
    JFrame howToFrame = new JFrame();
    JPanel topPanel = new JPanel();
    JPanel howToPanel = new JPanel();

    JLabel topLabel = new JLabel("How to Use GoGo Let's Color !!");

    JLabel howTo1Label = new JLabel("1. How to");
    JLabel howTo2Label = new JLabel("2. How to");
    JLabel howTo3Label = new JLabel("3. How to");


    JLabel pic1Label = new JLabel(new ImageIcon("image/howto1.jpg"));
    JLabel pic2Label = new JLabel(new ImageIcon("image/howto2.jpg"));
    JLabel pic3Label = new JLabel(new ImageIcon("image/howto3.jpg"));


    JLabel detail1Label = new JLabel("Detail Something ...");
    JLabel detail2Label = new JLabel("Detail Something ...");
    JLabel detail3Label = new JLabel("Detail Something ...");



    HomeButton backButton = new HomeButton("Back");

    public HowToPage(){
        howToFrame.setLayout(new BorderLayout());
        howToFrame.add(topPanel, BorderLayout.NORTH);
        howToFrame.add(howToPanel, BorderLayout.CENTER);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(backButton, BorderLayout.EAST);
        topLabel.setFont(new Font("Verdana",Font.BOLD,36));

        howToPanel.setLayout(new GridLayout(3,3));
        howToPanel.add(howTo1Label);
        howToPanel.add(howTo2Label);
        howToPanel.add(howTo3Label);

        howToPanel.add(pic1Label);
        howToPanel.add(pic2Label);
        howToPanel.add(pic3Label);

        howToPanel.add(detail1Label);
        howToPanel.add(detail2Label);
        howToPanel.add(detail3Label);



        howTo1Label.setFont(new Font("Verdana",Font.BOLD,18));
        howTo2Label.setFont(new Font("Verdana",Font.BOLD,18));
        howTo3Label.setFont(new Font("Verdana",Font.BOLD,18));

        detail1Label.setFont(new Font("Verdana",Font.PLAIN,16));
        detail2Label.setFont(new Font("Verdana",Font.PLAIN,16));
        detail3Label.setFont(new Font("Verdana",Font.PLAIN,16));

        howToFrame.setSize(1280,720);
        howToFrame.setLocationRelativeTo(null);
        howToFrame.setVisible(true);
        howToFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            howToFrame.dispose();
            HomePage homePage = new HomePage();
        }
    }
}
