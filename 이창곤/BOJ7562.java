package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-2, -1, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-1, -2, 1, 2, -2, -1, 1, 2};
	static int n, tx, ty, result;
	static int[][] board;
	
	static class Node {
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		visit[x][y] = true;
		q.add(new Node(x, y, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.x == tx && node.y == ty) {
				result = node.cnt;
				return;
			}
			
			for(int i=0; i<8; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Node(nx, ny, node.cnt+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());		//현재 좌표
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			tx = Integer.parseInt(st.nextToken());		//목표 좌표
			ty = Integer.parseInt(st.nextToken());
			
			bfs(sx, sy);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
