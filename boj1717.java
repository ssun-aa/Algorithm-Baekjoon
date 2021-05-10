package test;
import java.util.Scanner;

public class boj1717 {
	static int n;
	static int parents[];
	
	public static int getParent(int x) {
		if(parents[x] == x) 
			return x;
		else 
			return parents[x] = getParent(parents[x]);
	}
	public static void connect(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a != b)
			parents[b] = a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		parents = new int[n+1];
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();//연산자 입력
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(x == 0)//연산자가 0이면 합집합
				connect(a,b);
			else {//연산자 1이면 같은 집합인지 확인
				if(getParent(a) == getParent(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		sc.close();
	}
}
