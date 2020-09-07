// Thread 클래스의 start 함수는 파생 스레드를 하나 생성해서 run 함수의 내용을 수행토록 지시한다.
// Thread 클래스는 멤버변수로 Runnable 인터페이스타입의 참조변수를 가지고 있다.
// 만약 Runnable 인터페이스 참조변수의 값이 null이 아니라면 해당 객체가 가지고 있는 run을 사용한다.

public class Test {
	public static void main(String[] args) {
		Thread t1 = new MyThread(); // MyThread의 run함수가 스레드에서 실행
		Thread t2 = new Thread(new MyRunnable()); //MyRunnalble의 run함수가 스레드에서 실행
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {

	}
}