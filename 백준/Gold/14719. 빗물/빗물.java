import java.util.*;
import java.io.*;
public class Main {
    static int H,W;
    static int[] walls;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        walls = new int[W];
        // 시작

        int result = 0;
        for (int i = 0; i < W; i++) {
            walls[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W-1; i++) {
            int cur = walls[i];

            int L = 0;
            for (int j = 0; j < i; j++){
                L = Math.max(L,walls[j]);
            }

            int R = 0;
            for (int j = i+1; j < W; j++) {
                R = Math.max(R,walls[j]);
            }

            int tmp = Math.min(L,R) - cur;
            result += Math.max(tmp,0);
        }

        System.out.println(result);
    }
}