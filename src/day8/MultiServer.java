package day8;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;	// 서버 스레드 리스트
	private Vector<String> userList = new Vector<String>();
	private Socket socket;	// 소켓
	public MultiServer()throws IOException{	
	
		list = new ArrayList<MultiServerThread>();	// 스레드 리스트
		ServerSocket serverSocket = new ServerSocket(5000);	//서버 소켓 번호 설정
		MultiServerThread mst = null;	// 멀티 스레드
		boolean isStop = false;
		
		while(!isStop){
			System.out.println("Server ready...");	// 대기상태 표시
			socket = serverSocket.accept();	// 입력 대기
			
			mst = new MultiServerThread(this);	// 멀티 서버 스레드 생성
			list.add(mst);	// 생성된 멀티 서버 스레드 리스트에 추가
			Thread t = new Thread(mst);	// Runnable 스레드로 받기
			t.start();	// Runnable 실행
		}
	}
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	public Socket getSocket()
	{
		return socket;
	}
	public Vector<String> getUserList(){
		return userList;
	}
	public void addUser(String name) {
		userList.add(name);
	}
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
}
