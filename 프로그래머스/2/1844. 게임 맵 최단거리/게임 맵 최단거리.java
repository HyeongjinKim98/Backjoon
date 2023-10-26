import java.util.*;

class Solution {
    static int R, C,min_depth;
    static int MAX;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = { 0, 0, 1, -1};
    public int solution(int[][] maps) {
        min_depth = MAX;
        R = maps.length;
        C = maps[0].length;
        BFS(maps);
        return (min_depth == MAX) ? -1 : min_depth;
    }

    // BFS
    public void BFS(int[][] map){
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0});
        int[][] v = new int[R][C];
        v[0][0] = 1;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int i = current[0];
            int j = current[1];

            if(i == R-1 && j == C-1) min_depth = v[i][j];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(isOutOfBound(ni, nj)) continue;

                if(map[ni][nj] == 1 && v[ni][nj] ==0){
                    map[i][j] = MAX;
                    v[ni][nj] = v[i][j] + 1;
                    q.offer(new int[] {ni, nj});
                }
            }
        }
    }

    // 해당 좌표 { i , j }가 영역을 벗어났는지 여부를 boolean 타입으로 반환
    public boolean isOutOfBound(int i, int j){
        return ( i < 0 || i >= R || j < 0 || j >= C);
    }
}