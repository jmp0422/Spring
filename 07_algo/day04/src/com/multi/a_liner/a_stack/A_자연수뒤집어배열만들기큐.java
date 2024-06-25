package com.multi.a_liner.a_stack;

import java.util.LinkedList;
import java.util.Queue;

public class A_자연수뒤집어배열만들기큐 {
    public static void main(String[] args) {

        int[] n = {1, 2, 3, 4, 5};

        String[] s = String.valueOf(n).split("");
        int[] answer = new int[s.length];

        Queue<String> queue = new LinkedList<>();
        for (String x : s) {
            queue.add(x);
        }


        for (int i = s.length-1; i >= 0; i--) {
            answer[i] = Integer.parseInt(queue.element());
        }


    }
}
