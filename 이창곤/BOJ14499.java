import java.io.*;
import java.util.*;

class Main {
	static int[] dx = {0, 0, -1, 1}; //동 서 북 남
	static int[] dy = {1, -1, 0, 0};
	static int N, M, x, y;
	static int[][] map, dice;	
	
	static void move(int dir) {
		int tmp = dice[1][1];
		switch(dir) {
		case 1:
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = tmp;
			break;
		case 2:
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = tmp;
			break;
		case 3:
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = dice[0][1];
			dice[0][1] = tmp;
			break;
		case 4:
			dice[1][1] = dice[0][1];
			dice[0][1] = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = tmp;
			break;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dice = new int[4][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());			
		}
		
		StringTokenizer move = new StringTokenizer(br.readLine());
		
		while(K-->0) {
			int dir = Integer.parseInt(move.nextToken());
			int nx = x + dx[dir-1];
			int ny = y + dy[dir-1];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				move(dir);
				if(map[nx][ny] != 0) {
					dice[3][1] = map[nx][ny];
					map[nx][ny] = 0;
				}
				else map[nx][ny] = dice[3][1];
				x = nx;
				y = ny;
				
				sb.append(dice[1][1]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
}
