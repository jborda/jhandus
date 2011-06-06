package br.com.objective.jeecourse.client.gui;

import java.awt.ComponentOrientation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class View {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField input;
	
	private JButton buttonAdd;
	private JButton buttonSub;
	private JButton buttonCompare;
	private JButton buttonClear;
	
	public View() {
		frame = new JFrame("Huge Integer Calculator");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel(new MigLayout("", "[grow]", "[][]"));
		frame.add(panel);
		
		input = new JTextField();
		input.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(input, "grow, wrap");
		
		buttonAdd = new JButton("+");
		panel.add(buttonAdd, "split 4");
		
		buttonSub = new JButton("-");
		panel.add(buttonSub);
		
		buttonCompare = new JButton("Comp");
		panel.add(buttonCompare);
		
		buttonClear = new JButton("C");
		panel.add(buttonClear);
		
		frame.setVisible(true);
	}

}
