import java.io.*;
import java.util.*;

public class Main {
	static int N, minCost, start;
	static boolean[] visited;
	static int[][] g;
	static void solve(int cur, int cost , int cnt){
		if(cost >= minCost) return;
		if(cnt == N - 1) {
			if(g[cur][start] != 0) minCost = Math.min(minCost, cost + g[cur][start]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i] && g[cur][i] != 0) {
				visited[i] = true;
				solve(i, cost + g[cur][i], cnt + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		g = new int[N][N];
		minCost = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) g[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			start = i;
			visited = new boolean[N];
			visited[i] = true;
			solve(i, 0, 0);
			visited[i] = false;
		}
		System.out.println(minCost);
	}
}
