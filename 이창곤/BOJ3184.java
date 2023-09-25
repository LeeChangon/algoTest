package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean[][] visit;
	
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
		
		visit[x][y] = true;
		q.add(new Node(x, y));
		
		int s = 0;
		int w = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(map[node.x][node.y] == 'o') s++;
			else if(map[node.x][node.y] == 'v') w++;
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(visit[nx][ny] || map[nx][ny] == '#') continue;
					
					visit[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		
		if(w >= s) s = 0;
		else w = 0;
		
		wolf += w;
		sheep += s;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		wolf = 0;
		sheep = 0;
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != '#' && !visit[i][j])
					bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}
}