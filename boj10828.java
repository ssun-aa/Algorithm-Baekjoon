package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10828 {
	
	static int size= 0;
	static int[] stack;

	public static void push(int number) {
		stack[size] = number;//배열에 숫자 삽입
		size++;//배열 인덱스 증가
	}
	
	public static void pop() {
		if(size==0)//배열에 data가 없을 경우
			System.out.println("-1");
		else {//배열에 data가 있는 경우
			System.out.println(stack[size-1]);
			size--;//배열 인덱스 감소
		}
	}

	public static void size() {
		System.out.println(size);
	}

	public static void empty() {
		if(size==0)//배열에 data가 없을 경우
			System.out.println("1");
		else//배열에 data가 있는 경우
			System.out.println("0");
	}
	
	public static void top() {
		if(size==0)//배열에 data가 없을 경우
			System.out.println("-1");
		else//배열에 data가 있는 경우
			System.out.println(stack[size-1]);
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner의 경우 시간이 오래걸리기 때문에 BufferReader를 이용

		int n = Integer.parseInt(br.readLine());//readLine은 String 타입이라 integer로 변경
		stack = new int[n];//명령어 수만큼 배열 생성
		
		for(int i=0; i<n; i++) {
			String Line = br.readLine();//명령어(+data) 입력
			String[] order = Line.split(" ");//공백을 기준으로 명령어와 data 구분
			
			switch (order[0]) {//명령어에 따라 실행될 switch문
				case "push": {
					int number = Integer.parseInt(order[1]);
					//push의 경우엔 data가 같이 입력되기 때문에 입력된 데이터를 integer로 바꿔줌
					push(number);
					break;
				}
				case "pop": {
					pop();
					break;
				}
				case "size": {
					size();
					break;
				}
				case "empty": {
					empty();
					break;
				}
				case "top": {
					top();
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + order);
				}
		}
	}

}
