import java.io.*;
import java.util.*;

public class Main{
	static int N,M;
	static List<Integer>[] col;
	static boolean[] v;
	static StringBuilder sb;
	static void solve(int i) {
		v[i] = true;
		for (int j = 0; j < col[i].size(); j++) {
			int next= col[i].get(j);
			if(!v[next]) {
				v[next] = true;
				solve(next);
			}
		}
		sb.append(i).append(" ");
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		col = new ArrayList[N+1];
		v = new boolean[N+1];
		for (int i = 1; i < col.length; i++) {
			col[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			col[b].add(a);
		}
		
		for (int i = 1; i <=N; i++) {
			if(!v[i]) {
				solve(i);
			}
		}
		System.out.println(sb.toString());
	}
}
