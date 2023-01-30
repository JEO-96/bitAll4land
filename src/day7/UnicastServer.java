package day7;

import java.io.*;
import java.net.*;
public class  UnicastServer{
    private ServerSocket serverS;
  
    public UnicastServer(int port){	// 생성자
        try{
            serverS = new ServerSocket(port);	// 서버 소켓 생성
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
        UnicastServerThread ust=null;	// 유니캐스트 서버 스레드 
        while(true){
            System.out.println("클라이언트 대기중");
    		Socket s=null;
    		try{
    			s = serverS.accept();	// 입력 대기
    		}catch(IOException ioe){
    			ioe.printStackTrace();
    		}
            System.out.println("client ip : "+s.getInetAddress().getHostAddress());
    		
    		ust = new UnicastServerThread(s);	// 유니캐스트 서버 스레드 생성
    		Thread t = new Thread(ust);	// Runnable 객체  ust를 쓰레드로 넘겨줌 
    		t.start();			
    	}
    }
    public static void main(String[] args){
        new UnicastServer(3000);
    }
}