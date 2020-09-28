package ct;

import java.util.Arrays;

public class BitPrime {
	public static int LAST_NUM = 256*4-1;//255 1023
	public static char sieve[] = new char[(LAST_NUM + 7) / 8 + 1];

	public static void main(String[] args) {
		eratosthenes();
        //소수만 출력
		for (int i = 0; i <= LAST_NUM; i++){
			if (isPrime(i))
				System.out.print(i + " ");
		}
			

	}
    // k가 소수이면 true(0 이외의 값), 소수가 아니면 false(0)을 반환
	public static boolean isPrime(int k) {
		return (sieve[k >>> 3] & (1 << (k & 7))) == 0 ? false : true;
	}

    //숫자 k가 소수가 아님을 마스킹
	public static void setNotPrime(int k) {
		sieve[k >>> 3] &= ~(1 << (k & 7));
	}

	public static void eratosthenes() {
		Arrays.fill(sieve, (char) 255); //모든 비트를 1로 초기화
		setNotPrime(0); //0과 1은 소수가 아님
		setNotPrime(1);
		int i, j, sqrtn = (int) Math.sqrt(LAST_NUM);
		for (i = 2; i <= sqrtn; i++)
			if (isPrime(i))
				for (j = i * i; j <= LAST_NUM; j += i)
					setNotPrime(j);
	}
}