import java.util.Scanner;

public class Babysitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // start time
        int start;
        do {
            System.out.print("Enter start time (between 5 P.M. and 4 A.M.): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Sorry, please enter a number: ");
                scanner.next();
            }
            start = scanner.nextInt();
        } while (start < 4 || start > 12);

        // end time
        int end;
        do {
            System.out.print("Enter end time (between 5 P.M. and 4 A.M.): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Sorry, please enter a number: ");
                scanner.next();
            }
            end = scanner.nextInt();
        } while (end < 4 || end > 12);

        // bedtime
        int bed;
        do {
            System.out.print("Enter bedtime (between 5 P.M. and 4 A.M.): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Sorry, please enter a number: ");
                scanner.next();
            }
            bed = scanner.nextInt();
        } while (bed < 4 || bed > 12);

        calculateCharge(start, end, bed);
    }

    private static void calculateCharge(int start, int end, int bed) {
        System.out.println("Start: " + start + ", End: " + end + ", Bed: " + bed);
    }
}