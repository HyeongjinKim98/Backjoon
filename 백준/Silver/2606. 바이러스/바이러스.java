import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visited;
    static boolean[][] map;

    static int BFS(){
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for (int i = 1; i <= N; i++) {

                if(map[current][i] && !visited[i] ){
                    cnt ++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
            map[b][a] = true;
        }

        System.out.println(BFS());
    }
}