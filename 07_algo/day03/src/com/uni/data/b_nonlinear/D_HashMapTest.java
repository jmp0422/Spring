package com.uni.data.b_nonlinear;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class D_HashMapTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("apple", 0);
		map.put("melon", 0);
		map.put("ice", 2);
		int value = map.get("ice") + 1;
		map.put("ice", value);
		map.put("ice", map.getOrDefault("ice", 0) + 1);  //if 문과 위두줄을 한줄로 끝낼수있는것, 
		map.put("ice2", map.getOrDefault("ice2", 0) + 1);
		System.out.println(map);
		System.out.println(map.get("ice")); //map.get(key)
		
		Set keys = map.keySet(); //키목록 
		for (Object k : keys) {
			System.out.println(map.get(k));
		}
		
		Set<Entry<String, Integer>> entryList = map.entrySet(); //{키:값} --> Entry(엔트리)
		for (Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
