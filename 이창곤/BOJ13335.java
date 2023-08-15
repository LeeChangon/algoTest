package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //트럭의 수 
        int w = Integer.parseInt(st.nextToken()); //다리 길이
        int L = Integer.parseInt(st.nextToken()); //최대 하중
       
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
         st = new StringTokenizer(br.readLine());
         
        for(int i=0; i<n; i++) {
            truck.add(Integer.parseInt(st.nextToken())); //트럭 입력
        }
        for(int i=0; i<w; i++) {
        	bridge.add(0);			//다리큐에 0을 채움
        }

        int cnt = 0;		// 이동 시간 카운트
        int sum = 0;		// 최대 하중 계산

        while(!bridge.isEmpty() || !truck.isEmpty()) {	//큐 두개가 전부 빌 때 까지
            if(!bridge.isEmpty()) sum -= bridge.poll(); //다리에서 빠져 나가면 하중을 빼줌
            
            if(!truck.isEmpty()) {
	            if(truck.peek() + sum <= L) {	//남은 트럭이 있고 최대 하중에 걸리지 않으면
	                sum += truck.peek();		//최대 하중에 더해주고
	                bridge.add(truck.poll());	//트럭을 다리에 넣음
	            }
	            else {
	            	bridge.add(0);	//하중 때문에 트럭이 못들어가면 0을 채움
	            }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}