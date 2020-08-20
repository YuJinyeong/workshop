package network2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Bookth implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String isbn = sc.next();
		String title = sc.next();
		int price = sc.nextInt();
		int quantity = sc.nextInt();
		try {
			Socket socket = new Socket("127.0.0.1", 3000);
			while (true) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = null;
				str = br.readLine();
				System.out.println(str);
				bw.write(sc.next()+ "\n");
				bw.flush();
				str = br.readLine();
				System.out.println(str);
				bw.write(sc.next()+ "\n");
				bw.flush();
				str = br.readLine();
				System.out.println(str);
				bw.write(sc.next()+ "\n");
				bw.flush();
				str = br.readLine();
				System.out.println(str);
				bw.write(sc.next()+ "\n");
				bw.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
