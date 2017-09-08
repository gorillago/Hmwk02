import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

public class Hmwk02 {
    public static void main(String[] args) {
        int[] ranges = {26, 52, 62, 67, 72};
        int length = getLength();

        for (int i = 1; i <= length; i++) {
            System.out.printf("L= %d", i);
        }

        System.out.printf("");
    }
    private static double log(double number, double base) {
        double result = Math.log(number)/Math.log(base);
        return result;
    }
    private static double calculateMaximumEntropy(int range, int length) {
        double result = log(Math.pow(range, length-1),2);
        return result;
    }
    private static int getLength() {
        final int MAX = 50;
        int length = 0;
        Scanner scanner = new Scanner(System.in);
        String errorMessage = "";
        boolean successful = false;

        while (!successful) {
            System.out.println("Please enter an integer from 1 to " + MAX + ": ");

            String input = scanner.next();
            if (isInteger(input)) {
                int inputInt = getInteger(input);

                if (inputInt >= 1 && inputInt <= MAX) {
                    length = inputInt;
                    successful = true;
                } else {
                    errorMessage = "\"" + inputInt + "\" is not between 1 and " + MAX + ".";
                }

            } else {
                errorMessage = "\"" + input + "\" is not a valid integer.";
            }

            if (!successful) {
                System.out.println(errorMessage);
            }
        }
        return length;
    }
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    private static int getInteger(String input) {
        int result = Integer.parseInt(input);
        return result;
    }
    private static void showHTMLTable(String html) {
        File file = new File("results.html");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Unable to create \"" + file.getName() + "\"");
            }
        }

    }
}
