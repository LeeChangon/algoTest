package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
	static Stack<Character> stack;
	static Queue<Character> q;
	//셔플 수 입력값이 매우 크기 때문에 원점이 되는 수를 찾아 셔플 수를 줄여줍니다.
	static int find(StringBuilder sb) {
		int cnt = 0;
		String ss = sb.toString();
		
		do {
			sb = shuffle(sb);
			cnt ++;
		} while(!sb.toString().equals(ss));
		
		return cnt;
	}
	//규칙을 찾아서 한 번의 셔플에 짝수번째 알파벳은 앞에 큐로 뿌려주고
	//홀수번째 알파벳은 스택에 넣어 뒤에 뿌려줍니다
	static StringBuilder shuffle(StringBuilder sb) {
		stack = new Stack<>();
        q = new LinkedList<>();

		for(int i=0; i<sb.length(); i+=2) q.add(sb.charAt(i));
		for(int i=1; i<sb.length(); i+=2) stack.add(sb.charAt(i));
			
		sb = new StringBuilder();
		while(!q.isEmpty()) sb.append(q.poll());
	
		while(!stack.isEmpty()) sb.append(stack.pop());
        
		return sb;
		
	}
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        
        n = n % find(sb);//반복 횟수를 줄입니다.
        for(int i=0; i<n; i++) {
        	sb = shuffle(sb);
        }

        System.out.println(sb);
	}
}
