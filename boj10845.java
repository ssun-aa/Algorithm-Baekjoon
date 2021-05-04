package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {
	public static Queue<Integer> que;
	public static int size = 0;// 큐 사이즈
	public static int last;//마지막 데이터 저장; back()에서 사용
	
	public static void push(int num) {
		que.add(num);//큐에 data 삽입
		last = num;//마지막으로 삽입한 data 저장
		size++;//큐 사이즈 증가
	}
	
	public static void pop() {
		if(size==0)//큐에 data가 없을 경우
			System.out.println(-1);
		else {//큐에 data가 있는 경우
			System.out.println(que.poll());//큐의 가장 앞(가장 먼저 저장된) data 반환후 삭제
			size--;
		}
	}
	
	public static void size() {
		System.out.println(size);
	}
	
	public static void empty() {
		if(size==0)//큐에 data가 없을 경우
			System.out.println(1);
		else//큐에 data가 있는 경우
			System.out.println(0);
	}
	
	public static void front() {
		if(size==0)//큐에 data가 없을 경우
			System.out.println(-1);
		else//큐에 data가 있는 경우
			System.out.println(que.peek());//큐의 가장 앞(가장 먼저 저장된) data 반환
	}
	
	public static void back() {
		if(size==0)//큐에 data가 없을 경우
			System.out.println(-1);
		else //큐에 data가 있는 경우
			System.out.println(last);//last에 저장된 가장 마지막 data 출력
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner의 경우 시간이 오래걸리기 때문에 BufferReader를 이용
		
		int n = Integer.parseInt(br.readLine());//readLine은 String 타입이라 integer로 변경
		que = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();//명령어(+data) 입력
			String order[] = line.split(" ");//공백을 기준으로 명령어와 data 구분
			
			switch(order[0]) {//명령어에 따라 실행될 switch문
				case "push":{
					int num = Integer.parseInt(order[1]);
					//push의 경우엔 data가 같이 입력되기 때문에 입력된 데이터를 integer로 바꿔줌
					push(num);
					break;
				}
				case "pop":{
					pop();
					break;
				}
				case "size":{
					size();
					break;
				}
				case "empty":{
					empty();
					break;
				}
				case "front":{
					front();
					break;
				}
				case "back":{
					back();
					break;
				}
					
			}
		}
	}

}
