package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('(', ')');
        pairs.put('[', ']');

        for (Character current : s.toCharArray()) {
            if (pairs.containsKey(current)) {
                stack.add(current);
            } else if (stack.isEmpty() || pairs.get(stack.pop()) != current) {
                return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("C:\\NewLife\\Coding\\Java\\Practicing\\output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
