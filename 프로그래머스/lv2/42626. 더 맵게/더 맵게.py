import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        if len(scoville) == 1:
            return -1
        new_scoville = heapq.heappop(scoville) + heapq.heappop(scoville) * 2
        heapq.heappush(scoville, new_scoville)
        answer += 1
    
    return answer