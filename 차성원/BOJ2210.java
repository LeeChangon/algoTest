package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ2210 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] board= new String[5][5];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            board[i] = br.readLine().split(" ");
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                dfs(i,j,0,board[i][j]);
            }
        }
        System.out.println(set.size());
    }
    public static void dfs(int i,int j,int dep,String s){
        if(dep==5){
            set.add(s);
            return;
        }
        for(int d=0;d<4;d++){
            int nx = i+dx[d];
            int ny = j+dy[d];
            if(nx<0 || nx>4 || ny <0 || ny>4) continue;
            dfs(nx,ny,dep+1,s+board[nx][ny]);
        }
    }
}
