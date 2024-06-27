package com.multi.data.c_검색;

import java.util.Arrays;
import java.util.Scanner;

public class B_수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = {1, 25, 3, 10, 5, 9, 10, 19, 18, 2156};

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println("찾는 수 입력해주세요");
        int ky = sc.nextInt();
        int idx = Arrays.binarySearch(A, ky);

        if(idx < 0){
            System.out.println("없는수입니다");
        }else{
            System.out.println(ky + "는 " + idx + "번인덱스에 있습니다.");
        }



    }
}
