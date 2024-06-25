package com.multi.a_liner.a_stack;

import java.util.Stack;

public class A_StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		//stack == 누적하다, 쌓다, 적재 
		stack.add("홍길동");
		stack.add("김길동");
		stack.add("송길동");
		stack.push("정길동");
		System.out.println(stack); //toString()재정의
		System.out.println(stack.get(0)); //홍길동
		System.out.println(stack.contains("홍길동"));
		System.out.println(stack.peek()); //맨위 요소출력
		stack.pop(); //맨위 요소를 제거하고 해당요소반환
		System.out.println(stack.empty());  //스택이 비어있는지확인
		System.out.println(stack);
		
	}



}

