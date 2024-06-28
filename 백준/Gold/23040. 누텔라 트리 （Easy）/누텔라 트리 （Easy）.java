import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;

    static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int larger = parents[a] < parents[b] ? a : b;
        int smaller = parents[a] < parents[b] ? b : a;
        parents[larger] += parents[smaller];
        parents[smaller] = larger;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        char[] leafColor = new char[N + 1];
        String colorInput = br.readLine();
        for (int i = 1; i <= N; i++) {
            leafColor[i] = colorInput.charAt(i - 1);
        }

        boolean[] colors = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            colors[i] = leafColor[i] == 'R';
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adjList.get(current)) {
                if (visited.contains(next)) continue;
                visited.add(next);
                if (colors[current] && colors[next]) {
                    union(current, next);
                }
                queue.add(next);
            }
        }

        long result = 0;
        for (int i = 1; i <= N; i++) {
            if (colors[i]) continue;

            Set<Integer> componentVisited = new HashSet<>();
            for (int next : adjList.get(i)) {
                if (!colors[next] || componentVisited.contains(find(next))) continue;
                componentVisited.add(find(next));
                result += -parents[find(next)];
            }
        }

        System.out.println(result);
    }
}