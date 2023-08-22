import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static void DFS(List<Integer>[] rel, boolean[] v, int M , int cnt , int cur) {
		if(cnt == 4) {
			ans = 1;
			return;
		}
		for (int r : rel[cur]) {
			if(!v[r]) {
				v[r] = true;
				DFS(rel, v, M, cnt+1, r);
				v[r] = false;
			}
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] rel = new ArrayList[N];
		boolean[] v= new boolean[N];
		
		for (int i = 0; i < N; i++) rel[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a].add(b);
			rel[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			v[i] = true;
			DFS(rel,v,M,0,i);
			v[i] = false;
			if(ans==1) break;
		}
		System.out.println(ans);
	}
}
