import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int card = 0;
		boolean turn = true;
		int N = sc.nextInt();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) q.add(i);
		
		while(q.size()>0) {
			if(turn) {
				card = q.poll();
				turn = false;
			}else{
				card = q.poll();
				q.add(card);
				turn = true;
			}
		}
		System.out.println(card);
		sc.close();
	}
}