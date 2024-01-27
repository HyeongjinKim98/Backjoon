import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0,0,0,0}; // {정점 번호, 도넛, 막대, 8자}

        Map<Integer,int[]> count = new HashMap<>(); //정점 번호와 {나가는 간선 수, 들어오는 간선 수}

        for (int[] edge : edges){
            int start = edge[0];
            int end = edge[1];

            if(!count.containsKey(start)){
                count.put(start, new int[]{0,0});
            }
            if(!count.containsKey(end)){
                count.put(end, new int[]{0,0});
            }

            count.get(start)[0] ++;
            count.get(end)[1] ++;
        }

        // 순회하면서 정점의 나가는 간선과 들어오는 간선의 수를 체크하여 판별
        for (int key : count.keySet()){
            int[] cur= count.get(key);
            int in= cur[1];
            int out= cur[0];

            if(in== 0 && out >=2){
                answer[0] = key; // 1. 시작 정점 찾기
            }else if(in> 0 && out== 0){
                answer[2] ++; // 2. 막대그래프
            }else if(in>= 2 && out>= 2){
                answer[3] ++; // 3. 8자그래프
            }
        }

        // 4. 도넛그래프
        answer[1] = count.get(answer[0])[0]  -answer[2] - answer[3];
        return answer;
    }
}