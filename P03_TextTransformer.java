import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_TextTransformer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        StringBuilder sb = new StringBuilder();

        while (!inputLine.equals("burp")) {
            sb.append(inputLine);

            inputLine = scan.nextLine();
        }

        String finalString = sb.toString().replaceAll("\\s+", " ");
        Pattern pattern = Pattern.compile("([$%&'])([^$%&']+)\\1");
        Matcher matcher = pattern.matcher(finalString);

        while (matcher.find()) {
            char specialChar = matcher.group(1).charAt(0);
            String captured = matcher.group(2);
            int weight = getWeight(specialChar);

            StringBuilder output = new StringBuilder();

            for (int index = 0; index < captured.length(); index++) {
                char newChar;
                char nextChar = captured.charAt(index);
                if (index % 2 == 0) {
                    newChar = (char) (nextChar + weight);
                } else {
                    newChar = (char) (nextChar - weight);
                }
                output.append(newChar);
            }

            System.out.print(output + " ");
        }
    }


    private static int getWeight(char specialChar) {
        switch (specialChar) {
            case '$':
                return 1;
            case '%':
                return 2;
            case '&':
                return 3;
        }
        return 4;
    }
}