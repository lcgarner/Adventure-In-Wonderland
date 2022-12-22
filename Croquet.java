//imports
import java.util.Random;



public class Croquet {
  int score;
  Character character;
  Object distance;

  public Croquet(Character character) {
    this.character = character;
    this.score = 0;

  }

  /**
   * Randomly decides who will have the first turn
   * @param Turn
   * @return whosTurn
   */
  public void firstTurn() {
    Random rand = new Random();
    int result = rand.nextInt(2); // Generate a random number between 0 and 1

    if (result == 0) {
      this.character.printSlow("You start! Show me what you can do.");
    } else {
      this.character.printSlow("ME FIRST!");
    }
  }

/**
 * Simulates a game of croquet between the player and the queen.
 *
 * @param character the player character
 * @return the score of the player after the game
 */
    public void play() {
        this.character.size = 60;
        // Print a message to the console asking the player if they want to play
        this.character.printSlow("The queen demands that you play a game of croquet with her. Answer yes or no.");
      
        // Read the user's input
        String command = this.character.command();
      
        // Print a message to the console based on the user's response
        if (command.equalsIgnoreCase("yes")) {
          this.character.printSlow("POSITIONS!");
        } else if (command.equalsIgnoreCase("no")) {
          this.character.printSlow("Too bad! You play or you die!!");
        } else {
          this.character.printSlow("I have no clue what you're saying we're playing croquet..GRAB A FLAMINGO!");
      }

      // Close the Scanner object
    //   scan.close();
      
    while (true) {
      if (this.character.size<= 30.0){
        this.character.health -= this.character.health/2;
        this.character.printSlow("You are too small to be a player, so the Queen decided you would be more useful as a ball. After the game your health is: " + this.character.health + ".");
        break;
        
    } else if (this.character.size >= 100){
        this.character.health -= this.character.health / 8;
        this.character.printSlow("You play a few games. Although, you could use a rest due to your massive size the physical excertion is now too taxing. After the game your health is: " + this.character.health + ".");
        break;
    } else {
        this.character.health -= this.character.health / 4;
        this.character.printSlow("Your health is: " + this.character.health + ".");
    }
        firstTurn();
      // Begin the game loop
     
        // Prompt the player for a command
        this.character.printSlow("Enter a command to play your turn (e.g. hit ball, move ball, etc.)");
        String playerCommand = this.character.command();

        // Handle the player's turn
        if (playerCommand.equalsIgnoreCase("hit ball")) {
          // Simulate the ball being hit by generating a random distance
          Random rand = new Random();
          int distance = rand.nextInt(10) + 1; // Generate a random number between 1 and 10
          this.character.printSlow("You hit the hedgehog " + distance + " feet!");

          // Update the ball's position on the court based on the distance it was hit
          
        }
       

        // Update the player's score based on their actions
        score += 10;

        // Print the player's current score
        this.character.printSlow("Your score: " + score);

        // End the game if the player reaches a certain score
        if (score >= 50) {
          this.character.printSlow("You win! Congratulations!");
          break;
        }

        // Handle the queen's turn
        Random rand = new Random();
        distance = rand.nextInt(10) + 1; // Generate a random number between 1 and 10
        this.character.printSlow("The queen hit the hedgehog " + distance + " feet!");

        // Update the ball's position on the court based on the distance it was hit
        

        // Update the queen's score based on its actions
        score += 10;

        // Print the queen's current score
        this.character.printSlow("The queen's score: " + score);

        // End the game if the queen reaches a certain score
        if (score >= 50){
            this.character.printSlow("OFF WITH YOUR HEAD");
            this.character.printSlow("GAME OVER");
            break;
        }
    }
}
public static void main(String[] args) {
    Character c = new Character();
    Croquet game = new Croquet(c);
    game.play();
  }
}
