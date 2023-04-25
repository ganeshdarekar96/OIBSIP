package Task1;
import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {

    public static void main(String[] args) {

        int lowestnumber = 1;
        int highestnumber = 100;
        int maximumAttempts = 5;
        int score = 0;
        boolean continuePlaying = true;
        
        Random random = new Random();

      try{

        while (continuePlaying) {

            int numberToGuess = random.nextInt(highestnumber - lowestnumber + 1) + lowestnumber;
            int remainingAttempts = maximumAttempts;
            boolean guessedCorrectly = false;
            
            while (remainingAttempts > 0 && !guessedCorrectly) {

                String guessString = JOptionPane.showInputDialog(null, 
                        "Guess the number between " + lowestnumber + " and " + highestnumber + 
                        "\nRemaining Attempts: " + remainingAttempts, 
                        "Number Guessing Game", JOptionPane.PLAIN_MESSAGE);
                
                if (guessString == null) {

                    // User clicked cancel button , so exit the game.
                    continuePlaying = false;
                    break;
                }
                
                int guess = Integer.parseInt(guessString);
                
                if (guess == numberToGuess) {

                    guessedCorrectly = true;
                    score += remainingAttempts;
                    JOptionPane.showMessageDialog(null, 
                            "Congratulations, you guessed the number in " + (maximumAttempts - remainingAttempts + 1) + " attempts!", 
                            "Number Guessing Game", JOptionPane.PLAIN_MESSAGE);
                } 
                
                else if (guess < numberToGuess) {

                    JOptionPane.showMessageDialog(null, +guess+" is too low try the higher number.", "Guessing Game", JOptionPane.PLAIN_MESSAGE);
                    remainingAttempts--;
                } 

                else {

                    JOptionPane.showMessageDialog(null, +guess+" is too high try the lower number.", "Guessing Game", JOptionPane.PLAIN_MESSAGE);
                    remainingAttempts--;
                }

            }
            
            if (!guessedCorrectly) {

                JOptionPane.showMessageDialog(null, "Sorry, the number was " + numberToGuess + ". Better Luck Next Time!", 
                        "Number Guessing Game", JOptionPane.PLAIN_MESSAGE);

            }
            
            int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", 
                    "Number Guessing Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.NO_OPTION) {

                continuePlaying = false;
            }

        }
        
        JOptionPane.showMessageDialog(null, "Your final score is " + score + ".", 
                "Number Guessing Game", JOptionPane.PLAIN_MESSAGE);
                
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Enter valid Integer Number", "Warning", JOptionPane.ERROR_MESSAGE);
    
            }

    }

}
