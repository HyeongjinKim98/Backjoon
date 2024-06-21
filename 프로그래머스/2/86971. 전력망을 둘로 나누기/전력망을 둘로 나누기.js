function solution(n, wires) {
    var answer = 100;
    let tree = Array.from({ length: n + 1 }, () => []);
    for (const wire of wires) {
        if (wire.length === 0) continue;
        let [a, b] = wire;
        tree[a].push(b);
        tree[b].push(a);
    }

    function BFS(start, except) {
        let visited = Array(n + 1).fill(false);
        let queue = [start];
        let cnt = 0;
        visited[start] = true;

        while (queue.length !== 0) {
            var cur = queue.shift();
            cnt++;

            for (const next of tree[cur]) {
                if (!visited[next] && next !== except) {
                    visited[next] = true;
                    queue.push(next);
                }
            }
        }
        return cnt;
    }

    for (const wire of wires) {
        if (wire.length === 0) continue;
        let [a, b] = wire;
        let route1 = BFS(a, b);
        let route2 = BFS(b, a);
        if (route1 + route2 !== n) continue;
        answer = Math.min(Math.abs(route1 - route2), answer);
    }

    return answer;
}
