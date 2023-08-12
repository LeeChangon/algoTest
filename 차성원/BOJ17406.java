package algoTest.차성원;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
    static int N;
    static int M;
    static int k;
    static int[][] board;
    static int[][] oper;
    static boolean[] visit;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board=new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        oper = new int[k][3];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            oper[i][0] = Integer.parseInt(st.nextToken())-1;
            oper[i][1] = Integer.parseInt(st.nextToken())-1;
            oper[i][2] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[k];
        permu(0);
        System.out.println(answer);
    }
    public static void permu(int dep){
        if(dep==k){
            ans();
            return;
        }
        for(int i=0;i<k;i++){
            if(visit[i]) continue;
            visit[i]=true;
            rotate(oper[i][0],oper[i][1],oper[i][2],1);
            permu(dep+1);
            rotate(oper[i][0],oper[i][1],oper[i][2],-1);
            visit[i]=false;
        }
    }
    public static void ans(){
        for(int i=0; i<N;i++){
            int sum=0;
            for(int j=0;j<M;j++){
                sum+=board[i][j];
            }
            answer = answer<sum?answer:sum;
        }
    }
    public static void rotate(int r,int c,int s,int type){
        for(int level=s;level>0;level--){
            int x = r-level;
            int y = c-level;
            int d=0;
            if(type==-1){
                d=1;
            }
            int tmp = board[x][y];
            int nx=0;
            int ny=0;
            while(true){
                nx = x+dx[d];
                ny = y+dy[d];
                if(nx==r-level && ny==c-level){
                    board[nx-dx[d]][ny-dy[d]] = tmp;
                    break;
                }
                if(nx<r-level || nx >r+level || ny<c-level || ny > c+level){
                    d+=type;
                    if(d<0) d=3;
                    continue;
                }
                x=nx;
                y=ny;
                board[x-dx[d]][y-dy[d]] = board[x][y];
            }
        }
    }
}
