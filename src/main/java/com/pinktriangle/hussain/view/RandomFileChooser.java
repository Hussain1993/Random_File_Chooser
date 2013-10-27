package com.pinktriangle.hussain.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomFileChooser extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panelCenter;
	private JPanel panelSouth;
	
	private JLabel label;
	private JTextField folderPath;
	private JButton chooseFolder;
	
	private JButton chooseRandomFile;
	private JButton cancel;
	
	public RandomFileChooser(){
		super("Random File Chooser");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 150));
		initWidgets();
		setLayout();
		addWidgets();
		addActionListeners();
	}
	
	private void initWidgets(){
		
	}
	
	private void setLayout(){
		
	}
	
	private void addWidgets(){
		
	}
	
	private void addActionListeners(){
		
	}

}
