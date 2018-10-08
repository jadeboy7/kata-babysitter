package babysitter;

import exception.InvalidInputException;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Babysitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // start time
        String msg = "Enter start time (between 5 P.M. and 4 A.M.): ";
        int start = getInput(scanner, msg);

        // end time
        msg = "Enter end time (between 5 P.M. and 4 A.M.): ";
        int end = getInput(scanner, msg);

        // bedtime
        msg = "Enter bedtime (between 5 P.M. and 4 A.M.): ";
        int bed = getInput(scanner, msg);

        // close scanner when finished
        scanner.close();

        try {
            calculateCharge(start, end, bed);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getInput(Scanner scanner, String msg) {
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

    static int calculateCharge(int start, int end, int bed) throws InvalidInputException {
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
            1a. Start to end, if both after midnight: $16/hour (regardless of bedtime)
            1b. Midnight to end, if start time is before/at midnight: $16/hour (regardless of bedtime)
            2a. Start time to end time, if start time is before midnight, end time is before/at midnight, and end time is before/at bedtime: $12/hour
            2b. Start time to bedtime, if start time is before midnight, end time is before/at midnight, and end time is after bedtime: $12/hour
            2c. Start time to bedtime, if start time is before midnight, bedtime is before/at midnight, and end time is after midnight: $12/hour
            2d. Start time to midnight, if start time is before midnight and bedtime is after midnight, and end time is after midnight: $12/hour
            3a. Start time to end time, if start time is after bedtime, start time is before midnight, and end time is before/at midnight: $8/hour
            3b. Bedtime to end time, if bedtime is after start time, bedtime is before midnight and end time is before/at midnight: $8/hour
            3c. Bedtime to midnight, if bedtime is at/after start time, bedtime is before midnight and end time is after midnight: $8/hour
         */
        int totalCharge = 0;

        // 1a.
        if (startIndex > midnightIndex) {
            totalCharge += Math.max(0, endIndex - startIndex) * MIDNIGHT_TO_END;
        }

        // 1b.
        if (startIndex <= midnightIndex) {
            totalCharge += Math.max(0, endIndex - midnightIndex) * MIDNIGHT_TO_END;
        }

        // 2a.
        if (startIndex < midnightIndex && endIndex <= midnightIndex && endIndex <= bedIndex) {
            totalCharge += Math.max(0, endIndex - startIndex) * START_TO_BED;
        }

        // 2b.
        if (startIndex < midnightIndex && endIndex <= midnightIndex && endIndex > bedIndex) {
            totalCharge += Math.max(0, bedIndex - startIndex) * START_TO_BED;
        }

        // 2c.
        if (startIndex < midnightIndex && bedIndex <= midnightIndex && endIndex > midnightIndex) {
            totalCharge += Math.max(0, bedIndex - startIndex) * START_TO_BED;
        }

        // 2d.
        if (startIndex < midnightIndex && bedIndex > midnightIndex && endIndex > midnightIndex) {
            totalCharge += Math.max(0, midnightIndex - startIndex) * START_TO_BED;
        }

        // 3a.
        if (bedIndex <= startIndex && startIndex < midnightIndex && endIndex <= midnightIndex) {
            totalCharge += Math.max(0, endIndex - startIndex) * BED_TO_MIDNIGHT;
        }

        // 3b.
        if (bedIndex > startIndex && bedIndex < midnightIndex && endIndex <= midnightIndex) {
            totalCharge += Math.max(0, endIndex - bedIndex) * BED_TO_MIDNIGHT;
        }

        // 3c.
        if (bedIndex >= startIndex && bedIndex < midnightIndex && endIndex > midnightIndex) {
            totalCharge += Math.max(0, midnightIndex - bedIndex) * BED_TO_MIDNIGHT;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String strTotalCharge = formatter.format(totalCharge);
        System.out.println("Total Nightly Charge: " + strTotalCharge);

        return totalCharge;
    }
}