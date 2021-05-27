package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2529 {
    static int n;
    static String arr[];//부등호
    static boolean visit[];//숫자 중복 방지
    static int num[];//생성된 숫자
    static Deque<String> que = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());//부등호 개수

        visit = new boolean[10];//0~9까지 숫자 방문 확인
        num = new int[n+1];//생설될 숫자

        String str = br.readLine();
        arr = str.split(" ");//부등호 저장

        func(0);

        System.out.println(que.getLast());//최대값
        System.out.println(que.getFirst());//최소값
    }
    public static void func(int cnt){
        if(cnt == n+1){//부등호 개수 +1 만큼 숫자 생성했으면
            String x = "";
            for(int i=0; i<num.length; i++){
                x += num[i];//String 타입으로 숫자 생성
            }
            if(check(x)){//부등호와 일치하는지 체크
                que.add(x);//일치하면 que에 add
                return;
            }
            return;
        }
        for(int i=0; i<=9; i++) {
            if(!visit[i]){
                visit[i] = true;
                num[cnt] = i;
                func(cnt+1);
                visit[i] = false;
            }
        }
    }
    public static boolean check(String num){//부등호와 일치하는지 체크

        for(int i = 0; i<arr.length; i++){//부등호 개수만큼 반복
            if(arr[i].equals("<")){
                if(num.charAt(i) > num.charAt(i+1)){
                    return false;
                }
            }
            else{
                if(num.charAt(i) < num.charAt(i+1)){
                    return false;
                }
            }
        }
        return true;
    }
}
