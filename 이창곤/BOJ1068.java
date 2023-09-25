package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int cnt;
	static int[] tree;
	static boolean[] visit;
	
	static void check(int node) {
		boolean flg = false;
		
		for(int i=0; i< tree.length; i++) {
			if(!visit[i] && tree[i] == node) {
				visit[i] = true;
				flg = true;
				check(i);				
			}
		}
		if(!flg) {
			cnt++;
			return;
		}
	}
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        tree = new int[n];
        visit = new boolean[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	 tree[i] = Integer.parseInt(st.nextToken());
        }
        visit[Integer.parseInt(br.readLine())] = true;
        
        cnt = 0;
        for(int i=0; i<n; i++) {
        	if(tree[i] == -1 && !visit[i]) check(i);
        }
        System.out.println(cnt);
	}
}
