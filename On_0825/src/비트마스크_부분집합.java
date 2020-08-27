//비트마스크
//한자리의 비트만 1로 만들어둔 숫자와 &을 하면 해당 자리가 1인지 검사
//|를 하면 해당 자리를 1로 on

public class 비트마스크_부분집합 {
	public static void main(String[] args) {
		String[] fruits = { "사과", "오렌지", "참외", "복숭아"};

		// 각 조합은 0부터 7까지 이름이 붙음
		for (int i = 0; i < (1 << fruits.length); i++) {
			for (int j = 0; j < fruits.length; j++) {
				if ((i & (1 << j)) != 0)
					System.out.print(fruits[j] + " ");
			}
			System.out.println();
		}
	}
}
