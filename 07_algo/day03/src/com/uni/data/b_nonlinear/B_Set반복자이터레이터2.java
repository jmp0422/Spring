package com.uni.data.b_nonlinear;

import java.util.HashSet;
import java.util.Iterator;

public class B_Set반복자이터레이터2 {

	public static void main(String[] args) {
		//일주일간 받았던 용돈(월~일)
		//1000, 2000, 3000, 2000, 4000, 2000, 3000
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1000);
		set.add(2000);
		set.add(3000);
		set.add(2000);
		set.add(4000);
		set.add(2000);
		set.add(3000);
		System.out.println(set);




		//일주일간 받았던 용돈 중에서 
		//얼마씩 받았는지 하나씩 전체 프린트
		//1000, 2000, 3000, 4000
		Iterator<Integer> it = set.iterator();
		for(int i=0; i<set.size(); i++){
			if(it.hasNext()){
				int x = it.next();
				System.out.println(x);
			}
		}
		System.out.println("");
		Object[] list = set.toArray();
		for(Object x : list){
			System.out.println(x);
		}
	}
}
