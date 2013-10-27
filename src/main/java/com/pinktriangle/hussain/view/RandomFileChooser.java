package com.pinktriangle.hussain.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomFileChooser extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String USER_HOME = System.getProperty("user.home");
	
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
		
		chooseRandomFile = new JButton("Choose Episode");
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
		chooseFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				fileChooser = new JFileChooser(new File(USER_HOME));
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("Choose a folder");
				fileChooser.setAcceptAllFileFilterUsed(false);
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					String selectedFolder = fileChooser.getSelectedFile().getPath();
					folderPath.setText(selectedFolder);
				}
			}
		});
		
		chooseRandomFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				String folder = folderPath.getText();
				if(folder.length() == 0)
				{
					//TODO
				}
				else
				{
					String [] files = new File(folder).list();
					int min = 0;
					int max = files.length - 1;
					Random random = new Random();
					int randomNumber = random.nextInt((max - min) + 1) + min;
					System.out.println(files[randomNumber]);
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				RandomFileChooser.this.dispose();
			}
		});
	}

}
