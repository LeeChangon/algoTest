import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static PriorityQueue<Edge> q;

    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int val;
        public Edge(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Edge e) {		//프라이오리티 큐를 
           return Integer.compare(this.val, e.val);
        }
    }

    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
        if(a > b) parent[a] = b;		// 더 작은 값을 부모로 찍는다.
        else parent[b] = a;
    }

    static int find(int n) {
        if(parent[n] == n) return n;
        else return parent[n] = find(parent[n]);	// 탐색 줄이기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        parent = new int[V + 1];
        int result = 0;
        q = new PriorityQueue<>();
        
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine());
        	q.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i=0; i< V + 1; i++) parent[i] = i;
        
        while(!q.isEmpty()) {
        	Edge e = q.poll();

          	if(find(e.a) != find(e.b)) {
              	union(e.a, e.b);
              	result += e.val;
          	}
        }
        System.out.println(result);
    }
}
