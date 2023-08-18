import java.util.*;
import java.io.*;
public class Main {
	static int Max;
	static void solve(char[][] map, boolean[] apb, boolean[][] v, int[] di, int[] dj,int R, int C, int i , int j, int cnt){
		apb[map[i][j]-65] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<R && 0<=nj && nj<C && !v[ni][nj]&& !apb[map[ni][nj]-65]) {
				v[i][j] = true;
				apb[map[ni][nj]-65] = true;
				solve(map, apb, v, di, dj, R, C, ni, nj, cnt+1);
				apb[map[ni][nj]-65] = false;
				v[i][j] = false;
			}
		}
		Max = Math.max(Max, cnt);
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] di = {-1, 0, 1,  0};
		int[] dj = { 0, 1, 0, -1};
		
		char[][] map = new char[R][C];
		boolean[] apb = new boolean[26];
		boolean[][] v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			
			for (int j = 0; j < C; j++)
				map[i][j] = input.charAt(j);
		}

		solve(map, apb, v, di, dj, R, C, 0, 0, 1);
		System.out.println(Max);
	}
}