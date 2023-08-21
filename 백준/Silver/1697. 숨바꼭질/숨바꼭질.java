import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int subin,bro,N;
	static List<Integer>[] map;
	static int[] v;
	static void has(int subin) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(subin);
		v[subin] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == bro) {
				System.out.println(v[cur]);
				return;
			}
			if(cur+1 <= N && v[cur+1]==0) {
				q.offer(cur+1);
				v[cur+1] = v[cur]+1;
			}
			if(cur-1 >= 0 && v[cur-1]==0) {
				q.offer(cur-1);
				v[cur-1] = v[cur]+1;
			}
			if(cur*2<=N && v[2*cur]==0) {
				q.offer(cur*2);
				v[cur*2] = v[cur]+1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		bro = sc.nextInt();
		
		if(subin>=bro) {
			System.out.println(subin-bro);
			return;
		}
		N = bro *2;
		v = new int[N+1];
		v[subin] = 0;
		has(subin);
		sc.close();
	}
}
