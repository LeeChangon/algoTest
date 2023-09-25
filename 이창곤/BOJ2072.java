package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};	//상하 좌우 \ /
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static int result;
    static int[][] board;
    

    static class Node {
    	int x;
    	int y;
    	public Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    	
    static void bfs(int x, int y, int color, int direction, int num) {
    	Queue<Node> q = new LinkedList<>();
    	boolean[][] visit = new boolean[20][20];
    	int cnt = 1;
    	
    	visit[x][y] = true;
    	q.add(new Node(x, y));
    	
    	while(!q.isEmpty()){
    		Node node = q.poll();
    		for(int i=direction; i<=direction+1; i++) {			//한쪽 방향으로만 bfs
    			int nx = node.x + dx[i];
    			int ny = node.y + dy[i];
    			
    			if(nx >= 1 && nx < 20 && ny >= 1 && ny < 20) {
    				if(!visit[nx][ny] && board[nx][ny] == color) {
    					cnt++;
    					visit[nx][ny] = true;
    					q.add(new Node(nx, ny));
    				}
    			}
    		}
    	}
    	
    	if(cnt == 5) result = num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[20][20];
        result = -1;

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	int color = i % 2 + 1;
        	
        	board[x][y] = color;
        	if(i >= 9 && result == -1) {	//최소한 흑이 5개를 놓았을 때
        		bfs(x, y, color, 0, i);		//4방향으로 bfs
        		bfs(x, y, color, 2, i);
        		bfs(x, y, color, 4, i);
        		bfs(x, y, color, 6, i);
        		//if(result != -1) break;
        	}
        }
        System.out.println(result);
    }
}