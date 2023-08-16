package gitCodding;

import java.io.*;
import java.util.*;

public class DNAComb {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        HashSet<String> DNA = new HashSet<>();
        HashSet<String> DNA2 = new HashSet<>();
        //String DNA[][] = new String[N][2];
        HashSet<String> result = new HashSet<>();
        
        ArrayList<String> DNA_fin;
        
        for(int i = 0; i < N; i++) {
            String m = st.nextToken();
            
            if(!DNA.add(m)) {
                DNA2.add(m);
            }
        }
        
        DNA_fin = new ArrayList<>(DNA);
        DNA_fin.addAll(DNA2);
        
        for(int i = 0;  i < DNA_fin.size(); i++) {
            String f = DNA_fin.get(i).split("")[0];
            for(int j = 0; j < DNA_fin.size(); j++) {
                
                String b = DNA_fin.get(j).split("")[1];
                if(i != j) {
                    if(f.compareTo(b) > 0) {
                        result.add(f);
                    }
                    else {
                        result.add(b);
                    }
                }
            }
        }
        
        List<String> s_result = new ArrayList<String>(result);
        Collections.sort(s_result);
        
        sb.append(s_result.size()).append("\n");
        
        for(int i = 0; i < s_result.size(); i++) {
            sb.append(s_result.get(i)).append(" ");
        }    
        
        System.out.println(sb);

    }

}
