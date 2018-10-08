package babysitter;

import exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
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

        try {
            calculateCharge(start, end, bed);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
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

    private static void calculateCharge(int start, int end, int bed) throws InvalidInputException {
        List<Integer> timeArray = Arrays.asList(5,6,7,8,9,10,11,12,1,2,3,4);
        int startIndex, endIndex, bedIndex;
        startIndex = timeArray.indexOf(start);
        endIndex = timeArray.indexOf(end);
        bedIndex = timeArray.indexOf(bed);

        // check for invalid start/end time
        if (endIndex <= startIndex) {
            throw new InvalidInputException("Sorry, you entered invalid start/end times.");
        }

        System.out.println("Start Index: " + startIndex +
                            ", End Index: " + endIndex +
                            ", Bed Index: " + bedIndex);
    }
}