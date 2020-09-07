package com.ssafy;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.Socket;
	
	public class NetworkSimpleClient {
	
		public static void main(String[] args) {
			String host = "localhost";
			int port = 5100;
			
			try ( Socket socket = new Socket(host, port) ) {
				
				InputStream input = socket.getInputStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	 
	            String message = reader.readLine();
	            System.out.println(message);
				
			 } catch ( IOException e) {
				 System.out.println("NetworkSimpleClient exception: " + e.getMessage());
				 e.printStackTrace();
			 }
		}
	}