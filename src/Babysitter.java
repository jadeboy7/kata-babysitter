import java.util.Scanner;

public class Babysitter {

    public static void main(String[] args) {
        // start time
        String msg = "Enter start time (between 5 P.M. and 4 A.M.): ";
        int start = getInput(msg);

        // end time
        msg = "Enter end time (between 5 P.M. and 4 A.M.): ";
        int end = getInput(msg);

        // bedtime
        msg = "Enter bedtime (between 5 P.M. and 4 A.M.): ";
        int bed = getInput(msg);

        calculateCharge(start, end, bed);
    }

    private static int getInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        int value;

        do {
            System.out.print(msg);
            while (!scanner.hasNextInt()) {
                System.out.print("Sorry, please enter a number: ");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value < 4 || value > 12);

        return value;
    }

    private static void calculateCharge(int start, int end, int bed) {
        System.out.println("Start: " + start + ", End: " + end + ", Bed: " + bed);
    }
}