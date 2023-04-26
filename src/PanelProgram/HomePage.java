package PanelProgram;

import CreateComponents.HomeButton;
import CreateComponents.HomeTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage implements ActionListener {
    JFrame homePageFrame = new JFrame();

    JPanel homePagePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel centerpanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel topicPanel = new JPanel();
    JPanel textFieldPanel = new JPanel();
    JPanel buttomPanel = new JPanel();

    JLabel topLabel = new JLabel("    ");
    JLabel topicLabel = new JLabel("LET'S COLOR");

    HomeTextField nameTextField = new HomeTextField();

    HomeButton startButton = new HomeButton("START !!");
    HomeButton howToButton = new HomeButton("How to");
//    HomeButton backgroundButton = new HomeButton("Background");
//    HomeButton colorButton = new HomeButton("Color");

    String username = "";

    public HomePage(){
        homePagePanel.setLayout(new BorderLayout());
        topLabel.setFont(new Font("Verdana",Font.ITALIC,16));
        homePagePanel.add(topLabel, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(1,3));
        mainPanel.add(leftPanel);

        centerpanel.setLayout(new GridLayout(4,1));
        topicLabel.setFont(new Font("Verdana",Font.BOLD,48));
        topicLabel.setForeground(new Color(255,51,153));
        topicPanel.add(topicLabel);
        centerpanel.add(topicPanel);

        textFieldPanel.setLayout(null);
        nameTextField.setBounds(0,0, 350,60);
        nameTextField.setFont(new Font("Verdana",Font.BOLD,18));
        textFieldPanel.add(nameTextField);
        centerpanel.add(textFieldPanel);

        buttonPanel.setLayout(new GridLayout(4,1,0,5));
        buttonPanel.add(startButton);
        buttonPanel.add(howToButton);
//        buttonPanel.add(backgroundButton);
//        buttonPanel.add(colorButton);
        centerpanel.add(buttonPanel);
        centerpanel.add(buttomPanel);

        startButton.addActionListener(this::actionPerformed);
        howToButton.addActionListener(this::actionPerformed);

        mainPanel.add(centerpanel);
        mainPanel.add(rightPanel);

        homePagePanel.add(mainPanel, BorderLayout.CENTER);
        homePageFrame.setLayout(new FlowLayout());
        homePageFrame.add(homePagePanel);
        homePageFrame.setSize(1280,720);
        homePageFrame.setLocationRelativeTo(null);
        homePageFrame.setVisible(true);
        homePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            username = nameTextField.getText();
            homePageFrame.dispose();
            CustomDetailsPage customDetailsPage = new CustomDetailsPage(username);
        }
        else if(e.getSource() == howToButton) {
            homePageFrame.dispose();
            HowToPage howToPage = new HowToPage();
        }
    }
}