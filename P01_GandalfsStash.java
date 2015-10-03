import java.util.Scanner;

public class P01_GandalfsStash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mood = Integer.parseInt(scanner.nextLine());

        String foods = scanner.nextLine().toLowerCase().trim();
        String[] foodArray = foods.split("[^a-z]+");

        for (String food : foodArray) {
            switch (food) {
                case "cram": mood += 2; break;
                case "lembas": mood += 3; break;
                case "apple": mood += 1; break;
                case "melon": mood += 1; break;
                case "honeycake": mood += 5; break;
                case "mushrooms": mood -= 10; break;
                default: mood -= 1; break;
            }
        }

        System.out.println(mood);
        if (mood < -5) {
            System.out.println("Angry");
        } else if (mood >= -5 && mood <= 0 ) {
            System.out.println("Sad");
        } else if (mood > 0 && mood <= 15) {
            System.out.println("Happy");
        } else {
            System.out.println("Special JavaScript mood ");
        }
    }
}
