package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj5430 {
	static StringBuffer sb;
	public static void print(boolean notReverse, ArrayDeque<Integer> deque) {
		sb = new StringBuffer();
		sb.append('[');
		if(deque.size()>0) {//배열 안에 출력할 원소가 있으면
			if(notReverse) {//정방향
				while(!deque.isEmpty()) {//배열이 비어질 때까지 
					sb.append(deque.poll()).append(',');//원소 삭제 후, sb에 추가, ','도 같이 추가
				}
			}
			else {//역방향
				while(!deque.isEmpty()) {//배열이 비어질 때까지
					sb.append(deque.pollLast()).append(',');//원소 삭제 후, sb에 추가
				}
			}
			sb.deleteCharAt(sb.length()-1);//마지막 원소 뒤에 붙은 ',' 삭제
		}
		sb.append(']');
		System.out.println(sb);
	}
	public static void AC(String p, ArrayDeque<Integer> deque) {
		boolean error = false;//Error 판별
		boolean notReverse = true;//정방향

		for(int i=0; i<p.length(); i++) {
			switch(p.charAt(i)) {//함수에 따라 실행
				case 'R':{//뒤집기 함수
					notReverse = !notReverse;//방향 바꾸기
					break;
				}
				case 'D':{//첫번째 원소 버리는 함수
					if(deque.size()==0) {//deque 사이즈 0 이면
						error = true;//에러
						break;
					}
					else {
						if(notReverse)//정방향이면
							deque.pollFirst();//맨 앞 원소 삭제
						else//역방향이면
							deque.pollLast();//맨 뒤 원소 삭제
						break;
					}
				}
			}
			if(error) {//error가 true 이면
				System.out.println("error");//에러 출력
				return;
			}
		}
		print(notReverse, deque);//error가 아니면 배열 안의 원소 출력하는 함수 호출
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());//testcase 개수
		
		while(t-- > 0) {
			
			String p = br.readLine();//실행할 함수 입력
			int n = Integer.parseInt(br.readLine());//배열 안 데이터 수 입력
			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
					
			st = new StringTokenizer(br.readLine(),"[],");//입력된 배열을 '['과 ']'과 ','를 기준으로 나누어 저장
														  //배열 안의 데이터만 저장
			for(int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));//배열 안의 데이터 deque에 삽입
			}
			AC(p, deque);
		}
	}

}
