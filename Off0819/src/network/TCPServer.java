package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

// TCP 통신을 위해 Server가 해야할 일
// 1. 포트를 지저해서 ServerSocket객체를 생성하고 accept함수를 호출함으로써 클라이언트의 연결요청을 기다린다.
// 2. 클라이언트의 요청이 들어와지면 클라이언트와 연결되어진 Socket객체를 accept함수가 리턴해줌
// 3. Socket객체로부터 입력스트림을 통해서 읽고. 출력스트림을 통해서 쓰면 됨.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			// 문만 여는 작업. 연결이 오면 상대방과 연결되도록 다른 통로(소켓)를 열어서 통로를 만든다.
			Socket socket = serverSocket.accept();
//			socket.getOutputStream(); // 데이터가 반대쪽으로 나가는 통로, byte Stream
//			socket.getInputStream(); // 데이터가 들어오는 통로
			// OutputStreamWriter, InputStreamReader: byte -> String
			while (true) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = sc.next();
				if (!str.equals("종료")) {
					bw.write(str + "\n"); // \n이 있어야 버퍼에 써짐
					bw.flush(); // 비움 X 보내고 비움 O
				} else {
					System.out.println("Client에 의해서 종료");
					break;
				}
				String rec = br.readLine();
				if (!rec.equals("종료")) {
					System.out.println(rec);
				} else {
					System.out.println("Server에 의해서 종료");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
