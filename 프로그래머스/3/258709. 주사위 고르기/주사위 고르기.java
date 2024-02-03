import java.util.*;

class Solution {
    static int L;
    static boolean[] v;
    static List<Integer> DiceA;
    static List<Integer> DiceB;
    static List<boolean[]> diceComb;
    public int[] solution(int[][] dice) {
        int max = 0;
        int[] answer = {};
        L = dice.length;
        v = new boolean[L];
        diceComb = new ArrayList<>();
        perm(0,0);

        for (boolean[] comb : diceComb) {
            int idxA = 0;
            int idxB = 0;

            int[] combA = new int[L/2];
            int[] combB = new int[L/2];
            for(boolean tf : comb){
                if(tf)combA[idxA++]=idxA+idxB;
                else combB  [idxB++] =idxA+idxB;
            }

            int win = 0;

            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();

            getSum(0,0,combA,dice,sumA);
            getSum(0,0,combB,dice,sumB);

            Collections.sort(sumA);
            Collections.sort(sumB);

            int bIdx = 0;
            for(int a : sumA){
                while(bIdx < sumB.size() && sumB.get(bIdx) < a) {
                    bIdx++;
                }
                win += bIdx;
            }

            if(win > max){
                max = win;
                answer = combA;
            }
        }

        return answer;
    }

    void perm (int depth, int idx){
        if (depth==L/2) {
            diceComb.add(v.clone());
            return;
        }

        for (int i = idx; i < L; i++) {
            if (!v[i]) {
                v[i] = true;
                perm(depth + 1, i + 1);
                v[i] = false;
            }
        }
    }
    void getSum(int idx, int sum, int[] comb, int[][] dice, List<Integer> sumList){
        if(idx==L/2){
            sumList.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            getSum(idx+1, sum+dice[comb[idx]-1][i], comb, dice, sumList);
        }
    }

}