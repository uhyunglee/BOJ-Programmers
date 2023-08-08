def solution(routes):
    answer = 0
    # 정렬 / 빨리 나가는 차량 순서, 먼저 들어오는 순서 순으로 정렬
    routes.sort(key = lambda x : (x[1], x[0]))
    # 처음 나가는 차량의 시간
    last_time = routes[0][1]
    
    # 처음 설치된 cctv 
    answer = 1
    
    for i in range(1, len(routes)):
        # 만약 현 나가는 시간과 뒤 들어오는 시간이 같거나 작으면 
        if last_time < routes[i][0]:
            # 새로운 cctv 추가 설치
            answer += 1
            # 나가는 차량 시간으로 다시 세팅
            last_time = routes[i][1]
            
    return answer