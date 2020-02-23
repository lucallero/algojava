package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    static HashMap<String, Integer> contactsList = new HashMap<>();

    static void add(String name) {
        String key = "";
        for (int i = 1; i <= name.length(); i++) {
            key = name.substring(0, i);
            if (!contactsList.containsKey(key)) {
                contactsList.put(key, 1);
            } else {
                contactsList.put(key, contactsList.get(key) + 1);
            }
        }
    }

    static int find(String partial) {
        if (!contactsList.containsKey(partial)) {
            return 0;
        }
        return contactsList.get(partial);
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        List<Integer> result = new ArrayList<>();
        for (int oper = 0; oper < queries.length; oper++) {
            if (queries[oper][0].equals("add")) {
                add(queries[oper][1]);
            }
            if (queries[oper][0].equals("find")) {
                result.add(find(queries[oper][1]));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
