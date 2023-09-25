package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main{
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int M;
	static int K;
	static int[][] g;
	static int cnt;
	
	static void dfs(int x, int y) {
		g[x][y] = 1;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < M && ny >= 0 && ny < N && g[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
		
	}
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        g = new int[M][N];
        while(K-->0) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            
            for(int i=y1; i<=y2; i++) {
                for (int j=x1; j<=x2; j++) {
                    g[i][j] = 1;			//직사각형 표시
                }
            }
         }   
        List<Integer> list = new ArrayList<>();	//영역 넓이를 오름차순으로 출력하기 위한 list
            
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		if(g[i][j] == 0) {
        			cnt = 0;
           			dfs(i, j);
           			list.add(cnt);
           		}
           	}
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) sb.append(list.get(i)).append(" ");
        
        System.out.println(sb);
    }

}