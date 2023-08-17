package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3109 {
	static char[][] board;
	static int r;
	static int c;
	static int[] dx= {-1,0,1};
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = bReader.readLine().split(" ");
		r= Integer.parseInt(rc[0]);
		c= Integer.parseInt(rc[1]);
		board = new char[r][];
		for(int i=0;i<r;i++) {
			board[i] = bReader.readLine().toCharArray();
		}
		for(int i=0;i<r;i++) {
			find(i,0);
		}
		System.out.println(answer);
	}
	public static boolean find(int i,int j) {
		if(j==c-1) {
			answer++;
			return true;
		}
		boolean flag = false;
		for(int d=0;d<3;d++) {
			int nx = i+dx[d];
			if(nx<0 || nx>=r) continue;
			if(board[nx][j+1]!='.') continue;
			board[nx][j+1] = 'x';
			flag = find(nx, j+1);
			if(flag) {
				return flag;
			}
		}
		return flag;
	}
}