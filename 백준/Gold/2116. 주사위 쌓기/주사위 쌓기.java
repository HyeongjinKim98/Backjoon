// 주사위 쌓기

import java.util.*;
import java.io.*;
public class Main {

    static int N, tmp, result;
    static int[] op;
    static int[][] dices;
    static void solve(int depth, int side, int acc){
        if(depth==N){
            tmp = Math.max(acc, tmp);
            return;
        }

        // 윗면 index
        int op1_idx = 1;

        for (int i = 1; i <= 6; i++) {
            if(dices[depth][i]== side){
                op1_idx = i;
                break;
            }
        }
        // 밑면 index
        int op2_idx = op[op1_idx];
        int otherside = dices[depth][op2_idx];

        // 옆면중 최대값
        int max_side=0;
        for (int i = 6; i >= 1; i--) {
            if(i != side && i != otherside){
                max_side = i;
                break;
            }
        }
        solve(depth+1, dices[depth][op2_idx], acc+max_side);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dices = new int[N][7];

        result = N*6;
        tmp = 0;

        //0 <-> 5
        //1 <-> 3
        //2 <-> 4
        op = new int[] {0, 6, 4, 5, 2, 3, 1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                dices[i][j] += Integer.parseInt(st.nextToken());
            }
        }

//        solve(0, N, 1, 0);
        for (int i = 1; i <= 6; i++) {
            solve(0, dices[0][i], 0);
        }

        System.out.println(tmp);
    }
}