package sd;

import java.net.*;
import java.io.*;
public class TCPServer {
	public static void main (String args[]) {
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			                 // an echo server

			
			
			float n1,n2,res = 0;

			
			boolean zero=false;
			String data = in.readUTF();
			String array[] = data.split(";");
			
			
			
			String var =array[1];

			 System.out.println("valor"+var);
			switch (var) {
			case "+":
				
				
				n1=Float.parseFloat(array[0]);
				n2=Float.parseFloat(array[2]);
				
				res=n1+n2;
				System.out.println(res);
				break;
				
		case "-":
				
				n1=Float.parseFloat(array[0]);
				n2=Float.parseFloat(array[2]);
				
				res=n1-n2;
				System.out.println(res);
				
				break;
					
		case "*":
			
			n1=Float.parseFloat(array[0]);
			n2=Float.parseFloat(array[2]);
			
			res=n1*n2;
			System.out.println(res);
			
			break;		
				
		case "/":
			
			n1=Float.parseFloat(array[0]);
			n2=Float.parseFloat(array[2]);
			
			if (n2==0) {
				
			zero=true;
			break;
				
			}
			res=n1/n2;
			System.out.println(res);
			
			break;	
			default:
				break;
			}
                			
			data=String.valueOf(res);
			
			if (zero) {
			System.out.println();
			out.writeUTF("Nao existe divisão por zero");
			zero = false;
			}
			else {
				out.writeUTF("resultado: "+data);
		}
			
			// read a line of data from the stream
		
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
}