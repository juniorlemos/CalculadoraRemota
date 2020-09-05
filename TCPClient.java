package sd;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		Socket s = null;
		
		
		Scanner n1 =new Scanner(System.in);
		Scanner n2=new Scanner(System.in);
		Scanner var=new Scanner(System.in) ;
		
		String ns1; 
		String ns2;
		String nvar;
		
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);    
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());
		
			
			System.out.println("Calculadora");
			System.out.println("Digite um numero aperte enter");
			
			ns1=n1.nextLine();
			
			System.out.println("Digite uma operação e aperte enter");
			nvar=var.nextLine();
			
			
			System.out.println("Digite um numero aperte enter");
			ns2=n2.nextLine();

			
			out.writeUTF(ns1+";"+nvar+";"+ns2);      	// UTF is a string encoding see Sn. 4.4
			String data = in.readUTF();	    // read a line of data from the stream
			System.out.println("Resposta: "+ data) ; 
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}