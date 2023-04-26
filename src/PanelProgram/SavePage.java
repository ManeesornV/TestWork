package PanelProgram;

import CreateComponents.HomeButton;
import CreateComponents.HomeTextField;
import Palette.CreateColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePage implements ActionListener {
    JFrame saveFrame = new JFrame();
    JPanel topPanel = new JPanel();
    JPanel picPanel = new JPanel();
    JPanel buttomPanel = new JPanel();
    JPanel descriptionPanel = new JPanel();
    JPanel paperPanel = new JPanel();

    JLabel descriptionLabel = new JLabel("Name Picture : ");
    HomeTextField namePictureTextField = new HomeTextField();

    HomeButton backButton = new HomeButton("Back");
    HomeButton saveButton = new HomeButton("Save");

    HomeButton homeButton = new HomeButton("Home");
    HomeButton goToCreateButton = new HomeButton("Create Canvas");

    String username;
    CreateColor colorStyle;
    String picterName;
    String sizeX;
    String sizeY;

    public SavePage(String username, JPanel paperPanel, CreateColor colorStyle
            , String picterName, String sizeX, String sizeY){
        this.colorStyle = colorStyle;
        this.picterName = picterName;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.paperPanel.setBackground(Color.WHITE);
        this.paperPanel.setPreferredSize(new Dimension(Integer.valueOf(sizeX),Integer.valueOf(sizeY)));

        this.username = username;
        this.paperPanel = paperPanel;
        saveFrame.setLayout(new BorderLayout());
        saveFrame.add(topPanel, BorderLayout.NORTH);
        saveFrame.add(picPanel, BorderLayout.CENTER);
        saveFrame.add(buttomPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new FlowLayout(0,30,20));
        topPanel.add(backButton);
        topPanel.add(saveButton);
        topPanel.add(homeButton);
        topPanel.add(goToCreateButton);

        picPanel.setLayout(new FlowLayout(0,30,20));
        picPanel.add(this.paperPanel);
        picPanel.add(descriptionPanel);

        descriptionPanel.setLayout(new GridLayout(2,1,20,20));
        descriptionPanel.add(descriptionLabel);
        descriptionLabel.setFont(new Font("Verdana",Font.BOLD,36));
        descriptionPanel.add(namePictureTextField);
        namePictureTextField.setFont(new Font("Verdana",Font.BOLD,18));

        backButton.addActionListener(this::actionPerformed);
        saveButton.addActionListener(this::actionPerformed);
        homeButton.addActionListener(this::actionPerformed);
        goToCreateButton.addActionListener(this::actionPerformed);

        saveFrame.setSize(1280,720);
        saveFrame.setLocationRelativeTo(null);
        saveFrame.setVisible(true);
        saveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            saveFrame.dispose();
            CanvasPage canvasPage = new CanvasPage(username,(PaperPanel) paperPanel,colorStyle,picterName,sizeX,sizeY);
        }
        else if(e.getSource() == saveButton) {
            saveImage(namePictureTextField.getText(),"png");
        }
        else if(e.getSource() == homeButton) {
            saveFrame.dispose();
            HomePage homePage = new HomePage();
        }
        else if(e.getSource() == goToCreateButton) {
            saveFrame.dispose();
            CustomDetailsPage customDetailsPage = new CustomDetailsPage(username);
        }
    }

    public void saveImage(String name,String type) {
        BufferedImage image = new BufferedImage(paperPanel.getWidth(),paperPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paperPanel.paint(g2);
        try{
            ImageIO.write(image, type, new File(name+"."+type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}