import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 0; tc < T; tc++) {
            int res = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());


            // 원의 중심 간 거리
            double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
            int rr = r1 +r2;
            int RR = Math.abs(r1-r2);

            // 일치
            if(distance == 0 && r1==r2){
                res  = -1;
            }
            // 내부 (접하지 x)
            else if(distance < RR){
                res = 0;
            }
            // 내접
            else if(distance == RR){
                res = 1;
            }
            // 외부 (접하지 x)
            else if(distance > rr){
                res = 0;
            }
            // 외접
            else if(distance == rr){
                res = 1;
            }
            // 겹칠 때
            else{
                res = 2;
            }
            System.out.println(res);
        }
    }
}