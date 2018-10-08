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
        } while (value < 1 || value > 12);

        return value;
    }

    private static void calculateCharge(int start, int end, int bed) throws InvalidInputException {
        final List<Integer> timeArray = Arrays.asList(5,6,7,8,9,10,11,12,1,2,3,4);
        final int START_TO_BED = 12, BED_TO_MIDNIGHT = 8, MIDNIGHT_TO_END = 16;

        int startIndex, endIndex, bedIndex, midnightIndex;
        startIndex = timeArray.indexOf(start);
        endIndex = timeArray.indexOf(end);
        bedIndex = timeArray.indexOf(bed);
        midnightIndex = timeArray.indexOf(12);

        // check for invalid start/end time
        if (endIndex <= startIndex) {
            throw new InvalidInputException("Sorry, you entered invalid start/end times.");
        }

        /*
        Hourly rates:
            - $12/hour from start-time to bedtime
            - $8/hour from bedtime to midnight
            - $16/hour from midnight to end of job

         Priority:
            1. Midnight to end: always $16/hour (regardless of bedtime)
            2a. Start time to bedtime, if start time is before midnight and bedtime is before/at midnight: $12/hour
            2b. Start time to midnight, if start time is before midnight and bedtime is after midnight: $12/hour
            3a. Bedtime to end time, if bedtime is before midnight and end time is before/at midnight: $8/hour
            3b. Bedtime to midnight, if bedtime is before midnight and end time is after midnight: $8/hour
         */
        int totalCharge = 0;

        // 1.
        totalCharge += Math.max(0, endIndex - midnightIndex) * MIDNIGHT_TO_END;

        // 2a.
        if (startIndex < midnightIndex && bedIndex <= midnightIndex) {
            totalCharge += Math.max(0, bedIndex - startIndex) * START_TO_BED;
        }

        // 2b.
        if (startIndex < midnightIndex && bedIndex > midnightIndex) {
            totalCharge += Math.max(0, midnightIndex - startIndex) * START_TO_BED;
        }

        // 3a.
        if (bedIndex < midnightIndex && endIndex <= midnightIndex) {
            totalCharge += Math.max(0, endIndex - bedIndex) * BED_TO_MIDNIGHT;
        }

        // 3b.
        if (bedIndex < midnightIndex && endIndex > midnightIndex) {
            totalCharge += Math.max(0, midnightIndex - bedIndex) * BED_TO_MIDNIGHT;
        }

        System.out.println("Total Charge: " + totalCharge);
    }
}