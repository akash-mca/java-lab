package swing;
import javax.swing.*;

public class SwingTrial {
	public static void main(String[] args) {

		// Creating instance of JFrame
		JFrame frame = new JFrame("2MCA Java Programming");
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creating panel.
		JPanel panel = new JPanel();
		// adding panel to frame
		frame.add(panel);

		// user defined method for adding components to the panel.
		placeComponents(panel);

		// Setting the frame visibility to true
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		// No layout is set
		panel.setLayout(null);

		// Creating JLabel
		JLabel userLabel = new JLabel("Username");
		// setBounds(x, y, width, height)
		userLabel.setBounds(20, 20, 80, 25);
		panel.add(userLabel);

		// Creating text field
		JTextField userText = new JTextField(20);
		// size of textbox
		userText.setBounds(110, 20, 165, 25);
		// adding it to panel
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 50, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(110, 50, 165, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
	}
}
