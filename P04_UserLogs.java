import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class P04_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String commandLine = scan.nextLine();

        if (commandLine.equals("end")) {
            return;
        }

        TreeMap<String, LinkedHashMap<String, Integer>> output = new TreeMap<>();
        while (true) {
            String[] info = commandLine.split("\\s+");
            String ip = info[0].replaceAll("IP=", "");
            String user = info[2].replaceAll("user=", "");
            Integer ipCount = 1;

            if (!output.containsKey(user)) {
                output.put(user, new LinkedHashMap<>());
            }

            if (!output.get(user).containsKey(ip)){
                output
                        .get(user)
                        .put(ip, ipCount);
            } else {
                output
                        .get(user)
                        .put(ip, output
                                .get(user)
                                .get(ip) + ipCount);
            }

            commandLine = scan.nextLine();
            if (commandLine.equals("end")) {
                break;
            }
        }

        for (String user : output.keySet()) {
            System.out.println(user + ": ");
            ArrayList<String> list = new ArrayList<>();
            for (String ip : output.get(user).keySet()) {
                list.add(String.format("%s => %d",
                        ip,
                        output.get(user).get(ip)));
            }
            System.out.printf(list.toString().substring(1, list.toString().length() - 1) + ".");
            System.out.println();
        }
    }
}
