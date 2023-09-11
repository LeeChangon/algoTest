package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visit;
	static StringBuilder sb;
	static String[] symbols;
	static List<String> list;
	
	static void recur(int depth, String s) {
		if(depth == N) {
			list.add(s);
			
			return;
		}
		
		int fnum = Character.getNumericValue(s.charAt(depth));
		
		if(symbols[depth].equals(">")) {
			for(int i=0; i<fnum; i++) {
				if(!visit[i]) {
					visit[i] = true;
					recur(depth + 1, s + i + "");
					visit[i] = false;
				}
			}
		}
		else {
			for(int i=fnum + 1; i<10; i++) {
				if(!visit[i]) {
					visit[i] = true;
					recur(depth+1, s + i+"");
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());		
		visit = new boolean[10];
		symbols = new String[N];
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			symbols[i] = st.nextToken();
		}
		
		
		for(int i=0; i<10; i++) {
			visit[i] = true;
			recur(0, i + "");
			visit[i] = false;
		}
		Collections.sort(list);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}
}