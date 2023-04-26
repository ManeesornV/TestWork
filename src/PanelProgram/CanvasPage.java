package PanelProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import CreateComponents.HomeButton;
import Palette.CreateColor;

public class CanvasPage implements ActionListener{
    JFrame canvasFrame = new JFrame();
    JPanel canvasPanel = new JPanel();
    static PaperPanel paperPanel = new PaperPanel();
    JPanel toolsPanel = new JPanel();
    JPanel colorPanel = new JPanel();
    JPanel buttomPanel = new JPanel();
    JPanel topPanel = new JPanel();

    JLabel topLabel = new JLabel();
    JLabel timerLabel = new JLabel("00 : 00      ");
    JLabel toolsLabel = new JLabel("TOOLS");
    JLabel colorLabel = new JLabel("COLORS");

    HomeButton finishButton = new HomeButton("Finish");
    HomeButton backButton = new HomeButton("Back");
    String username;

    private static int sec = 300;
    private static Timer timer = new Timer();
    private static int del = 1000;
    private static int per = 1000;

    CreateColor colorStyle;
    String picterName;
    String sizeX;
    String sizeY;

    public CanvasPage(String username, PaperPanel paperPanel, CreateColor colorStyle
            , String picterName, String sizeX, String sizeY){
        this.colorStyle = colorStyle;
        this.paperPanel = paperPanel;
        this.username = username;
        this.picterName = picterName;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.paperPanel.init(CreateColor.getColor(), Integer.valueOf(sizeX),Integer.valueOf(sizeY));
        topLabel.setText("      Username : " + username + "                Picture name : " + picterName);
        sec = 300;
        this.timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                int min_floor = (int)Math.floor(sec / 60);
                int min_sec = sec - (min_floor * 60);
                timerLabel.setText(Integer.toString(min_floor) + " : " + Integer.toString(min_sec) + "      ");
                System.out.println(seti());
                countDownTimer();
            }
        }, del, per);

        topLabel.setFont(new Font("Verdana",Font.ITALIC,16));
        timerLabel.setFont(new Font("Verdana",Font.ITALIC,16));
        topPanel.setLayout(new BorderLayout(10,10));
        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);

        canvasFrame.setLayout(new BorderLayout(5,5));
        canvasFrame.add(topPanel, BorderLayout.NORTH);
        canvasFrame.add(canvasPanel, BorderLayout.CENTER);
        canvasFrame.add(buttomPanel, BorderLayout.SOUTH);

        toolsLabel.setFont(new Font("Verdana",Font.BOLD,36));
        canvasPanel.setLayout(new FlowLayout(0,30,20));
        canvasPanel.add(paperPanel);
        paperPanel.setBackground(Color.WHITE);
        paperPanel.setPreferredSize(new Dimension(Integer.valueOf(sizeX),Integer.valueOf(sizeY)));

        canvasPanel.add(toolsPanel);
        toolsPanel.setLayout(new BorderLayout(20,20));
        toolsPanel.add(colorPanel,BorderLayout.CENTER);

        colorPanel.setLayout(new BorderLayout(20,20));
        colorPanel.setSize(800,500);
        colorLabel.setFont(new Font("Verdana",Font.BOLD,36));
        colorPanel.add(colorLabel, BorderLayout.NORTH);
        colorPanel.add(colorStyle.getColorPanel(), BorderLayout.CENTER);

        buttomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        buttomPanel.add(backButton);
        buttomPanel.add(finishButton);

        backButton.addActionListener(this::actionPerformed);
        finishButton.addActionListener(this::actionPerformed);

        canvasFrame.setSize(1280,720);
        canvasFrame.setLocationRelativeTo(null);
        canvasFrame.setVisible(true);
        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final int seti() {
        if (sec == 1)
            timer.cancel();
        return --sec;
    }

    public void countDownTimer(){
        if(sec == 0){
            timer.cancel();
            sec = 0;
            canvasFrame.dispose();
            SavePage savePage = new SavePage(username, this.paperPanel, colorStyle, picterName, sizeX, sizeY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            timer.cancel();
            sec = 0;
            canvasFrame.dispose();
            CustomDetailsPage customDetailsPage = new CustomDetailsPage(username);
        }
        else if(e.getSource() == finishButton) {
            timer.cancel();
            sec = 0;
            canvasFrame.dispose();
            SavePage savePage = new SavePage(username, paperPanel, colorStyle, picterName ,sizeX, sizeY);
        }
    }
}