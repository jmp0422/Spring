package com.multi.a_liner.a_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class practice {
    public static void main(String[] args) {
        String[] food = {"apple","apple","apple","banana","banana","melon","melon","berry"};
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for(String x : food){
            if(!stack1.contains(x)){
                stack1.push(x);
            }else{
                stack2.push(x);
            }
        }
        System.out.println("중복제거 후 음식목록 >>" + stack1);
        System.out.println("중복 된 음식목록 >>" + stack2);
        System.out.println("");

        String[] wait = {"홍","김","송","정","박","이"};
        Queue<String> queue = new LinkedList<>();
        for(String x : wait) {
            queue.add(x);
        }
        System.out.println(queue);
        queue.remove();
        queue.remove();
        queue.add(queue.remove());
        System.out.println(queue);
        System.out.println("");
        queue.remove();
        queue.add(queue.remove());
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
