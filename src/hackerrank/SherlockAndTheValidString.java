package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class SherlockAndTheValidString {

	public String solution(String s) {
		
		HashMap<Character, Integer> occurrencies = new HashMap<>();
		

		for (Character ch : s.toCharArray()) {
			if (occurrencies.keySet().contains(ch)) {
				occurrencies.put(ch, occurrencies.get(ch) + 1);
			} else {
				occurrencies.put(ch, 1);
			}
		}

		List<Integer> freq = occurrencies.values().stream().sorted().distinct().collect(Collectors.toList());
		
		System.out.println(occurrencies);		
		System.out.println(freq);
		
		if(freq.size() > 2){
			return "NO";
		}

		if(freq.get(0) == 1){
			return "YES";
		}

		if(freq.get(1)- freq.get(0) == 1){
			return "YES";
		}
		return "buu";
	}

	public static void main(String[] args) {
		SherlockAndTheValidString app = new SherlockAndTheValidString();
		System.out.println(app.solution("aabbcd"));		
	}
}