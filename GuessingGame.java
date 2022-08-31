import java.util.*;

public class GuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        GuessingGame methodChange = new GuessingGame();
        methodChange.menu(scoreBoard);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        GuessingGame methodChange = new GuessingGame();
        Scanner input = new Scanner(System.in);

        System.out.println("*********************");
        System.out.println("1) Play Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit");
        System.out.println("*********************");

        try {
            System.out.print(" Enter Your Choice: ");
            int menuOption = input.nextInt();
            System.out.println("\n"+"---------------------------------------");

            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"Give the range of the game as you like: ");
                    int numberRange = input.nextInt();

                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"*** Thanks for playing!!! ***"+"\n");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid entry. Please Try again");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;

        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);

        int userGuess;
        int guess = 0;

        do {
            System.out.print("Enter your guess: ");
            userGuess = input.nextInt();
            guess++;

            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }

        } while (randomNumber != userGuess);

        System.out.println(" ");

        if (guess == 1) {
            System.out.println("You answered right in " + guess + " try!");
        } else {
            System.out.println("You answered right in " + guess + " tries!");
            System.out.println("\n"+"---------------------------------------");
        }

        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    public void displayScoreBoard() {
        System.out.println("\n"+"*********************");
        System.out.println("Score Board");
        System.out.println("*********************");

        System.out.println("Your fastest games today: " +"\n");
        Collections.sort(scoreBoard);

        for (Integer scores : scoreBoard) {
            System.out.println("Finished the game in " + scores + " tries");
            System.out.println("\n"+"---------------------------------------");
        }

        System.out.println(" ");
        menu(scoreBoard);
    }
}
