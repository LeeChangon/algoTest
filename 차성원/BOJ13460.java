package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13460 {
    static char[][] board;
    static int n;
    static int m;
    static Point goal;
    static int[] dx={0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        board = new char[n][];
        Point blue = null;
        Point red = null;
        for(int i=0;i<n;i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B')
                    blue = new Point(i, j);
                else if (board[i][j] == 'R')
                    red = new Point(i, j);
                else if (board[i][j] == 'O')
                    goal = new Point(i, j);
            }
        }
        Queue<Balls> queue = new LinkedList<>();
        Set<Balls> set = new HashSet<>();
        Balls first =new Balls(blue,red,0);
        set.add(first);
        queue.add(first);
        int answer = -1;
        ans:
        while(!queue.isEmpty()) {
            Balls now = queue.poll();
            if(now.move>=10) break;
            next:
            for (int d = 0; d < 4; d++) {
                Point r = now.red;
                int x = r.x;
                int y=r.y;
                boolean ans=false;
                int redMove=0;
                while(true){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx== goal.x && ny == goal.y){
                        ans = true;
                        break;
                    }else if(board[nx][ny]=='#'){
                        break;
                    }
                    x=nx;
                    y=ny;
                    redMove++;
                }
                r= new Point(x,y);

                Point b = now.blue;
                x = b.x;
                y=b.y;
                int blueMove=0;
                while(true){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx== goal.x && ny == goal.y){
                        continue next;
                    }else if(board[nx][ny]=='#'){
                        break;
                    }
                    x=nx;
                    y=ny;
                    blueMove++;
                }
                b= new Point(x,y);
                if(ans){
                    answer=now.move+1;;
                    break ans;
                }
                if(r.equals(b)){
                    if(redMove>blueMove){
                        r = new Point(r.x-dx[d],r.y-dy[d]);
                    }else {
                        b = new Point(b.x-dx[d],b.y-dy[d]);
                    }
                }
                Balls next = new Balls(b,r, now.move+1);
                if(set.contains(next))
                    continue;
                set.add(next);
                queue.add(next);
            }
        }
        System.out.println(answer);
    }

    static class Balls{
        Point blue;
        Point red;
        int move;
        public Balls(Point blue,Point red,int move){
            this.blue=blue;
            this.red=red;
            this.move = move;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Balls balls = (Balls) o;
            return blue.equals(balls.blue) && red.equals(balls.red);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blue, red);
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
