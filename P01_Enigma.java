import java.util.Scanner;

public class P01_Enigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLinesNumber = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[inputLinesNumber];

        for (int i = 0; i < inputLinesNumber; i++) {
            lines[i] = scanner.nextLine();
        }

        int m;
        for (int i = 0; i < lines.length; i++) {
            m = lines[i]
                    .replaceAll("[\\s\\d]+", "")
                    .length() / 2;
            for (int j = 0; j < lines[i].length(); j++) {
                char currentChar = lines[i].charAt(j);

                if (currentChar == ' ' ||
                (currentChar >= '0' && currentChar <= '9')) {
                    System.out.print(currentChar);
                    continue;
                }
                char newChar = (char)(currentChar + m);
                System.out.print(newChar);
            }
            System.out.println();
        }
    }
}
