package test;
import java.util.*;
public class boj10773 {
    public static void main(String[] args) {
        Stack<Integer> que = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num == 0)
                que.pop();
            else
                que.add(num);
        }
        while(!que.isEmpty()){
            sum+=que.pop();
        }
        System.out.println(sum);
    }
}
