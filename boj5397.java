package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer result;//최종 결과
		Stack<Character> left, right;//커서를 기준으로 왼쪽 오른쪽으로 나눔
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			left = new Stack<Character>();
			right = new Stack<Character>();
			result = new StringBuffer();
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				switch (line.charAt(j)) {
				case '<': {//커서 왼쪽으로 이동
					if(!left.isEmpty())//왼쪽 스택 pop해서 오른쪽 스택에 push하기
						right.push(left.pop());
					break;
				}
				case '>': {//커서 오른쪽으로 이동
					if(!right.isEmpty())//오른쪽 스택 pop해서 왼쪽 스택에 push하기
						left.push(right.pop());
					break;
				}
				case '-': {//커서 왼쪽 값 삭제
					if(!left.isEmpty())
						left.pop();
					break;
				}
				default: //왼쪽 스택에 삽입
					left.push(line.charAt(j));
				}
			}
			for(Character j : left)//왼쪽 스택은 정방향이라서 바로 append
				result.append(j);
			while(!right.isEmpty())//오른쪽 스택은 역방향이라 pop해서 append
				result.append(right.pop());
			System.out.println(result);
		}
	}
}
