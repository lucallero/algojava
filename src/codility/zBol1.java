package codility;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class zBol1 {

	public int solution(int[] A) {
		List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
		return numbers.stream().filter(e -> e % 2 == 0).max(Comparator.comparing(Integer::valueOf)).get();
	}

	public static void main(String[] args) {
		zBol1 app = new zBol1();
		int[] A = { -6, -91, 1011, -100, 84, -22, 0, 1, 473 };
		System.out.println(app.solution(A));
	}
}