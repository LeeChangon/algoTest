package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
	static int n;
	static int m;
	static List<Point> houses;
	static List<Point> chicken;
	static boolean[] check;
	static int answer=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		houses = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					houses.add(new Point(i, j));
				}else if(tmp==2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		check=new boolean[chicken.size()];
		permu(0,0,chicken.size());
		System.out.println(answer);
	}
	
	static public void permu(int start,int dep,int size) {
		if(dep==m) {
			ans();
			return;
		}
		for(int i=start;i<size;i++) {
			check[i]=true;
			permu(i+1,dep+1,size);
			check[i]=false;
		}
	}
	
	static public void ans() {
		int sum=0;
		for(Point h:houses) {
			int tmp = Integer.MAX_VALUE;
			for(int i=0;i<check.length;i++) {
				if(!check[i]) continue;
				tmp = Math.min(tmp, calc(h, chicken.get(i)));
			}
			sum+=tmp;
		}
		answer= answer>sum?sum:answer;
	}
	
	static int calc(Point a,Point b) {
		return Math.abs(b.x-a.x)+Math.abs(b.y-a.y);
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
}