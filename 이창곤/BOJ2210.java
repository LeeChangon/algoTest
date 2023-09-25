package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static Set<String> set;

    static void dfs(String s, int x, int y) {
    	if(s.length() == 6) {
    		set.add(s);
    		return;
    	}
    	else s += arr[x][y];
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
    			dfs(s, nx, ny);
    		}
    	}
    	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        set = new HashSet<>();
        arr = new int[5][5];

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs("", i, j);
            }
        }
        
        System.out.println(set.size());
    }
}