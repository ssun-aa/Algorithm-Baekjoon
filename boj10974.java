package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10974 {
    static boolean visit[];//방문 확인
    static int n;
    static int array[];//순열 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        array = new int[n];

        func(0,array);
    }
    public static void func(int cnt, int array[]){

        if(cnt == n){//n만큼 반복했으면
            for(int i=0; i<n; i++) {
                System.out.print(array[i] + " ");//저장된 순열 출력
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){//방문한 적 없으면
                visit[i] = true;//방문 표시
                array[cnt] = i+1;//순열에 +1해서 저장
                func(cnt+1, array);//순열길이 n만큼 반복
                visit[i] = false;
            }
        }
    }
}
