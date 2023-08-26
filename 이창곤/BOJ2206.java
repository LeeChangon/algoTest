package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	static int[][] map;
	
	static class Node{
		int x;
		int y;
		int cnt;
		int flg;	//벽을 부쉈는지 
		
		public Node(int x, int y, int cnt, int flg) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.flg = flg;
		}
	}
	
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visit = new boolean[N][M][2];	//벽을 부순 visit과 아닌 visit 을 구분하기 위해

		visit[0][0][0] = true;	//0은 벽을 부수지 않은 상태
		visit[0][0][1] = true;	//1은 벽을 부순 상태
		q.add(new Node(0, 0, 1, 0));
		
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.x == N-1 && node.y == M-1) return node.cnt;	//목적지에 도착하면 리턴
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {	
					if(map[nx][ny] == 0 && !visit[nx][ny][node.flg]) {	//벽이 아니라면 flg에 따른 visit에 방문 표시
						visit[nx][ny][node.flg] = true;
						q.add(new Node(nx, ny, node.cnt+1, node.flg));
					}
					else if(map[nx][ny] == 1 && node.flg == 0 && !visit[nx][ny][1]) {
						visit[nx][ny][1] = true;
						q.add(new Node(nx, ny, node.cnt+1, 1));		//벽이라면 flg가 0일 때 벽을 파고 이동하고 flg를 1로 바꿔줌
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		System.out.println(bfs());
	}
	
}

/* dfs
class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int N, M, result;
	static int[][] map;
	static boolean[][] visit;
	
	
	static void dfs(int x, int y, int cnt, boolean flg) {
		if(x == N - 1 && y == M - 1) {
			if(result == -1) result = cnt;
			else result = Math.min(result, cnt);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(map[nx][ny] == 0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, cnt + 1, flg);
					visit[nx][ny] = false;
				}
				else if(map[nx][ny] == 1 && flg && !visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, cnt + 1, false);
					visit[nx][ny] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		result = -1;
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
//				System.out.println(map[i][j]);
			}
		}
		
		dfs(0, 0, 1, true);
		
		System.out.println(result);
	}
}
*/