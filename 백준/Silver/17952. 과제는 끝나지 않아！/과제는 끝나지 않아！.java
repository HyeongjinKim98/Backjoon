import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int TC = Integer.parseInt(br.readLine()); // 받을 업무의 갯수
		int score = 0; // 업무평가 점수
		
		// 해야할 업무를 저장할 deque
		Deque<int[]> q = new ArrayDeque<>();
		
		for (int tc = 0; tc < TC; tc++) {
			String line = br.readLine();
			st= new StringTokenizer(line);
			
			// isWork => 1 : 일이 있다, 0: 일이 없다
			int isWork = Integer.parseInt(st.nextToken());
			if(isWork==1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				q.offerFirst(new int[] {A,T}); //일이 생기면 해야할 업무 맨앞으로 놓는다.
			}
			

			// 해야할 업무가 있으면 하기
			if(!q.isEmpty()) {
				int[] current = q.poll();// 업무 deque에서 꺼낸다
				current[1] --; 			 // 1분 업무한다
				
				if(current[1]==0) score += current[0];  // 다했으면 해당 점수를 얻는다
				else q.offerFirst(current);				// 못했으면 다시 deque에 넣는다 
			}
		}
		
		//최종 업무평가점수를 출력한다
		System.out.println(score);
		br.close();
	}
}
