package week2;

/**
 * You are playing the following Guess Game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates whether the number is higher or lower.
 *
 */
public class Guess_Game {
    /**
     * Guess random number inbetween l_bound and r_bound
     *
     * @param n
     * @return number guessed
     */
    public static int guessNumber(int n, int l_bound, int r_bound, int round){
        int guess = (int) (Math.random() * (r_bound - l_bound + 1) + l_bound);
        round += 1;
        System.out.println("Guess: " + guess);
        if (guess == n) {
            System.out.println("Number was correctly guessed");
            System.out.println("Number of rounds: " + round);
            return guess;
        } else if (guess < n) {
            System.out.println("Number is higher than " + guess);
            return guessNumber(n, guess + 1, r_bound, round);
        } else {
            System.out.println("Number is lower than " + guess);
            return guessNumber(n, l_bound, guess - 1, round);
        }
    }

    public static void main(String args[]){
        //get random number
        int n = (int) (Math.random() * 100);
        System.out.println("Random number is: " + n);
        //create object
        guessNumber(n, 0, 100, 0);

    }
}