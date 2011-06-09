package br.com.objective.jeecourse.client.gui;


import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class View {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField textDisplay;
	
	private JButton buttonAdd;
	private JButton buttonSub;
	private JButton buttonCompare;
	private JButton buttonClear;
	private JButton buttonEqual;
	
	private ViewInputListener inputListener;
	
	public View() {
		inputListener = new NullViewInputListener();
		
		createGuiComponents();
		registerActionListeners();
		showGui();
		
		textDisplay.requestFocus();
	}

	private void createGuiComponents() {
		frame = new JFrame("Huge Integer Calculator");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new MigLayout("", "[grow]", "[][]"));
		frame.add(panel);
		
		textDisplay = new JTextField();
		textDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textDisplay, "grow, wrap");
		
		buttonAdd = new JButton("+");
		panel.add(buttonAdd, "split 5");
		
		buttonSub = new JButton("-");
		panel.add(buttonSub);
		
		buttonCompare = new JButton("Comp");
		panel.add(buttonCompare);
		
		buttonClear = new JButton("C");
		panel.add(buttonClear);
		
		buttonEqual = new JButton("=");
		panel.add(buttonEqual);
		
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	
	private void registerActionListeners() {
		buttonAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			inputListener.buttonAddPressed();
		}});
		
		buttonSub.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			inputListener.buttonSubPressed();
		}});
		
		buttonCompare.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			inputListener.buttonComparePressed();
		}});
		
		buttonClear.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			inputListener.buttonClearPressed();
		}});
		
		buttonEqual.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			inputListener.buttonEqualPressed();
		}});
	}

	private void showGui() {
		frame.setVisible(true);
	}

	public void setDisplayText(String text) {
		textDisplay.setText(text);
	}
	
	public String getDisplayText() {
		return textDisplay.getText();
	}

	public void setInputListener(ViewInputListener inputListener) {
		this.inputListener = inputListener;
	}
}
