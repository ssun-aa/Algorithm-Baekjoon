package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            PriorityQueue<Integer> Minque = new PriorityQueue<>();
            PriorityQueue<Integer> Maxque = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int j=0; j<n; j++){
                String st[] = br.readLine().split(" ");
                char order = st[0].charAt(0);
                int number = Integer.parseInt(st[1]);
                if(order == 'I'){
                    map.put(number, map.getOrDefault(number,0) + 1);
                    Minque.add(number);
                    Maxque.add(number);
                }
                else{
                    if(map.size() == 0)
                        continue;
                    PriorityQueue<Integer> que = number == 1 ? Maxque : Minque;
                    remove(que, map);
                }
            }
            if(map.size() == 0)
                System.out.println("EMPTY");
            else{
                int x = remove(Maxque, map);
                System.out.println(x + " " + (map.size() > 0 ? remove(Minque, map) : x));
            }
        }
    }
    static int remove(PriorityQueue<Integer> que, Map<Integer,Integer> map){
        int num;
        while(true){
            num = que.poll();
            int status = map.getOrDefault(num, 0);
            if(status == 0)
                continue;
            if(status == 1)
                map.remove(num);
            else
                map.put(num, status - 1);
            break;
        }
        return num;
    }
}
