package br.com.objective.jeecourse.client.gui;

import br.com.objective.jeecourse.core.Calculator;

public class Controller {
	
	@SuppressWarnings("unused")
	private Calculator calculator;
	private View view;

	public Controller(Calculator calculator, View view) {
		this.calculator = calculator;
		this.view = view;

		createInputListener();
	}

	private void createInputListener() {
		view.setInputListener(new ViewInputListener() {
			
			public void buttonAddPressed() {
				System.out.println("Add");
			}
			
			public void buttonSubPressed() {
				// TODO Auto-generated method stub
				
			}
			
			public void buttonEqualPressed() {
				// TODO Auto-generated method stub
				
			}
			
			public void buttonComparePressed() {
				// TODO Auto-generated method stub
				
			}
			
			public void buttonClearPressed() {
				view.setDisplayText("");
			}

		});
	}

}
