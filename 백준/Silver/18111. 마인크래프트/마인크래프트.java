import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int solve(int[][] map ,int n ,int m,int current_height, int blocks){
        int time = 0;

        // 1. 깎아서 블록을 얻기위한 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치가 정해진 높이보다 높다면 깎는다 -> 2초
                if(map[i][j] > current_height){
                    // 그리고 차이만큼 보유 블록 개수가 늘어난다
                    int block_cut = map[i][j] - current_height;
                    blocks += block_cut;

                    // 2초 소요
                    time += 2 * block_cut;
                }
                if (map[i][j] < current_height) {

                    // 보유 블록 개수가 차이만큼 줄어든다.
                    int block_needed = current_height - map[i][j];

                    blocks -= current_height - map[i][j];
                    // 1초 소요
                    time += block_needed;
                }
            }
        }
        return (blocks>=0) ? time : -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 변수 입력
        // N : 가로 길이
        // M : 세로 길이
        // B : 보유 블럭 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 초기 상태에서 최고 높이와 최저 높이를 저장한다.
        int max_height = 0;
        int min_height = Integer.MAX_VALUE;

        // 결과로 출력할 시간과 높이 변수 할당.
        int answer_time   = Integer.MAX_VALUE;
        int answer_height = 0;

        int [][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(map[i][j], max_height);
                min_height = Math.min(map[i][j], min_height);
            }
        }
        // 최고 높이 ~ 최저 높이에 대해 실행
        for (int height = max_height; height >= min_height ; height--) {
            int result = solve(map,N,M,height,B);
            if (result == -1) continue;

            // 최소시간을 구해야 하므로 현재 최소 시간보다 결과값이 더 작은경우라면
            // 최소시간을 갱신 후 높이도 같이 갱신
            if(result < answer_time){
                answer_time = result;
                answer_height = height;
            }
            // 시간은 동일하되 높이가 더 높은 경우는 고려할 필요 x
            // for문 자체가 높이에 대해 감소 연산을 하면서 진행되므로!
        }
        System.out.println(answer_time+" "+answer_height);

    }
}