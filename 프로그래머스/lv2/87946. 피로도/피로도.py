from itertools import permutations

def solution(k, dungeons):
    answer = -1
    candidates = list(permutations([x for x in range(len(dungeons))], len(dungeons)))

    for candidate in candidates:
        temp, cnt = k, 0
        for idx in candidate:
            if temp >= dungeons[idx][0]:
                temp -= dungeons[idx][1]
                cnt += 1
        answer = max(answer, cnt)

    return answer