package gitCodding;

import java.io.*;
import java.util.*;

public class MaxHeap {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());			
			
			if(x == 0) {
				if(priQ.isEmpty() == true) {
					System.out.println(0);
				}
				else {
					System.out.println(priQ.poll());
				}
			}
			else {
				priQ.add(x);
			}
		}
	}

}
