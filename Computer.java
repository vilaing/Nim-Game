import java.util.Random;

public class Computer{
    
    // Instance variables
    private int mode;
    private int choice;
    private Random r;
    
    /* Constructs the Computer object with either Random or Smart mode
     * @param m; mode level
    */
    public Computer(int m){
        if(m == 1) {
            System.out.println("Chosen difficulty: Random");
        } else if (m == 2) {
            System.out.println("Chosen difficulty: Smart");
        }
        mode = m;
        choice = -1;
    }
    
    /* Mutator move:
     * Does a series of calculations to find the best number of marbles to take
     * Depends on the difficulty level
     * @param marblesLeft; the size of the marble pile
    */
    public void move(int marblesLeft){
        // Random mode takes a random number from 1 to half of the pile size
        if (mode == 1) {
            r = new Random();
            choice = (r.nextInt(marblesLeft/2))+1;
        // Smart mode makes the number equal to a power of 2 minus 1
        } else if (mode == 2) {
            // Takes a random number if the marble pile is already a power of 2 - 1
            if (marblesLeft == 3 || marblesLeft == 7 || marblesLeft == 15 || 
            marblesLeft == 31 || marblesLeft == 63) {
                r = new Random();
                choice = (r.nextInt(marblesLeft/2))+1;
            } else {
                // Loops through the pile to check every 2 to the power of 1 
                // (using the Math.pow function)
                for(int i = 0; Math.pow(2,i) <= marblesLeft; i++) {
                    // If the power of 2 is a valid move that allows for a 
                    // winning position
                    if((Math.pow(2,i)-1) >= (marblesLeft/2)) {
                        // Note the number needed then break the loop
                        choice = marblesLeft - (int)(Math.pow(2,i)-1);
                        break;
                    }
                }
            }  
        } 
    }
    
    /* Accessor getChoice:
     * @return choice; the number of marbles taken
    */
    public int getChoice(){
        return choice;
    }
    
}
