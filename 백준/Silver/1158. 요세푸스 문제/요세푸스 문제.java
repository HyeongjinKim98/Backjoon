import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Deque<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(!q.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll());
			if(q.isEmpty())continue;
			sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}