import java.io.*;
import java.util.*;
class Carrot implements Comparable<Carrot>{
    long w;
    long p;

    public Carrot(long w, long p){
        this.w= w;
        this.p= p;
    }

    @Override
    public int compareTo(Carrot c) {
        return (int)(this.p- c.p);
    }
}
public class Main {
    static int N;
    static int T;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        T= Integer.parseInt(st.nextToken());
        long answer = 0;
        PriorityQueue<Carrot> carrots= new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            long w= Integer.parseInt(st.nextToken());
            long p= Integer.parseInt(st.nextToken());
            carrots.offer(new Carrot(w,p));
        }
        
        int cnt= 0;
        while(!carrots.isEmpty()){
           Carrot carrot= carrots.poll();
           answer += (T - N + cnt++) * carrot.p + carrot.w;
        }

        System.out.println(answer);
    }
}