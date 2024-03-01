import java.io.*;
import java.util.*;

// 문제집
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> solves = new ArrayList<>();
        int[] inDegree = new int[N+1];

        for (int i = 0; i <= N; i++) {
            solves.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            solves.get(start).add(end);
            inDegree[end] ++;
        }

//        System.out.println(Arrays.toString(inDegree));
//        for (List li:
//            solves) {
//            System.out.println(li);
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i]==0){
                pq.offer(i); // 풀수있는것만
            }
        }

        StringBuilder sb= new StringBuilder();
//        System.out.println(Arrays.toString(inDegree));
        while(!pq.isEmpty()){
            int current = pq.poll();

            sb.append(current).append(" ");

            // 진입차수 내려주기
            for(int target : solves.get(current)){
                inDegree[target] --;
//                System.out.println(inDegree[target]);
                if(inDegree[target] == 0){
                    pq.offer(target); // 풀수있어
                }
            }
        }

        System.out.println(sb);
    }
}