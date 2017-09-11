import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

public class Hmwk02 {
    public static void main(String[] args) {
        int[] ranges = {26, 52, 62, 67, 72};
        //int length = getLength();
        double[][] array = {{0, 1, 2, 3, 4}, {1, 11, 12, 13, 14}, {2, 21, 22, 23, 34}, {3, 31, 32, 33, 34}, {4, 41, 42, 43, 44}};
        System.out.println(buildHTML(array));
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

        try {
            PrintWriter pr = new PrintWriter(file);
            pr.write(html);
            pr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String buildHTML(double[][] table) {
        StringBuilder builder = new StringBuilder();

        builder = builder.append("<!DOCTYPE html>\n");
        builder = builder.append("<html>\n");
        builder = builder.append("  <head>\n");
        builder = builder.append("    <style>\n");
        builder = builder.append("      table, th, td {\n");
        builder = builder.append("        border: 1px solid black;\n");
        builder = builder.append("      }\n");
        builder = builder.append("    </style>\n");
        builder = builder.append("  </head>\n");
        builder = builder.append("  <body>\n");
        builder = builder.append("    <table>\n");
        builder = builder.append("      <tr>\n");
        builder = builder.append("        <th>Length \\ Entropy</th>\n");

        for (int i = 1; i < table.length; i++) {
            double column = table[i][0];

            builder = builder.append("        <th>");
            builder = builder.append(column);
            builder = builder.append("</th>\n");
        }

        builder = builder.append("      </tr>\n");

        for (int y = 1; y < table.length; y++) {
            double row = table[0][y];

            builder = builder.append("      <tr>\n");
            builder = builder.append("        <th>");
            builder = builder.append(row);
            builder = builder.append("</th>\n");

            for (int x = 1; x < table[x-1].length; x++) {
                double data = table[x][y];

                builder = builder.append("        <td>");
                builder = builder.append(data);
                builder = builder.append("</td>\n");
            }
            builder = builder.append("      </tr>\n");
        }
        builder = builder.append("    </table>\n");
        builder = builder.append("  </body>\n");
        builder = builder.append("</html>\n");

        String result = builder.toString();
        return result;
    }
//    private static double[][] buildTableArray(int[] ranges, int length) {
//
//    }
}
