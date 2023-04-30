/* Program name: Paper, Scissor and Rock Version 0.1
Initially created by Dr. Wenjia Li
Finished by _(Your Name)__ 
_   __(Today’s Date)______ 
*/

import javax.swing.JOptionPane;

class BadInputException extends Exception {
    public BadInputException() {
        System.out.println("Invalid Input!");
        JOptionPane.showMessageDialog(null, "Invalid Input!");
    }
}

public class FirstRPSGame 
{ 
    static void Win() {
        JOptionPane.showMessageDialog(null, "You win!"); 
    }

    static void Lose() {
        JOptionPane.showMessageDialog(null, "You lose!");
    }

    static int Play(int yourChoice, int computerChoice) {
        try {
            if (yourChoice == computerChoice){
                JOptionPane.showMessageDialog(null, "It’s a tie!"); 
            }
        
            //Case II: You WIN :)
        
            else if( yourChoice == 0) {
                if(computerChoice == 1) {
                    Lose();
                    return 1;
                }
                else if(computerChoice == 2) {
                    Win();
                    return 0;
                }
            }
        
            else if(yourChoice == 1) {
                if(computerChoice == 0) {
                    Win();
                    return 0;
                }
                else if(computerChoice == 2) {
                    Lose();
                    return 1;
                }
            }
        
            else if(yourChoice == 2) {
                if(computerChoice == 1) {
                    Win();
                    return 0;
                }
                else if(computerChoice == 0) {
                    Lose();
                    return 1;
                }
            }
            else if(yourChoice == 3) {
                return 2;
            }
            else {
                throw new BadInputException();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        //Compare your Choice with computer’s choice and output the result
      //Case I: Both you and computer pick the same choice, then it’s a tie!
      return 1;

}
   public static void main(String args[]) 
   { 
      //Variable declaration
      int yourChoice, computerChoice; //comment please!
      String choice;
      //String yourInput; //comment please!

      //Welcome screen and show the basic rule to the user
      JOptionPane.showMessageDialog(null, "Welcome to Paper, Scissor and Rock");
      JOptionPane.showMessageDialog(null, "Let me remind you the rule first:\nScissor cuts paper, paper covers rock, and rock breaks scissors. ");

      int result;
      try {
        do {
            JOptionPane.showMessageDialog(null, "0: Rock\n1: Paper\n2: Scissor\n3: Quit");
    
          //Get your choice
          choice = JOptionPane.showInputDialog("Now tell me your choice!");
          yourChoice = Integer.parseInt(choice);
    
          //Get computer choice
          computerChoice = (int)(Math.random()*10); //generate a random number
          computerChoice %= 3; //Why we need to modulus 3 here? Think about it.
             result = Play(yourChoice, computerChoice);
          } while(result != 2);
      } catch (NumberFormatException e) {
          System.out.println(e.getMessage());
          JOptionPane.showMessageDialog(null, "Invalid Input!");
      }
          
          


      //Case III: You lose :(


   }
}