from itertools import permutations

def solution(k, dg):
    answer = -1
    candidates = list(permutations([x for x in range(len(dg))], len(dg)))

    for candidate in candidates:
        temp, cnt = k, 0
        for idx in candidate:
            if temp >= dg[idx][0]:
                temp -= dg[idx][1]
                cnt += 1
        answer = max(answer, cnt)

    return answer