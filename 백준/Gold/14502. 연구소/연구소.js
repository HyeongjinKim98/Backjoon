const input =
    require('fs').readFileSync(process.platform === "linux" ? "/dev/stdin" : "input2.txt")
    .toString().split("\n")
const [N, M] = input[0].split(' ').map(e => parseInt(e))

let answer = 0;
const matrix = [];
const dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];
for (let i = 1; i <= N; i++) {
    matrix.push(input[i].split(' ').map(e => parseInt(e)))
}

const DFS = (walls) => {
    if(walls === 3){
        let map = matrix.map((e) =>[...e]);
        let safe = Count(map);
        answer = Math.max(answer, safe);
        return;
    }
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if(matrix[i][j] === 0){
                matrix[i][j] = 1;
                DFS(walls+1);
                matrix[i][j] = 0;
            }
        }
    }
}
const Count = (map) => {
    let cnt = 0;
    let q = [];
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (map[i][j] === 2) q.push([i, j]);
        }
    }
    while(q.length){
        const [ci, cj] = q.shift();
        for (const [di, dj] of dir) {
            const ni = ci + di;;
            const nj = cj + dj;
            if(ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] !== 0) continue;
            map[ni][nj] = 2;
            q.push([ni,nj]);
        }
    }
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if(map[i][j] === 0) cnt++;
        }
    }
    return cnt;
}

DFS(0);
console.log(answer);