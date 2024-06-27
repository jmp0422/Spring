package com.multi.data.c_검색;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11724
public class E_연결요소의개수_백준 {
	// 인접 리스트를 저장할 ArrayList 배열
	static ArrayList<Integer>[] A;
	// 방문 여부를 저장할 boolean 배열
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// 테스트 케이스 목록
		List<String> testCases = Arrays.asList(
				"6 5\n1 2\n2 5\n5 1\n3 4\n4 6",
				"6 8\n1 2\n2 5\n5 1\n3 4\n4 6\n5 4\n2 4\n2 3"
		);

		for (String data : testCases) {
			// 값을 자동으로 넣어주기 위한 코드
			InputStream is = new ByteArrayInputStream(data.getBytes());
			System.setIn(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// 정점의 수와 간선의 수 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 인접 리스트와 방문 배열 초기화
			A = new ArrayList[n + 1];
			visited = new boolean[n + 1];

			// 각 정점에 대한 인접 리스트 초기화
			for (int i = 1; i <= n; i++) {
				A[i] = new ArrayList<Integer>();
			}

			// 간선 정보 입력받아 인접 리스트에 추가
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				A[s].add(e);
				A[e].add(s); // 양방향 간선 추가
			}

			// 연결 요소의 개수 계산
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					DFS(i);
					count++;  // DFS가 실행될 때마다 카운트 증가
				}
			}

			System.out.println(count);  // 연결 요소의 수 출력
		}
	}

	// DFS 함수
	static void DFS(int s) {
		visited[s] = true;
		for (int node : A[s]) { // 각 A 에 들어있는 각 노드를 방문했는지 확인
			if (!visited[node]) {
				DFS(node);
			}
		}
	}
}
