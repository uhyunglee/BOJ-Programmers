import heapq

def solution(jobs):
    jobs.sort()
    
    n = len(jobs)
    current_time = 0
    total_time = 0 
    
    queue = []
    
    while jobs or queue:
        while jobs and jobs[0][0] <= current_time:
            request_time, duration = jobs.pop(0)
            heapq.heappush(queue, (duration, request_time))
            
        if queue:
            duration, request_time = heapq.heappop(queue)
            current_time += duration
            total_time += current_time - request_time
        else:
            request_time, duration = jobs.pop(0)
            current_time = request_time + duration
            total_time += duration
            
    return total_time // n