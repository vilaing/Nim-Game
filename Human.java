import java.util.Scanner;

public class Human{
   
    // Instance variables
    private int choice;
    private Scanner input;
    
    /* Constructor Human:
     * Creates the Human object
    */
    public Human(){
        input = new Scanner(System.in);
        choice = -1;
    }
    
    /* Mutator move:
     * Takes user input to find how many marbles are taken in the turn
    */
    public void move(){
        System.out.print("How many marbles would you like to take: ");
        choice = input.nextInt();
    }
    
    /* Accessor getChoice:
     * @return choice; the number of marbles taken
    */
    public int getChoice(){
        return choice;
    }
    
    
}
