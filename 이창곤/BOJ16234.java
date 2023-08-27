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
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N, L, R;
	static int[][] map, tmp;
	static boolean[][] visit;
	static boolean flg;
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		visit[x][y] = true;
		int cnt = 1;
		int sameCnt = 1;
		int sum = map[x][y];
		q.add(new Node(x, y));
		list.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int df = Math.abs(map[nx][ny] - map[node.x][node.y]);
					if(L <= df && df <= R && !visit[nx][ny]) {
						visit[nx][ny] = true;
						cnt++;
						if(map[node.x][node.y] == map[nx][ny]) sameCnt ++;
						if(cnt != sameCnt) flg = true;
						sum += map[nx][ny];
						
						q .add(new Node(nx, ny));
						list.add(new Node(nx, ny));
					}
				}
			}
		}

		if(list.size() == 0) return;
		
		for(int i=0; i<list.size(); i++) {
			Node n = list.get(i);
			map[n.x][n.y] = sum / cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		flg = true;
		
		while(flg) {
			flg = false;
			visit = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) 
						bfs(i, j);
				}
			}
			if(flg) day++;
		}

		System.out.println(day);
	}
}