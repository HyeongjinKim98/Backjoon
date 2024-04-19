import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());

        List<Long> SA = new ArrayList<>();
        set(SA,A);
        List<Long> SB = new ArrayList<>();
        set(SB,B);

        long res = 0;
        int a = 0;
        int b = SB.size()-1;
        while(a<SA.size() && b>=0){
            long sa = SA.get(a);
            long sb = SB.get(b);
            long sum = sa+sb;

            if(sum < T) a++;
            else if(sum > T) b--;
            else{
                long ea = 0;
                while(a<SA.size() && sa==SA.get(a)){
                    a++;
                    ea++;
                }

                long eb = 0;
                while(b>=0 && sb==SB.get(b)){
                    b--;
                    eb++;
                }

                res += ea*eb;
            }
        }
        System.out.println(res);
    }

    static void set(List<Long> sum, int[] arr){
        for(int i=0;i<arr.length;i++){
            long val = 0;
            for(int j=i;j<arr.length;j++){
                val += arr[j];
                sum.add(val);
            }
        }
        Collections.sort(sum);
    }
}