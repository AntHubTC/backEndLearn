import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	private Container container;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JTextField displayField;
	private String lastCommand;
	private double result;
	private boolean start;
	
	public Calculator() {
		super("Calculator");
		
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//this.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
		
		container = getContentPane();
		layout = new GridBagLayout();
		container.setLayout(layout);
		constraints = new GridBagConstraints();
		start = true;
		result = 0;
		lastCommand = "=";
		displayField = new JTextField(20);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 100;
		constraints.weighty = 100;
		layout.setConstraints(displayField, constraints);
		container.add(displayField);
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		addButton("Backspace", 0, 1, 1, 1, insert);
		addButton("CE", 1, 1, 1, 1, insert);
		addButton("7", 0, 2, 1, 1, insert);
		addButton("8", 1, 2, 1, 1, insert);
		addButton("9", 2, 2, 1, 1, insert);
		addButton("/", 3, 2, 1, 1, command);
		addButton("4", 0, 3, 1, 1, insert);
		addButton("5", 1, 3, 1, 1, insert);
		addButton("6", 2, 3, 1, 1, insert);
		addButton("*", 3, 3, 1, 1, command);
		addButton("1", 0, 4, 1, 1, insert);
		addButton("2", 1, 4, 1, 1, insert);
		addButton("3", 2, 4, 1, 1, insert);
		addButton("minus", 3, 4, 1, 1, command);
		addButton("0", 0, 5, 1, 1, insert);
		addButton("-", 1, 5, 1, 1, insert);
		addButton(".", 2, 5, 1, 1, insert);
		addButton("+", 3, 5, 1, 1, command);
		addButton("=", 2, 1, 2, 1, command);
		setSize(400, 200);
		setVisible(true);
	}

	private void addButton(String label, int row, int column, int with,
			int height, ActionListener listener){
		JButton button = new JButton(label);
		constraints.gridx = row;
		constraints.gridy = column;
		constraints.gridwidth = with;
		constraints.gridheight = height;
		constraints.fill = GridBagConstraints.BOTH;
		button.addActionListener(listener);
		layout.setConstraints(button, constraints);
		container.add(button);
	}

	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			if (start){
				displayField.setText("");
				start = false;
				if (input.equals("-"))
					displayField.setText(displayField.getText() + "-");
			}

			if (!input.equals("-")){
				if (input.equals("Backspace")){
					String str = displayField.getText();
					if (str.length() > 0)
						displayField
								.setText(str.substring(0, str.length() - 1));
				}
				else if (input.equals("CE")){
					displayField.setText("0");
					start = true;
				}
				else
					displayField.setText(displayField.getText() + input);
			}
		}
	}

	private class CommandAction implements ActionListener{
		public void actionPerformed(ActionEvent evt){
			String command = evt.getActionCommand();
			if (start){
				lastCommand = command;
			}
			else{
				calculate(Double.parseDouble(displayField.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}

	public void calculate(double x){
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("minus"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		displayField.setText("" + result);

	}

	public static void main(String[] args){
		Calculator calculator = new Calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
