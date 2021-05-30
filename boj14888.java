package test;

import java.util.Scanner;

public class boj14888 {
    static int n;
    static int num[];
    static int operator[] = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num= new int[n];

        for(int i=0; i<n; i++){//숫자 입력
            num[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){//연산자 입력
            operator[i] = sc.nextInt();
        }
        calculator(1,num[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void calculator(int cnt, int sum){
        if(cnt == n){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }
        for(int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if(i==0)//덧셈
                    calculator(cnt + 1, sum + num[cnt]);
                else if(i==1)//뺄셈
                    calculator(cnt + 1, sum - num[cnt]);
                else if(i==2)//곱셈
                    calculator(cnt + 1, sum * num[cnt]);
                else if(i==3) {//나눗셈
                    calculator(cnt + 1, sum / num[cnt]);
                }
                operator[i]++;
            }
        }
    }
}
