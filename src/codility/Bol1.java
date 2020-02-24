package codility;

class Bol1 {

	public String solution(String S) {

		String result = "";
		char currentChar = '1';
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (currentChar == S.charAt(i)) {
				if (count < 2) {
					currentChar = S.charAt(i);
					count++;
					result = result + S.substring(i, i + 1);
				}
			} else {
				count = 1;
				currentChar = S.charAt(i);
				result = result + S.substring(i, i + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Bol1 app = new Bol1();
		System.out.println(app.solution("xxxtxxx"));
	}
}