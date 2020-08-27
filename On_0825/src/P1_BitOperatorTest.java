
public class P1_BitOperatorTest {

	public static void main(String[] args) {

		// &, |, <<,  >>, >>>, ^, ~
		int i = 1;
		int j = 6;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("i<<1:"+Integer.toBinaryString(i<<1));
		System.out.println("i<<1:"+Integer.toBinaryString(i<<2));
		i <<= 2;
		System.out.println("i:"+Integer.toBinaryString(i));
		System.out.println("j:"+Integer.toBinaryString(j));
		System.out.println("j&i : "+Integer.toBinaryString(j&i));
		System.out.println("j|i : "+Integer.toBinaryString(j|i));
		
		System.out.println("================================");
		int k = 0xa5; // 10100101
		System.out.println(Integer.toBinaryString(k));
		System.out.println("오른쪽에서 1위치비트 1인지 확인 : "+ Integer.toBinaryString(k & (1<<1)));
		System.out.println("오른쪽에서 2위치비트 1인지 확인 : "+ Integer.toBinaryString(k & (1<<2)));
		System.out.println("오른쪽에서 1위치비트 1로 만듦 : "+ Integer.toBinaryString(k | (1<<1)));
		
	}

}
