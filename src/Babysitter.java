import java.util.Scanner;

public class Babysitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // start time
        System.out.print("Enter start time: ");
        int start = scanner.nextInt();

        // end time
        System.out.print("Enter end time: ");
        int end = scanner.nextInt();

        // bedtime
        System.out.print("Enter bedtime: ");
        int bed = scanner.nextInt();

        calculateCharge(start, end, bed);
    }

    private static void calculateCharge(int start, int end, int bed) {
        System.out.println("Start: " + start + ", End: " + end + ", Bed: " + bed);
    }
}