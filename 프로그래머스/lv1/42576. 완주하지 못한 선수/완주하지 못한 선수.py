def solution(participant, completion):
    athlete = {}
    hash_sum = 0
    for p in participant:
        athlete[hash(p)] = p
        hash_sum += hash(p)
    for c in completion:
        hash_sum -= hash(c)
    answer = athlete[hash_sum]
    return answer