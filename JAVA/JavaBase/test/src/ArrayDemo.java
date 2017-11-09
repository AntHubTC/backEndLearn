import javax.swing.*;

public class ArrayDemo {

	public static void main(String[] args) {
		final int ARRAY_SIZE = 10;
		int n[];
		String output = "";
		n = new int[ARRAY_SIZE];
		for (int i = 0; i < n.length; i++)
			n[i] = 2 + 2 * i;
		output += "Subscript\tValue\n";
		for (int i = 0; i < n.length; i++)
			output += i + "\t" + n[i] + "\n";
		JTextArea outputArea = new JTextArea(11, 10);
		outputArea.setText(output);
		JOptionPane.showMessageDialog(null, outputArea,
				"Initializing to Even Numbers form 2 to 20",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
