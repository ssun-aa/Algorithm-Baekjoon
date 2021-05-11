package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
class Tower{//ž�� ����, ���� ����
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
		String tokens[] = Line.split(" ");//������ �������� ����
		
		for(int i=0; i<n; i++) {
			int p = Integer.parseInt(tokens[i]);
			while(!st.isEmpty()) {//������ ������� ������ ���ؼ� ���
				if(st.peek().hight > p) {
					System.out.print(st.peek().index+" ");
					break;
				}
				st.pop();
			}
			if(st.isEmpty()) {//������ ���������
				System.out.print("0 ");//0 ���
			}
			st.push(new Tower(i+1, p));//���ÿ� ž ����
		}
	}
}
