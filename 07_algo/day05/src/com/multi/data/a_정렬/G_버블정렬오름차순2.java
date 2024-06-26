package com.multi.data.a_정렬;

import java.util.Arrays;

public class G_버블정렬오름차순2 {

	public static void main(String[] args) {
		long n = 642135;
		String s = String.valueOf(n);
		char[] array = s.toCharArray();
		char temp = ' '; // 교환용 임시 변수

		//구현
		for(int i=array.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(array[j]>array[j+1]) { //i 가아닌 j를 써야하는이유는 i는 한바퀴밖에 안돔
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					System.out.println(Arrays.toString(array));
				}


			}

		}

		System.out.println(Arrays.toString(array)); 
	}

}
