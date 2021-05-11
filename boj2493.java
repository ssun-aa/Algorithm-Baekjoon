package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
class Tower{//탑의 순서, 높이 저장
	int index;
	int hight;
	
	public Tower(int index, int hight) {
		this.index = index;
		this.hight = hight;
	}
}
public class boj2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Tower> st = new Stack<Tower>();
		
		String Line = br.readLine();
		String tokens[] = Line.split(" ");//공백을 기준으로 나눔
		
		for(int i=0; i<n; i++) {
			int p = Integer.parseInt(tokens[i]);
			while(!st.isEmpty()) {//스택이 비어있지 않으면 비교해서 출력
				if(st.peek().hight > p) {
					System.out.print(st.peek().index+" ");
					break;
				}
				st.pop();
			}
			if(st.isEmpty()) {//스택이 비어있으면
				System.out.print("0 ");//0 출력
			}
			st.push(new Tower(i+1, p));//스택에 탑 삽입
		}
	}
}
