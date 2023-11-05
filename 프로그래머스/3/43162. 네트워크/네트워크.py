def solution(n, computers):
    answer = 0
    visited = [0]*n # 방문할 전체 노드 생성
    
    def dfs(graph, v):
        visited[v] = True
        #노드 방문 기록 (True는 1)
        n = len(graph)

        for node in range(n):
            if graph[v][node] == 1 and visited[node] == False:
                #0 == False 방문체크기 때문에 true false 
                #방문하지 않은 노드이고 연결된 노드면 계속 방문 체크(dfs 탐색)
                dfs(graph, node)
                
    for start in range(n): # n개의 node를 각각 시작 노드로 dfs
        if visited[start] == 0: # 이전 탐색에서 방문하지 않았을 경우에만 탐색 시작
            dfs(computers, start)
            answer += 1
    
    return answer