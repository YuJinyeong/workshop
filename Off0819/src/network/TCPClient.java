package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	// 1. 서버의 IP주소와 port번호를 입력해서 Socket객체를 생성함으로써 연결요청을 보냄
	// 2. 연결요청이 성공할 경우 Socket객체 생성이 정상 완료 됨..
	// 3. Socket객체로부터 입력.출력 스트림을 받아서 원하는대로 읽고 쓰면 됨

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket socket = new Socket("127.0.0.1", 3000);
			while (true) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// System.out.println(br.readLine());
				String str = null;
				str = br.readLine();
				if (!str.equals("종료")) {
					System.out.println(str);
				} else {
					System.out.println("Server에 의해서 종료");
					break;
				}

				str = sc.next();
				if (!str.equals("종료")) {
					bw.write(str + "\n");
					bw.flush();
				} else {
					System.out.println("Client에 의해서 종료");
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
