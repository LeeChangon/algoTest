package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
	static StringBuilder sb;
	static Map<String , String[]> tree;
	
	static void preorder(String node) {
		sb.append(node);
		if(!tree.get(node)[0].equals(".")) preorder(tree.get(node)[0]);		
		if(!tree.get(node)[1].equals(".")) preorder(tree.get(node)[1]);
	}
	
	static void inorder(String node) {
		if(!tree.get(node)[0].equals(".")) inorder(tree.get(node)[0]);
		sb.append(node);
		if(!tree.get(node)[1].equals(".")) inorder(tree.get(node)[1]);
	}
	
	static void postorder(String node) {
		if(!tree.get(node)[0].equals(".")) postorder(tree.get(node)[0]);
		if(!tree.get(node)[1].equals(".")) postorder(tree.get(node)[1]);
		sb.append(node);
	}
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        tree = new HashMap<>();
        sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String nd = st.nextToken();
        	String l = st.nextToken();
        	String r = st.nextToken();
        	tree.put(nd, new String[2]);
        	tree.get(nd)[0] = l;
        	tree.get(nd)[1] = r;
        }
                
        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");
        sb.append("\n");
        System.out.println(sb);
        
	}
}