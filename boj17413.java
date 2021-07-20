package test;

import java.util.*;

public class boj17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();//역순으로 출력하기 위함
        boolean in = false;//괄호 안 밖 체크
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '<') {//여는 괄호 
               in = true;//괄호 안
               while(!stack.isEmpty())//스택 비워질때까지
                   System.out.print(stack.pop());//출력
               System.out.print(s.charAt(i));//여는 괄호 출력
            }
            else if(s.charAt(i) == '>') {//닫는 괄호
                in = false;//괄호 밖
                System.out.print(s.charAt(i));//닫는 괄호 출력
            }
            else if(in){//괄호 안
                System.out.print(s.charAt(i));//정순으로 출력
            }
            else if(!in){//괄호 밖
                if(s.charAt(i) == ' '){//공백이면
                    while (!stack.isEmpty())//이전 단어 역순으로 출력
                        System.out.print(stack.pop());
                    System.out.print(s.charAt(i));//공백 출력
                }
                else{//알파벳이면
                    stack.push(s.charAt(i));//역순 출력을 위해 스택에 저장
                }
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
}
