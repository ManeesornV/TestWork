package PanelProgram;
import CreateComponents.HomeButton;
import CreateComponents.HomeTextField;
import Palette.AdamColor;
import Palette.AvaColor;
import Palette.CreateColor;
import Palette.EveColor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomDetailsPage implements ActionListener, ItemListener {
	JFrame customDetailsFrame = new JFrame();

	JPanel customDetailsPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel colorPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel topicPanel = new JPanel();
	JPanel detailsPanel = new  JPanel();
	JPanel namePicPanel = new JPanel();
	JPanel topicSizePanel = new JPanel();
	JPanel sizePanel = new JPanel();
	JPanel themeColorPanel = new JPanel();
	JPanel picNameTextFieldPanel = new JPanel();
	JPanel xTextFieldPanel = new JPanel();
	JPanel yTextFieldPanel = new JPanel();
	JPanel buttomPanel = new JPanel();

	JLabel topLabel = new JLabel();
	JLabel topicLabel = new JLabel("LET'S COLOR");
	JLabel picNameLabel = new JLabel("Enter your picture name");
	JLabel chooseSizeLabel = new JLabel("Choose size");
	JLabel xLabel = new JLabel("    X : ");
	JLabel yLabel = new JLabel("Y : ");
	JLabel colorThemeLabel = new JLabel("Set up your theme of your color");

	JRadioButton AdamRadioButton = new JRadioButton("Adam");
	JRadioButton AvaRadioButton = new JRadioButton("Ava");
	JRadioButton EveRadioButton = new JRadioButton("Eve");

	HomeTextField picterNameTextField = new HomeTextField();
	HomeTextField sizexTextField = new HomeTextField();
	HomeTextField sizeyTextField = new HomeTextField();

	HomeButton backButton = new HomeButton("Back");
	HomeButton nextButton = new HomeButton("Next");

	String username;
	CreateColor colorStyle;

	public CustomDetailsPage(String username){
		this.username = username;
		topLabel.setText("Username : " + username);
		customDetailsPanel.setLayout(new BorderLayout());
		topLabel.setFont(new Font("Verdana",Font.ITALIC,16));
		customDetailsPanel.add(topLabel, BorderLayout.NORTH);
		customDetailsPanel.add(detailsPanel, BorderLayout.CENTER);
		customDetailsPanel.add(buttomPanel, BorderLayout.SOUTH);

		detailsPanel.setLayout(new GridLayout(1,3));
		detailsPanel.add(rightPanel);
		detailsPanel.add(centerPanel);
		detailsPanel.add(leftPanel);

		topicLabel.setFont(new Font("Verdana",Font.BOLD,48));
		topicLabel.setForeground(new Color(255,51,153));
		topicPanel.add(topicLabel);

		centerPanel.setLayout(new GridLayout(4,1));
		centerPanel.add(topicPanel);
		centerPanel.add(namePicPanel);
		centerPanel.add(topicSizePanel);
		centerPanel.add(themeColorPanel);

		namePicPanel.setLayout(new GridLayout(2,1));
		picNameLabel.setFont(new Font("Verdana",Font.BOLD,18));
		namePicPanel.add(picNameLabel);

		picNameTextFieldPanel.setLayout(null);
		picNameTextFieldPanel.add(picterNameTextField);
		picterNameTextField.setBounds(0,0, 370,50);
		picterNameTextField.setFont(new Font("Verdana",Font.BOLD,18));
		namePicPanel.add(picNameTextFieldPanel);


		topicSizePanel.setLayout(new GridLayout(2,1));
		chooseSizeLabel.setFont(new Font("Verdana",Font.BOLD,18));
		topicSizePanel.add(chooseSizeLabel);
		topicSizePanel.add(sizePanel);

		sizePanel.setLayout(new GridLayout(1,4));
		xLabel.setFont(new Font("Verdana",Font.BOLD,18));
		sizePanel.add(xLabel);

		xTextFieldPanel.setLayout(null);
		xTextFieldPanel.add(sizexTextField);
		sizexTextField.setBounds(0,0, 70,45);
		sizexTextField.setFont(new Font("Verdana",Font.BOLD,18));
		sizePanel.add(xTextFieldPanel);

		yLabel.setFont(new Font("Verdana",Font.BOLD,18));
		sizePanel.add(yLabel);

		yTextFieldPanel.add(sizeyTextField);
		yTextFieldPanel.setLayout(null);
		sizeyTextField.setBounds(0,0, 70,45);
		sizeyTextField.setFont(new Font("Verdana",Font.BOLD,18));
		sizePanel.add(yTextFieldPanel);

		themeColorPanel.setLayout(new GridLayout(2,1));
		colorThemeLabel.setFont(new Font("Verdana",Font.BOLD,18));
		themeColorPanel.add(colorThemeLabel);

		colorPanel.setLayout(new GridLayout(2,3));
		colorPanel.add(AdamRadioButton);
		AdamRadioButton.setFont(new Font("Verdana",Font.BOLD,18));
		colorPanel.add(AvaRadioButton);
		AvaRadioButton.setFont(new Font("Verdana",Font.BOLD,18));
		colorPanel.add(EveRadioButton);
		EveRadioButton.setFont(new Font("Verdana",Font.BOLD,18));
		colorPanel.add(new AdamColor().getColorPanel());
		colorPanel.add(new AvaColor().getColorPanel());
		colorPanel.add(new EveColor().getColorPanel());
		themeColorPanel.add(colorPanel);

		buttomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttomPanel.add(backButton);
		buttomPanel.add(nextButton);
		buttomPanel.setBorder(new EmptyBorder(0, 0, 10, 30));

		customDetailsFrame.add(customDetailsPanel);
		customDetailsFrame.setSize(1280,720);
		customDetailsFrame.setLocationRelativeTo(null);
		customDetailsFrame.setVisible(true);
		customDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backButton.addActionListener(this::actionPerformed);
		nextButton.addActionListener(this::actionPerformed);
		AdamRadioButton.addItemListener(this::itemStateChanged);
		AvaRadioButton.addItemListener(this::itemStateChanged);
		EveRadioButton.addItemListener(this::itemStateChanged);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			customDetailsFrame.dispose();
			HomePage homePage = new HomePage();
		}
		else if(e.getSource() == nextButton) {
			customDetailsFrame.dispose();
			CanvasPage canvasPage = new CanvasPage(username, new PaperPanel(), colorStyle, picterNameTextField.getText(), sizexTextField.getText(), sizeyTextField.getText());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == AdamRadioButton){
			colorStyle = new AdamColor();
		}
		else if (e.getSource() == AvaRadioButton){
			colorStyle = new AvaColor();
		}
		else if (e.getSource() == EveRadioButton){
			colorStyle = new EveColor();
		}
	}
}