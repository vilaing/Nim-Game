import java.util.Random;

public class Game{
    
    // Instance variables
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    // turn; decides whether or not the player or computer is moving
    private int turn;
    
    /* Constructor Game:
     * Updates the computerPlayer object with the difficulty and creates
     * the humanPlayer object
     * @param difficulty, either random or smart
    */
    public Game(int difficulty){
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
    }
    
    /* Mutator play:
     * Creates the marble pile then shifts turns between the human and the 
     * computer
     * Ends when the losing player takes the last marble
    */
    public void play(){
        // Creates a pile of marbles randomly from 10 to 100
        Random ran = new Random();
        marbles = ran.nextInt(91) + 10;
        // Randomly decides who moves first
        turn = ran.nextInt(2);
        if(turn == 0) {
            System.out.println("Computer moves first.");
        } else if (turn == 1) {
            System.out.println("Human moves first.");
        }
        // Allows the Human or Computer to move as long as there are more 
        // than 1 marble in the pile
        while(marbles > 1) {
            System.out.println("Pile size: " + marbles +" marbles.");
            // Computer methods are called to make the move and return the 
            // number of marbles taken
            if(turn == 0) {
                computerPlayer.move(marbles);
                System.out.println("Computer takes " + 
                    computerPlayer.getChoice() + " marbles.");
                marbles = marbles - computerPlayer.getChoice();
                turn = 1;
            // Human methods are called to get the number of marbles taken 
            // (recalls if input is faulty)
            } else if (turn == 1) {
                humanPlayer.move();
                // Validates input
                while(true) {
                    if(humanPlayer.getChoice() < 1 || humanPlayer.getChoice() > 
                    (marbles/2)) {
                        System.out.println("Faulty input. Please take at" + 
                            "least 1 marble, but no more than half the pile.");
                        humanPlayer.move();
                    } else {
                        break;
                    }
                }
                marbles = marbles - humanPlayer.getChoice();
                turn = 0;
            }
        }
        // Prints the winner once the last marble is taken
        System.out.println("Only 1 marble left...\n------");
        if(turn == 0) {
            System.out.println("Player wins!");
        } else if (turn == 1) {
            System.out.println("Computer wins!");
        }
    }
}