def solution(progress, speed):
    answer = []
    time = 0
    count = 0
    
    while len(progress) > 0:
        if progress[0] + time * speed[0] >= 100:
            progress.pop(0)
            speed.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    return answer
