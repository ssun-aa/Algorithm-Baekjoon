package test;

import java.util.Arrays;
import java.util.Scanner;

public class boj2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarf = new int[9];//난쟁이 9명
        int sum = 0;
        boolean flag = false;
        for(int i=0; i<9; i++){
            dwarf[i] = sc.nextInt();
            sum+= dwarf[i];//난쟁이 9명 키 총 합
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(i==j)
                    continue;
                if(sum - dwarf[i] - dwarf[j] == 100) {//난쟁이 두마리의 키 제외한 합이 100일 경우
                    dwarf[i] = 0;//해당 난쟁이 키를 0으로 만듦
                    dwarf[j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        Arrays.sort(dwarf);//오름차순으로 정렬 후
        for(int i : dwarf) {
            if(i != 0)//0이 아닐경우에만 출력
                System.out.println(i);
        }
    }

}
