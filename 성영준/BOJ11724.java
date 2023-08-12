package 성영준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ11724 {
	static int cnt;
	static boolean[][] graphs;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graphs = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		cnt = 0;
		for (int tc = 1; tc <= m; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graphs[a][b] = true;
			graphs[b][a] = true;
		}
		
		for(int v = 1; v < n + 1; v++)
			if(visited[v] == false)
				bfs(v);
		
		System.out.println(cnt);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i = 1; i < graphs.length; i++) {
				if(graphs[node][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		cnt++;
	}
}
