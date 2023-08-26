import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static int N;
	static boolean[] v;
	static int[][] records;
	static int C =0;
	
	static int[] move(int[] base, int hit) {
		if(hit==4) return new int[]{0,0,0,0};
		for (int i = 3; i>=0; i--) {
			if(i-hit<0) {
				base[i] = 0;
				continue;
			}
			base[i] = base[i-hit];
			base[i-hit] =0;
		}
		return base;
	}
	static int getScore(int[] base, int hit) {
		int score = 0;
		for (int i = 3; i >= 4-hit; i--) {
			if(base[i] ==1) score ++;
		}
		return score;
	}
	static void Game(int[] lineup) {
		//  총점       이닝       타순      아웃카운트 
		int total = 0, ining = 0, order = 0,out = 0;
		int cur, res;
		int[] base= {0,0,0,0}; // home -> 1st base -> 2nd base -> 3rd base 
		while(ining < N) {
			cur = lineup[order];
			res = records[ining][cur];
			if(res == 0) {
				out ++;
				if(out==3) {
					out = 0;
					ining ++;
					Arrays.fill(base, 0);
				}
			}
			else {
				base[0] = 1;
				total += getScore(base, res);
				base = move(base, res);
			}
			order = (order+1)%9;
		}
		
		ans = Math.max(ans, total);
	}
	static void perm(int cnt,int[] lineup) {
		if(cnt == 3) {
			 lineup[cnt] = 0;
			 perm(cnt+1, lineup);
			 return;
		}
		if(cnt == 9) {
			Game(lineup);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(v[i]) continue;
			v[i] = true;
			lineup[cnt] = i;
			perm(cnt+1, lineup);
			v[i] = false;
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ans = 0;
		N = Integer.parseInt(br.readLine());
		records = new int[N][9];
		int[] lineup = new int[9];
		v = new boolean[9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) records[i][j] = Integer.parseInt(st.nextToken());
		}
		v[0] = true;
		perm(0,lineup);
		System.out.println(ans);
	}
}
