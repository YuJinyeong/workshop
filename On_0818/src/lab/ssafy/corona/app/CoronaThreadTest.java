package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaRunnable;
import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadTest {

	public static void main(String[] args) {
		for (int t = 0; t < 1000; t++) {
//
//			// Runnable 사용해서
//			CoronaRunnable cr = new CoronaRunnable(t);
//			Thread thread = new Thread(cr);

//			// Thread 사용해서
//			CoronaThread thread = new CoronaThread(t);
//			
//			thread.start();

//			System.out.println("before Thread.sleep()");
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("after Thread.sleep()");

			CoronaThread thread = new CoronaThread(t);
			thread.start();
		}
	}
}