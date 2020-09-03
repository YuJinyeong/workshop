
public class KMP {
	// ABBAABAA
	static int[] getPi(String pattern) {
		// 접두사와 접미사가 일치하는 최대길이를 담을 배열 선언
		int[] pi = new int[pattern.length()];
		// idx
		int j = 0;
		// i,j가 가리키는 값이 일치하면 둘다 증가
		// 불일치하면 i만 증가시켜야 하므로 for문
		for (int i = 1; i < pattern.length(); i++) {
			// pattern 내에서 i와 j가 가리키는 값이 다를때
			// while문안에 넣는 이유는 중간단계를 건너뛰고 최대한으로 점프하려고
			// j가 더 후퇴할 곳이 있다면 마지막 같았던 곳까지 후퇴한다.
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				// j의 값을 한칸 뺀곳의 값으로 j를 바꿈
				j = pi[j - 1];
			}
			// pattern 내에서 i와 j가 가리키는 값이 같으면
			if (pattern.charAt(i) == pattern.charAt(j)) {
				// i번째의 최대길이는 ++j한 값
				pi[i] = ++j;
			}
		}

		return pi;
	}
}
