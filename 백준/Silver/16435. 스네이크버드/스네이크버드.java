import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		ArrayList<Integer> fruits = new ArrayList<>();
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) fruits.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(fruits);
		
		for (Integer fruit : fruits) {
			if(fruit<=snake) snake++;
			else break;
		}
		System.out.println(snake);
	}
}