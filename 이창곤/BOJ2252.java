package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] g;
	static int[] dgin;
	static int N;
	static int M;
	static StringBuilder sb;
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<dgin.length; i++) {
			if(dgin[i] == 0) { //진입차수가 0이면
				q.add(i);
				dgin[i] -= 1;
			}
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(" ");
			
			for(int i=0; i<M; i++) {
				if(g[0][i] == a)
					dgin[g[1][i]] -= 1;
			}
			for(int i=1; i<N+1; i++) {
				if(dgin[i] == 0) {
					q.add(i);
					dgin[i] -= 1;
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        g = new int[2][M];
        dgin = new int[N+1]; //진입차수
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	dgin[b] += 1;
        	g[0][i] = a;
        	g[1][i] = b;
        }
        topologySort();
	}
}
