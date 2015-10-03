import java.util.ArrayList;
import java.util.Scanner;

public class P03_FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLines = Integer.parseInt(scanner.nextLine());

        /* easier way, probably
        char[][] matrix1 = new char[inputLines][];
        for (int i = 0; i < matrix1.length; i++) {
            matrix1[i] = scanner.nextLine().toCharArray();
        }

        boolean hasMoved = true;
        while (hasMoved) {
            hasMoved = false;
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[col].length; col++) {
                if (matrix1[row][col] != 'o') {
                    if (matrix1[row][col] == '>') {
                        if (col + 1 <= matrix1.length - 1 &&
                                matrix1[row][col + 1] == 'o') {
                            matrix1[row][col] = 'o';
                            matrix1[row][col + 1] = '>';
                            hasMoved = true;
                        }
                    } else if (matrix1[row][col] == '<') {
                        if (col - 1 <= 0 &&
                                matrix1[row][col - 1] == 'o') {
                            matrix1[row][col] = 'o';
                            matrix1[row][col - 1] = '<';
                            hasMoved = true;
                        } else if (matrix1[row][col] == '^') {
                            if (row >= 0 &&
                                    matrix1[row - 1][col] == 'o') {
                                matrix1[row][col] = 'o';
                                matrix1[row - 1][col] = '^';
                                hasMoved = true;
                            } else if (matrix1[row][col] == 'v') {
                                if (row <= matrix1.length - 1 &&
                                        matrix1[row + 1][col] == 'o') {
                                    matrix1[row][col] = 'o';
                                    matrix1[row - 1][col] = 'v';
                                    hasMoved = true;
                                }
                            }
                        }
                    }
                }
            }
            hasMoved = true;
        }
            for (char[] chars : matrix1) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();
            }
        }

*/
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        fillMatrix(scanner, inputLines, matrix);

        boolean isChanged = false;
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(row).size(); column++) {
                Character currentChar = matrix.get(row).get(column);
                if (currentChar != 'o') {

                    switch (currentChar) {
                        case 'v' :
                            if (row == matrix.size() - 1) {

                                break;
                            } else if (matrix.get(row + 1).get(column) == 'o') {
                                matrix.get(row + 1).set(column, 'v');
                                matrix.get(row).set(column, 'o');
                                isChanged = true;
                            }
                            break;
                        case '>' :
                            if (column == matrix.get(row).size() - 1) {

                                break;
                            } else if (matrix.get(row).get(column + 1) == 'o') {
                                matrix.get(row).set(column + 1, '>');
                                matrix.get(row).set(column, 'o');
                                isChanged = true;
                            }
                            break;
                        case '<' :
                            if (column == 0) {

                                break;
                            } else if (matrix.get(row).get(column - 1) == 'o') {
                                matrix.get(row).set(column - 1, '<');
                                matrix.get(row).set(column, 'o');
                                isChanged = true;
                            }
                            break;

                        case '^' :
                            if (row == 0) {

                                break;
                            } else if (matrix.get(row - 1).get(column) == 'o') {
                                matrix.get(row - 1).set(column, '^');
                                matrix.get(row).set(column, 'o');
                                isChanged = true;
                            }
                            break;
                    }
                }
            }
            if (isChanged && row == matrix.size() - 1) {
                row = -1;
                isChanged = false;
            }
        }

                    for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j));
            }
            System.out.println();
        }
    }


    private static void fillMatrix(Scanner scanner, int inputLines, ArrayList<ArrayList<Character>> matrix) {
        for (int i = 0; i < inputLines; i++) {
            matrix.add(new ArrayList<Character>());
            String input = scanner.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < input.length(); j++) {
                matrix.get(i).add(j, input.charAt(j));
            }
        }
    }
}
