package codility;

import java.util.HashMap;

// List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
// occurrencies.entrySet().stream().filter(i -> i.getValue() % 2 == 1).findFirst().get().getKey();

class OddOccurenciesInArray {

    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> occurrencies = new HashMap<>();
        if (A.length == 1) {
            return A[0];
        }
        if (A.length > 1000000 || A.length % 2 == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (occurrencies.keySet().contains(A[i])) {
                occurrencies.put(A[i], occurrencies.get(A[i]) + 1);
            } else {
                occurrencies.put(A[i], 1);
            }
        }
        for (Integer key : occurrencies.keySet()) {
            if (occurrencies.get(key) % 2 == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OddOccurenciesInArray app = new OddOccurenciesInArray();
        int[] numbers = { 9, 3, 9, 3, 9, 7, 9 };
        System.out.println(app.solution(numbers));

    }
}
