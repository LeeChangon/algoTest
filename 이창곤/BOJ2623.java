package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N+1];	//N명의 pd수와 가변적인 담당 가수 수 때문에 어레이리스트 배열 선언
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();	//어레이리스트 초기화
		}
		
		int[] ind = new int[N + 1];			//진입차수

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			for (int i=0; i<num-1; i++) {
				int b = Integer.parseInt(st.nextToken());
				ind[b]++;				//진입차수를 증가시키고
				list[a].add(b);			//간선의 방향을 저장
				a = b;					
			}
		}

		for (int i=1; i< N+1; i++) {
			if (ind[i] == 0) q.add(i);	//진입차수가 0인 정점을 q에 넣는다
		}
		
		int cnt = 0; //사이클이 생겨 순서를 완성할 수 없는지 체크

		while (!q.isEmpty()) {	//위상정렬
			int a = q.poll();
			sb.append(a).append("\n");
			cnt++;
			
			for(int i=0; i<list[a].size(); i++) {
				int b = list[a].get(i);
				ind[b]--;
				if(ind[b] == 0) q.add(b);
			}
		}
		
		if(cnt == N) System.out.println(sb);			//완성됐다면 출력 아니면 0 출력
		else System.out.println(0);
	}
}