package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visit;
	
	
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y= y;
		}
	}
	
	static int bfs(int x, int y) {
		int cnt = 0;
		
		Queue<Node> q = new LinkedList<>();
		visit[x][y] = true;
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			cnt ++;
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && arr[nx][ny] == 1) {
					visit[nx][ny] = true;
					
					q.offer(new Node(nx, ny));
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int maxPaint = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m;j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					maxPaint = Math.max(bfs(i, j), maxPaint);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxPaint);
		
	}
}

