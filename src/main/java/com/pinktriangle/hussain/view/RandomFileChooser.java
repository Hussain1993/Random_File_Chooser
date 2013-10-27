package com.pinktriangle.hussain.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	
	private JFileChooser fileChooser;
	
	public RandomFileChooser(){
		super("Random File Chooser");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 110));
		initWidgets();
		setLayout();
		addWidgets();
		addActionListeners();
	}
	
	private void initWidgets(){
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		
		label = new JLabel("Chosen Folder:");
		folderPath = new JTextField(20);
		folderPath.setEnabled(false);
		chooseFolder = new JButton("Choose Folder");
		
		chooseRandomFile = new JButton("Random File");
		cancel = new JButton("Cancel");
	}
	
	private void setLayout(){
		panelCenter.setLayout(new FlowLayout());
		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	private void addWidgets(){
		panelCenter.add(label);
		panelCenter.add(folderPath);
		panelCenter.add(chooseFolder);
		
		add(panelCenter,BorderLayout.CENTER);
		
		panelSouth.add(chooseRandomFile);
		panelSouth.add(cancel);
		
		add(panelSouth, BorderLayout.SOUTH);
	}
	
	private void addActionListeners(){
		
	}

}
