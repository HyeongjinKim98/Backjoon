import java.util.*;
import java.io.*;

public class Main{
	static int N,C,res,cnt;
	static int[]  di = {-1, 0, 1, 0};
	static int[]  dj = { 0, 1, 0,-1};
	static List<Integer> ans = new ArrayList<>();
	static     int[][] danji;
	static boolean[][] v;
	
	static void solve(int i, int j) {
		cnt++;
		v[i][j] = true;
		danji[i][j] = C;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
			
			if(danji[ni][nj] > 0 && !v[ni][nj]) {
				solve(ni,nj);
			}
		}
		res = Math.max(res, cnt);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		danji = new int[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				danji[i][j] = line.charAt(j)-48;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(danji[i][j]>0&& !v[i][j]) {
					C++;
					solve(i,j);
					ans.add(res);
					res=0;
					cnt= 0;
				}
			}
		}
		ans.sort(Comparator.naturalOrder());
		System.out.println(C);
		for (int a : ans) {
			System.out.println(a);
		}
	}
}