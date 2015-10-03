import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P03_JaggedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<Integer>> firstArray = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> secondArray = new ArrayList<ArrayList<Integer>>();

        fillJaggedArray(scanner, numberOfLines, firstArray);
        fillJaggedArray(scanner, numberOfLines, secondArray);

        combineMatrix(numberOfLines, firstArray, secondArray);

        int sizeOfLineOne = firstArray.get(0).size();
        boolean isRectangular = true;
        for (int i = 1; i <numberOfLines; i++) {
            if (firstArray.get(i).size() != sizeOfLineOne) {
                isRectangular = false;
                break;
            }
        }

        if (isRectangular) {
            for (ArrayList<Integer> integers : firstArray) {
                System.out.println(integers);
            }
        } else {
            int countOfCells = 0;
            for (ArrayList<Integer> integers : firstArray) {
                countOfCells += integers.size();
            }
            System.out.println(String.format("The total number of cells is: %d", countOfCells));
        }
    }

    private static void combineMatrix(int numberOfLines, ArrayList<ArrayList<Integer>> firstArray, ArrayList<ArrayList<Integer>> secondArray) {
        for (int i = 0; i < numberOfLines; i++) {
            Collections.reverse(secondArray.get(i));
            firstArray.get(i).addAll(secondArray.get(i));
        }
    }

    private static void fillJaggedArray(Scanner scanner, int numberOfLines, ArrayList<ArrayList<Integer>> arrayToFill) {
        for (int i = 0; i < numberOfLines; i++) {
            arrayToFill.add(new ArrayList<Integer>());
            String[] numbersAsStrings = scanner.nextLine().trim().split("\\s+");
            for (String numbersAsString : numbersAsStrings) {
                arrayToFill.get(i).add(Integer.parseInt(numbersAsString));
            }
        }
    }
}
