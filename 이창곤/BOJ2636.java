package algo;

import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M, time, cheeseCnt;
	static boolean flg;
	static int[][] map;
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		Queue<Node> cheeseQ = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		
		visit[0][0] = true;
		q.add(new Node(0, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					if(map[nx][ny] == 1) {
						visit[nx][ny] = true;
						cheeseQ.add(new Node(nx, ny));
					}
					else if(map[nx][ny] == 0) {
						visit[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
			}
		}
		if(cheeseCnt - cheeseQ.size() == 0) {
			flg = false;
			return;
		}
		else {
			cheeseCnt -= cheeseQ.size();
			time++;
		}
		
		while(!cheeseQ.isEmpty()){
			Node node = cheeseQ.poll();
			map[node.x][node.y] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheeseCnt = 0;
		flg = true;
		time = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeseCnt++;
			}
		}
		
		while(flg) {
			bfs();
		}
		
		System.out.println(time);
		System.out.println(cheeseCnt);
	}
}