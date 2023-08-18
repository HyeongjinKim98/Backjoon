import java.io.*;
import java.util.*;

public class Main {
	static int min;
	static void escape(int[][] maze, boolean[][] v,int[] di, int[] dj, int N, int M, int dist, int i , int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];

			if(i == N-1 && j == M-1) {
				min = Math.min(min, maze[i][j]);
				return;
			}
			if(dist>= min) return;

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj] && maze[ni][nj]==1) {
					v[ni][nj] = true;
					maze[ni][nj] = maze[i][j]+1;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		min = N*M;
		
		int[] di = {-1, 0, 1,  0};
		int[] dj = { 0, 1, 0, -1};
		
		int[][] maze = new int[N][M];
		boolean[][] v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j)-48;
			}
		}
		v[0][0] = true;
		escape(maze, v, di, dj, N, M, 0, 0, 0);
		System.out.println(min);
	}
}