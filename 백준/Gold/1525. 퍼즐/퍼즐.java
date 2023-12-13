import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String,Integer> check = new HashMap<>();
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = { 0, 1, 0,-1};
    static final String answer = "123456780";
    static int bfs(String init){
        Queue<String> q = new ArrayDeque<>();
        q.offer(init);

        while(!q.isEmpty()){
            String map = q.poll();
            int depth = check.get(map);
            int zero = map.indexOf('0');
            int i = zero%3;
            int j = zero/3;

            if(map.equals(answer)) return depth;
            for(int d = 0; d <4 ; d++){
                int ni = i + di[d];
                int nj = j + dj[d];

                if(ni < 0 || ni >2 || nj < 0 || nj > 2) continue;

                int idx = ni + nj * 3;
                char next = map.charAt(idx);

                String current_map = map.replace(next,'n');
                current_map = current_map.replace('0', next);
                current_map = current_map.replace('n','0');


                if(check.get(current_map) == null){
                    check.put(current_map, depth +1);
                    q.offer(current_map);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String map = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int current = Integer.parseInt(st.nextToken());
                map += current;
            }
        }
        check.put(map, 0);
        System.out.println(bfs(map));
    }
}