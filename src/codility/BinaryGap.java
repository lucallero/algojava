package codility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BinaryGap {

	public int solution(int N) {
		if (N < 1 || N > 2147483647)
			return 0;
			
		String binaryN = Integer.toBinaryString(N);
		ArrayList<String> binaryGaps = new ArrayList<String>();
		Pattern pattern = Pattern.compile("10+");
		Matcher matcher = pattern.matcher(binaryN);
		
		while (matcher.find()) {
			binaryGaps.add(matcher.group());
		}
		// System.out.println(binaryGaps);
		if (binaryN.endsWith("0")) {
			binaryGaps.remove(binaryGaps.size() - 1);
		}

		if (binaryGaps.isEmpty())
			return 0;

		String longest = "";
		for (String gap : binaryGaps) {
			if (gap.length() > longest.length()) {
				longest = gap;
			}
		}
		return longest.length() - 1;
	}

	public static void main(String[] args) {
		BinaryGap app = new BinaryGap();
		System.out.println(app.solution(1126));
		System.out.println(app.solution(1));
		System.out.println(app.solution(15));
		System.out.println(app.solution(1041));
	}
}