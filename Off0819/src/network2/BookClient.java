package network2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import book.Book;

public class BookClient {
	public static void main(String[] args) {
		List<Book> list;
		try {
			Socket socket = new Socket("127.0.0.1", 3000);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
			list = (List<Book>) is.readObject();
			bw.write("완료\n");
			bw.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
