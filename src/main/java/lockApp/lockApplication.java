package lockApp;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lockApplication extends JFrame {
    private JPasswordField passwordField;
    private JButton enterButton;
    private JLabel statusLabel;
    private String savedPassword;
    private boolean isPasswordSet = false;

    public lockApplication() {
        // Set up the frame
        setTitle("Locker Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Password field
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Enter button
        enterButton = new JButton("Enter");
        panel.add(enterButton);

        // Status label
        statusLabel = new JLabel("Set your password", SwingConstants.CENTER);
        panel.add(statusLabel);

        // Add panel to frame
        add(panel);

        // Add action listener to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });
    }

    private void handleButtonClick() {
        char[] input = passwordField.getPassword();
        String enteredPassword = new String(input);

        if (!isPasswordSet) {
            // Set the password for the first time
            savedPassword = enteredPassword;
            isPasswordSet = true;
            statusLabel.setText("Password Set");
        } else {
            // Verify the password
            if (enteredPassword.equals(savedPassword)) {
                statusLabel.setText("Correct Password");
            } else {
                statusLabel.setText("Incorrect Password");
            }
        }

        // Clear the password field
        passwordField.setText("");
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new lockApplication().setVisible(true);
            }
        });
    }
}
