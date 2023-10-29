import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int LENGHT;
    static StringBuilder sb;

    static ArrayList<String> routes;
    static boolean[] v;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        LENGHT = tickets.length;
        v = new boolean[LENGHT];
        routes = new ArrayList<>();
        solve(tickets, "ICN", "ICN", 0);
        Collections.sort(routes);
        return routes.get(0).split(" ");
    }
    public void solve(String[][] tickets , String before, String after, int depth){
        if(depth == LENGHT){
            routes.add(after);
            return;
        }
        for (int i = 0; i < LENGHT; i++) {
            if(tickets[i][0].equals(before) && !v[i]){
                v[i] = true;
                solve(tickets, tickets[i][1], after+" "+ tickets[i][1], depth+1);
                v[i] = false;
            }
        }
    }
}