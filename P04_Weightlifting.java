import java.util.*;

public class P04_Weightlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long lines = Long.parseLong(scanner.nextLine());

        TreeMap<String, TreeMap<String, Long>> players = new TreeMap<>();

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();
            String[] information = input.split("\\s+");
            String playerName = information[0];
            String exercise = information[1];
            long weight = Long.parseLong(information[2]);
            if (!players.containsKey(playerName)) {
                players.put(playerName, new TreeMap<>());
            }

            if (players.get(playerName).containsKey(exercise)){
                players.get(playerName)
                        .put(exercise, players
                                        .get(playerName)
                                        .get(exercise)
                                        + weight);

            } else {
                players.get(playerName).put(exercise, weight);
            }
        }

        for (String name : players.keySet()) {
            System.out.print(name + " : ");
            ArrayList<String> exersises = new ArrayList<>();
            for (String exersise : players.get(name).keySet()) {
                exersises.add(String.format("%s - %d kg",
                        exersise,
                        players.get(name).get(exersise)));

            }

            System.out.printf(exersises.toString().substring(1, exersises.toString().length() - 1));
            System.out.println();
        }
    }
}