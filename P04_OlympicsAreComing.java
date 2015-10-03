import java.util.*;

public class P04_OlympicsAreComing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        LinkedHashMap<String, HashMap<String, Integer>> output = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String clearedInput = input
                    .trim()
                    .replaceAll("\\s+", " ");
            String[] info = clearedInput.split("\\|");
            String name = info[0].trim();
            String country = info[1].trim();
            Integer wins = 1;

            if (!output.containsKey(country)) {
                output.put(country, new HashMap<>());
            }
            if (!output.get(country).containsKey(name)){
                output
                        .get(country)
                        .put(name, wins);
            } else {
                output
                    .get(country)
                    .put(name, output
                            .get(country)
                            .get(name) + wins);
            }

            input = scan.nextLine();
        }

        for (String country : output.keySet()) {
            System.out.print(country + " (");
            System.out.print(output.get(country).size() + " participants): ");
            int wins = 0;
            for (String name : output.get(country).keySet()) {
                wins += output.get(country).get(name).intValue();
            }
            System.out.println(wins + " wins");

        }
    }
}
