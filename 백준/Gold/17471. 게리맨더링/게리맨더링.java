import java.util.*;
import java.io.*;
public class Main {
	static int ans = Integer.MAX_VALUE;
	
	static int check(List<Integer>[] map, boolean[] v, int cnt, int N, int s) {
		int c = 1;
		boolean[] visited = new boolean[N+1];
		visited = v.clone();
		boolean flag = visited[s];
		if(cnt ==1) {
			return 1;
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		while(!q.isEmpty()) {
			int p = q.poll();
			visited[p] = !flag;
			for (int i = 0; i < map[p].size(); i++) {
				if(visited[map[p].get(i)] == flag) {
					q.offer(map[p].get(i));	
					visited[map[p].get(i)] = !flag;
					c ++;
				}
			}
		}
		return c;
	}
	static void comb(boolean[] v ,List<Integer>[] map, int[] pop, int cnt, int N, int sum, int acc) {
		if(cnt >1 && N+1>= cnt) {		
			int g = Math.abs(acc - ( sum - acc ));
			int a = 0;
			int b = 0;
			for (int i = 1; i <= N; i++) {
				if(v[i] == true  && a == 0) a = i;
				if(v[i] == false && b == 0) b = i;
			}
			if(a>0 && b>0) {
				if(check(map,v,cnt,N,a) + check(map,v,N-cnt,N,b) == N) {
					ans = Math.min(ans, g);
				}
			}
			if(cnt == N+1) return;
		}
		
		v[cnt] = true;
		comb(v,map,pop,cnt +1,N,sum,acc+pop[cnt]);
		
		v[cnt] = false;
		comb(v,map,pop,cnt +1,N,sum,acc);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		
		int[] pop = new int[N+1];
		List<Integer>[] map = new ArrayList[N+1];
		boolean[] v= new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <=N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			map[i] = new ArrayList<>();
			sum += pop[i];
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int edges = Integer.parseInt(st.nextToken());
			for (int j = 0; j < edges; j++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		comb(v, map, pop, 1, N, sum, 0);
		System.out.println((ans==Integer.MAX_VALUE)?-1:ans);
		
	}
}
