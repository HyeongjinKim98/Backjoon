import java.io.*;
import java.util.*;

public class Main {
    // N : 건물종류 M : 관계 수
    static int N, M, K;
    static int[] field, degree;
    // 건물이 지어졌는지 여부 판단할 int배열 (중복건설 가능)
    static List<Integer>[] relation;

    static boolean[] buildingIdx;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[N+1];
        degree = new int[N+1];
        relation = new ArrayList[N+1];


        // 최대 관계 수 : 3
        for (int i = 1; i <= N; i++) relation[i] = new ArrayList<>(3);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            degree[b]++;
        }
        // 게임 정보
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // 짓기
            if(cmd == 1){
                if(degree[target] > 0){
                    System.out.println("Lier!");
                    return;
                }
                // 진입차수를 1씩 내려준다
                field[target] ++;

                if(field[target] == 1 && relation[target].size() > 0 ){
                    for(int rel : relation[target]) {
                        degree[rel]--;
                    }
                }
            }

            // 부수기
            if(cmd == 2){
                if(field[target] == 0){
                    System.out.println("Lier!");
                    return;
                }else{
                    // 건물이 있으면 부수기
                    field[target] --;

                    // 건물 수가 0이 되면
                    if(field[target] == 0 && relation[target].size() >0){
                        for(int rel : relation[target]) {
                            degree[rel]++;
                        }
                    }
                }


            }
        }
        System.out.println("King-God-Emperor");
    }
}