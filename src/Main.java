import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Create the main window
        JFrame frame = new JFrame("Guess the Number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLayout(null); // Simple layout for manual positioning

        // Label for feedback
        JLabel feedbackLabel = new JLabel("Guess a number between 1 and 100!");
        feedbackLabel.setBounds(20, 10, 200, 20);
        frame.add(feedbackLabel);

        // Text field for user input
        JTextField inputField = new JTextField();
        inputField.setBounds(20, 40, 100, 25);
        frame.add(inputField);

        // Button to check the guess
        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(130, 40, 90, 25);
        frame.add(guessButton);

        // Button action
        guessButton.addActionListener(new ActionListener() {
            int attempts = 0; // Track the number of attempts

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the user's input as an integer
                    int userGuess = Integer.parseInt(inputField.getText());
                    attempts++;

                    // Check if the guess is too low, too high, or correct
                    if (userGuess < randomNumber) {
                        feedbackLabel.setText("Too low!");
                    } else if (userGuess > randomNumber) {
                        feedbackLabel.setText("Too high!");
                    } else {
                        feedbackLabel.setText("Correct! In " + attempts + " attempts.");
                        guessButton.setEnabled(false); // Disable the game after winning
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    feedbackLabel.setText("Enter a valid number!");
                }
                // Clear the input field after each guess
                inputField.setText("");
            }
        });

        // Display the window
        frame.setVisible(true);
    }
}
