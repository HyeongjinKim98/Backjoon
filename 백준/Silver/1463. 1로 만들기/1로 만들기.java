import java.util.Scanner;
public class Main {
	
	static int solve(int N, int c) {
		if(N < 2) return c;
		return Math.min(solve(N/2, c + N%2 + 1), solve(N/3, c+ N%3 + 1));
	}
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(solve(N,0));
		sc.close();
	}
}