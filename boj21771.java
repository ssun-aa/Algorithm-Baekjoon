package test;

import java.util.Scanner;

public class boj21771 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int rg = sc.nextInt();
        int cg = sc.nextInt();
        int rp = sc.nextInt();
        int cp = sc.nextInt();
        sc.nextLine();
        int pNum = 0;
        for(int i=0; i<r; i++){
            String st = sc.nextLine();
            if(!st.contains("P")) {//P 미포함 문장이면
                continue;//넘어가기
            }
            //P포함 문장이면
            String li = st.replaceAll("P","");
            //P를 없애고 나머지 문자를 li에 저장
            pNum += c - li.length();//가로길이 - 나머지 문자 = P의 개수
        }
        if(pNum != cp*rp)//P의 개수가 P가로 * P세로와 같지 않으면
            System.out.println(1);//P사이에 G가 들어있으므로 1출력
        else
            System.out.println(0);
    }
}